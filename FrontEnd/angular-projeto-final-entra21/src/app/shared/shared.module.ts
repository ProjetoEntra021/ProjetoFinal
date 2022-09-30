import { VehicleModule } from './../vehicle/vehicle.module';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AppMaterialModule } from './app-material/app-material.module';
import { VehiclePipe } from './pipes/vehicle.pipe';



@NgModule({
  declarations: [
    VehiclePipe
  ],
  imports: [
    CommonModule,
    AppMaterialModule,
    VehicleModule
  ]
})
export class SharedModule { }
