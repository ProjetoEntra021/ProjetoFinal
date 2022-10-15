import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { RentalAddComponent } from './rental-add/rental-add.component';
import { RentalListComponent } from './rental-list/rental-list.component';

const routes: Routes = [
  { path: '', component: RentalAddComponent },
  { path: ':id/add', component: RentalAddComponent },
  { path: 'list', component: RentalListComponent },

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class RentalRoutingModule { }
