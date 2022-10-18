import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { RentalAddComponent } from './rental-add/rental-add.component';
import { RentalListComponent } from './rental-list/rental-list.component';
import { RentalDetailsComponent } from './rental-details/rental-details.component';

const routes: Routes = [
  { path: '', component: RentalListComponent },
  { path: ':id/add', component: RentalAddComponent },
  { path: 'details/:id', component: RentalDetailsComponent }

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class RentalRoutingModule { }
