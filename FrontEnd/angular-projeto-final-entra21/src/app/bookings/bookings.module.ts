import { SharedModule } from './../shared/shared.module';
import { Category } from 'src/app/shared/model/category';

import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { CreateBookingComponent } from './create-booking/create-booking.component';
import { AppMaterialModule } from './../shared/app-material/app-material.module';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { BookingsRoutingModule } from './bookings-routing.module';
import { BookingListComponent } from './booking-list/booking-list.component';
import { DetailsBookingComponent } from './details-booking/details-booking.component';


@NgModule({
  declarations: [
    BookingListComponent,
    CreateBookingComponent,
    DetailsBookingComponent
  ],
  imports: [
    CommonModule,
    BookingsRoutingModule,
    AppMaterialModule,
    FormsModule,
    ReactiveFormsModule,
    SharedModule,



  ]
})
export class BookingsModule { }
