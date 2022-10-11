import { CreatBookingComponent } from './creat-booking/creat-booking.component';
import { BookingListComponent } from './booking-list/booking-list.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  { path: '', component: BookingListComponent },
  { path: 'create', component: CreatBookingComponent},
  // { path: 'create/:id'}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class BookingsRoutingModule { }
