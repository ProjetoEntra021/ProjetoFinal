import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';

import { AppMaterialModule } from '../shared/app-material/app-material.module';
import { SharedModule } from '../shared/shared.module';
import { RentalAddComponent } from './rental-add/rental-add.component';
import { RentalRoutingModule } from './rental-routing.module';



@NgModule({
  declarations: [
    RentalAddComponent
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
