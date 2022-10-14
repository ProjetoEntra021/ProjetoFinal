import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { RentalAddComponent } from './rental-add/rental-add.component';

const routes: Routes = [
  { path: '', component: RentalAddComponent },
  { path: ':id/add', component: RentalAddComponent },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class RentalRoutingModule { }
