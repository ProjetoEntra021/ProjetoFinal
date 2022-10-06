import { CreatBookingComponent } from './creat-booking/creat-booking.component';
import { AppMaterialModule } from './../shared/app-material/app-material.module';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { BookingsRoutingModule } from './bookings-routing.module';
import { BookingListComponent } from './booking-list/booking-list.component';


@NgModule({
  declarations: [
    BookingListComponent,
    CreatBookingComponent
  ],
  imports: [
    CommonModule,
    BookingsRoutingModule,
    AppMaterialModule
  ]
})
export class BookingsModule { }
