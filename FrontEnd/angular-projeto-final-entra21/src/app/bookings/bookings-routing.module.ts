import { CreateBookingComponent } from './create-booking/create-booking.component';
import { BookingListComponent } from './booking-list/booking-list.component';
import { NgModule, Component } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  { path: '', component: BookingListComponent },
  { path: 'create', component: CreateBookingComponent},
  { path: 'create/:idclient', component: CreateBookingComponent},
  { path: 'details/:id',component: CreateBookingComponent }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class BookingsRoutingModule { }
