import { Observable } from 'rxjs';
import { ClientService } from './../../service/client.service';
import { Client } from './../../shared/model/client';
import { Category } from './../../shared/model/category';
import { CategoryService } from './../../service/category.service';
import { Booking} from './../../shared/model/booking';
import { BookingsService } from './../../service/bookings.service';
import { MatSnackBar } from '@angular/material/snack-bar';

import { Component, OnInit } from '@angular/core';
import { NonNullableFormBuilder, Validators } from '@angular/forms';


@Component({
  selector: 'app-creat-booking',
  templateUrl: './creat-booking.component.html',
  styleUrls: ['./creat-booking.component.scss']
})
export class CreatBookingComponent implements OnInit {

    bookingForm = this.formBuilder.group({
    client: [<Client|undefined> (undefined)],
    pickUpDate: [, Validators.required],
    dropOffDate: [, Validators.required],
    bookingStatus: ["ACTIVE"],
    category: [, Validators.required],

  })

  categories: Category[] = [];
  booking!: Observable <Booking>;
  client!: Observable <Client>;


  constructor(
    private categoryService: CategoryService,
    private bookingsService: BookingsService,
    private clientService: ClientService,
    private formBuilder: NonNullableFormBuilder,
    private snackBar: MatSnackBar,
  ) { }

  ngOnInit(): void {

    this.searchCategory();
    console.log(this.categories);
    this.clientService.getId().subscribe(obs => this.bookingForm.patchValue({client: obs}))
  }


  onSubmit(){
    console.log("aqui", this.bookingForm.value);
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

}

