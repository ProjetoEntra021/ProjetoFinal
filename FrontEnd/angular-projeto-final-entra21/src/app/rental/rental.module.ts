import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';

import { AppMaterialModule } from '../shared/app-material/app-material.module';
import { SharedModule } from '../shared/shared.module';
import { RentalAddComponent } from './rental-add/rental-add.component';
import { RentalRoutingModule } from './rental-routing.module';
import { RentalListComponent } from './rental-list/rental-list.component';
import { PaymentsListComponent } from './payments-list/payments-list.component';



@NgModule({
  declarations: [
    RentalAddComponent,
    RentalListComponent,
    PaymentsListComponent
  ],
  imports: [
    CommonModule,
    RentalRoutingModule,
    SharedModule,
    AppMaterialModule,
    ReactiveFormsModule
  ]
})
export class RentalModule { }
