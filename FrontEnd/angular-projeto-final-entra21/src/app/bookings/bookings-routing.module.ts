import { CreateBookingComponent } from './create-booking/create-booking.component';
import { BookingListComponent } from './booking-list/booking-list.component';
import { NgModule, Component } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DetailsBookingComponent } from './details-booking/details-booking.component';


const routes: Routes = [
  { path: '', component: BookingListComponent },
  { path: 'create/:idclient', component: CreateBookingComponent },
  { path: 'update/:id', component: CreateBookingComponent },
  { path: 'details/:id', component: DetailsBookingComponent }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class BookingsRoutingModule { }
