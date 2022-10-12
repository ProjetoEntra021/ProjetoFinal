import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { ClientService } from '../../service/client.service';
import { Client } from '../../shared/model/client';
import { Category } from '../../shared/model/category';
import { CategoryService } from '../../service/category.service';
import { Booking} from '../../shared/model/booking';
import { BookingsService } from '../../service/bookings.service';
import { MatSnackBar } from '@angular/material/snack-bar';

import { Component, OnInit } from '@angular/core';
import { NonNullableFormBuilder, Validators } from '@angular/forms';


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
      name:'',
    }),
    pickUpDate: [new Date(), Validators.required],
    dropOffDate: [new Date(), Validators.required],
    bookingStatus: ["ACTIVE"],
    category: this.formBuilder.group({
      id:0,
      name: '',
    }),
    dayPrice: 0,
    weekPrice: 0,
  })

  categories: Category[] = [];

  public bookingId!: number;
  public clientId!: number;
  // booking!: Observable <Booking>;
  // client!: Observable <Client>;


  constructor(
    private categoryService: CategoryService,
    private bookingsService: BookingsService,
    private clientService: ClientService,
    private formBuilder: NonNullableFormBuilder,
    private snackBar: MatSnackBar,
    private route: ActivatedRoute
  ) { }

  ngOnInit(): void {

    this.categoryService.list().subscribe((dados) => {
      this.categories = dados;

      })
      this.route.params.subscribe(params => {
        this.bookingId = params['id'];
        if(this.bookingId){
          this.getBooking();
        }

        this.route.params.subscribe(params => {
          this.clientId = params ['idclient'];
          if(this.clientId){
            this.getBookingClient();
          }
        })


    })

    this.searchCategory();
    console.log(this.categories);

  }

  getBooking(){
    this.bookingsService.getBookingById(this.bookingId).subscribe(
      resultado => {
        console.log(resultado)
        this.bookingForm.patchValue({
          id: resultado.id,
          client: {
            id: resultado.client.id,
            name: resultado.client.name,
          },
          pickUpDate: resultado.pickUpDate,
          dropOffDate: resultado.dropOffDate,
          bookingStatus: resultado.bookingStatus,
          category: {
            id: resultado.category.id,
            name: resultado.category.name,
          },
          dayPrice: resultado.dayPrice,
          weekPrice: resultado.weekPrice,
        });
      }
    )
  }

  getBookingClient(){
    this.clientService.getClientById(this.clientId).subscribe(
      resultado => {
        this.bookingForm.patchValue({
          client: {
            id: resultado.id,
            name: resultado.name,
          },
        })
      }
    )
  }

  onSubmit(){
    this.bookingsService.addBooking(this.bookingForm.value).subscribe({
      next: () => this.onSuccess(),
      error: (e) => this.onError()
    });
  }

  private onSuccess() {
    this.snackBar.open('Reserva realizada com sucesso!', '', { duration: 3000 })
  }

  private onError() {
    this.snackBar.open('Erro ao realizar reserva', '', { duration: 3000 })
  }

  searchCategory(){
      this.categoryService.list().subscribe(
    resultado => {
       this.categories = resultado;
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

      this.bookingForm.patchValue({

          dayPrice: tempCat.dayPrice,
          weekPrice: tempCat.weekPrice

      })
    }
  }

}

