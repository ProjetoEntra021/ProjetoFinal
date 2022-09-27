import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { VehicleRoutingModule } from './vehicle-routing.module';
import { VehicleComponent } from './vehicle/vehicle.component';
import { AppMaterialModule } from '../shared/app-material/app-material.module';


@NgModule({
  declarations: [
    VehicleComponent
  ],
  imports: [
    CommonModule,
    VehicleRoutingModule,
    AppMaterialModule
  ]
})
export class VehicleModule { }
