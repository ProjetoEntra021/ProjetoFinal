import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { VehicleRoutingModule } from './vehicle-routing.module';
import { VehicleComponent } from './vehicle/vehicle.component';
import { AppMaterialModule } from '../shared/app-material/app-material.module';
import { VehicleListComponent } from './vehicle-list/vehicle-list.component';
import { VehicleMenuComponent } from './vehicle-menu/vehicle-menu.component';


@NgModule({
  declarations: [
    VehicleComponent,
    VehicleListComponent,
    VehicleMenuComponent
  ],
  imports: [
    CommonModule,
    VehicleRoutingModule,
    AppMaterialModule
  ]
})
export class VehicleModule { }
