import { Category } from './../../shared/model/category';
import { CategoryService } from './../../service/category.service';
import { Booking, CreateBookingInput } from './../../shared/model/booking';
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

  public categories: Category[] = new Array();

  bookingForm = this.formBuilder.group({
    pickUpDate: ['', Validators.required],
    dropOffDate: ['', Validators.required],
    // category: ['', Validators.required],
  })

  public booking!: Booking | undefined;

  constructor(
    private categoryService: CategoryService,
    private bookingsService: BookingsService,
    private formBuilder: NonNullableFormBuilder,
  ) { }

  ngOnInit(): void {
    this.searchCategory();
  }

  addBooking(){
    // this.booking.bookingStatus = "ACTIVE"
    // this.booking.pickUpDate = new Date (this.booking.pickUpDate);
    // this.booking.dropOffDate = new Date (this.booking.dropOffDate);

    // this.booking.category.dayPrice = this.booking.dayPrice;
    // this.booking.catefory.weekPrice = this.booking.weekPrice;

    // this.bookingsService.addBooking(this.bookingForm.value).subscribe(
    //   resultado => {
    //     this.booking = resultado;
    //     alert("Reserva realizada!");
    //   }
    // )

  }

  searchCategory(){
    // this.categoryService.list().subscribe(
    //   resultado => {
    //     this.categories = resultado;
    //   },
    //   erro => {
    //     //TODO evoluir para mostrar mensagem na tela
    //     console.log("DEU ERRO. Causa: " + erro);
      }
    // );

  }

// }

