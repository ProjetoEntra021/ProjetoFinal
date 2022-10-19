import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { NonNullableFormBuilder, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute } from '@angular/router';

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
    estimatedPrice: 0,
  })

  categories: Category[] = [];

  public bookingId!: number;
  public clientId!: number;
  public difDays!: number;
  public difWeeks!: number;


  constructor(
    private categoryService: CategoryService,
    private bookingsService: BookingsService,
    private clientService: ClientService,
    private formBuilder: NonNullableFormBuilder,
    private snackBar: MatSnackBar,
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
    console.log(this.categories);

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
          dayPrice: result.dayPrice,
          weekPrice: result.weekPrice,
        });
        this.estimatedDate();

        if (result.category.dayPrice && result.category.weekPrice) {
          let estPrice = (this.difDays * (result.category.dayPrice)) +
            (this.difWeeks * (result.category.weekPrice));
          this.bookingForm.patchValue({
            estimatedPrice: estPrice,
          })
        }
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
      next: () => this.onSuccess(),
      error: (e) => this.onError()
    });
  }

  private onSuccess() {
    if (this.bookingId) {
      this.snackBar.open('Reserva atualizada com sucesso!', '', { duration: 3000 })
    } else {
      this.snackBar.open('Reserva realizada com sucesso!', '', { duration: 3000 })
    }
    this.back();
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

  updatePriceValue(event: any, id: number) {
    if (event.isUserInput) {
      let tempCat = {} as Category;
      for (let cat of this.categories) {
        if (cat.id == id) {
          tempCat = cat;
        }
      }
      this.estimatedDate();
      let estPrice = (this.difDays * (tempCat.dayPrice)) +
        (this.difWeeks * (tempCat.weekPrice));
      this.bookingForm.patchValue({
        dayPrice: tempCat.dayPrice,
        weekPrice: tempCat.weekPrice,
        estimatedPrice: estPrice,
      })
    }
  }

  estimatedDate() {
    if (this.bookingForm.value.pickUpDate && this.bookingForm.value.dropOffDate) {
      const d1 = (Number(new Date(this.bookingForm.value.pickUpDate)));
      const d2 = (Number(new Date(this.bookingForm.value.dropOffDate)));

      const difDias = (d2 - d1) / (1000 * 60 * 60 * 24);

      let days = difDias % 7;
      let weeks = Math.trunc(difDias / 7);

      this.difDays = days;
      this.difWeeks = weeks;
    }
    console.log(this.difDays, this.difWeeks);
  }

  back() {
    this.location.back();
  }
}



