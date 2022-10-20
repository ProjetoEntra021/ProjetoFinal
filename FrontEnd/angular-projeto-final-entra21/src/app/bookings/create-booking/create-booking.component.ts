import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { NonNullableFormBuilder, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute, Router } from '@angular/router';

import { BookingsService } from '../../service/bookings.service';
import { CategoryService } from '../../service/category.service';
import { ClientService } from '../../service/client.service';
import { Category } from '../../shared/model/category';


@Component({
  selector: 'app-create-booking',
  templateUrl: './create-booking.component.html',
  styleUrls: ['./create-booking.component.scss']
})
export class CreateBookingComponent implements OnInit {

  bookingForm = this.formBuilder.group({
    id: 0,
    client: this.formBuilder.group({
      id: 0,
      name: '',
    }),
    pickUpDate: [new Date(), Validators.required],
    dropOffDate: [new Date(), Validators.required],
    bookingStatus: ["ACTIVE"],
    category: this.formBuilder.group({
      id: 0,
      name: '',
    }),
    dayPrice: 0,
    weekPrice: 0,
    previewPrice: 0,
  })

  categories: Category[] = [];

  rentalTypes = ["APP_DRIVER", "PERSONAL"]

  public bookingId!: number;
  public clientId!: number;
  public difDays!: number;
  public difWeeks!: number;

  public selectedCategory!: Category;

  constructor(
    private categoryService: CategoryService,
    private bookingsService: BookingsService,
    private clientService: ClientService,
    private formBuilder: NonNullableFormBuilder,
    private snackBar: MatSnackBar,
    private router: Router,
    private route: ActivatedRoute,
    private location: Location,
  ) { }

  ngOnInit(): void {
    this.categoryService.list().subscribe((data) => {
      this.categories = data;
    })
    this.route.params.subscribe(params => {
      this.bookingId = params['id'];
      if (this.bookingId) {
        this.getBooking();
      }

      this.route.params.subscribe(params => {
        this.clientId = params['idclient'];
        if (this.clientId) {
          this.getBookingClient();
        }
      })
    })
    this.searchCategory();

  }

  getBooking() {
    this.bookingsService.getBookingById(this.bookingId).subscribe(
      result => {
        console.log(result)
        this.bookingForm.patchValue({
          id: result.id,
          client: {
            id: result.client.id,
            name: result.client.name,
          },
          pickUpDate: result.pickUpDate,
          dropOffDate: result.dropOffDate,
          bookingStatus: result.bookingStatus,
          category: {
            id: result.category.id,
            name: result.category.name,
          },

          previewPrice: result.previewPrice
        });
      }
    )
  }

  getBookingClient() {
    this.clientService.getClientById(this.clientId).subscribe(
      result => {
        this.bookingForm.patchValue({
          client: {
            id: result.id,
            name: result.name,
          },
        })
      }
    )
  }

  onSubmit() {
    this.bookingsService.addBooking(this.bookingForm.value).subscribe({
      next: (booking) => this.onSuccess(booking.id),
      error: (e) => this.onError()
    });
  }

  private onSuccess(id: number) {
    if (this.bookingId) {
      this.snackBar.open('Reserva atualizada com sucesso!', '', { duration: 3000 })
    } else {
      this.snackBar.open('Reserva realizada com sucesso!', '', { duration: 3000 })
    }
    this.router.navigate(['../main/bookings/details/' + id]), { relativeTo: this.route };
  }

  private onError() {
    this.snackBar.open('Erro ao realizar reserva', '', { duration: 3000 })
  }

  searchCategory() {
    this.categoryService.list().subscribe(
      result => {
        this.categories = result;
      },
      erro => {
        //TODO evoluir para mostrar mensagem na tela
        console.log("DEU ERRO. Causa: " + erro);
      }
    );

  }

  getSelectedCategory(event: any, id: number) {
    if (event.isUserInput) {
      for (let cat of this.categories) {
        if (cat.id == id) {
          this.selectedCategory = cat;
        }
      }
    }
    this.bookingForm.patchValue({
      dayPrice: this.selectedCategory.dayPrice,
      weekPrice: this.selectedCategory.weekPrice
    })
  }

  updatePriceValue(event: any, type: string) {
    if (event.isUserInput) {
      this.estimatedDate();

      let estPrice: number = 0;

      if (type == "APP_DRIVER") {
        if (this.difDays % 7 == 0) {
          estPrice = this.difWeeks * (this.selectedCategory.weekPrice);
        } else {
          console.log("Please, select full weeks!")
        }

      } else {
        estPrice = this.difDays * (this.selectedCategory.dayPrice);
      }

      this.bookingForm.patchValue({
        previewPrice: estPrice
      })
    }
  }

  estimatedDate() {
    if (this.bookingForm.value.pickUpDate && this.bookingForm.value.dropOffDate) {
      const d1 = (Number(new Date(this.bookingForm.value.pickUpDate)));
      const d2 = (Number(new Date(this.bookingForm.value.dropOffDate)));

      const difDias = (d2 - d1) / (1000 * 60 * 60 * 24);

      this.difDays = difDias;
      this.difWeeks = Math.trunc(difDias / 7);

    }
  }

  back() {
    this.location.back();
  }

  createRental(id: number) {
    this.router.navigate(['../rentals/' + id + '/add'], { relativeTo: this.route.parent })
  }
}


