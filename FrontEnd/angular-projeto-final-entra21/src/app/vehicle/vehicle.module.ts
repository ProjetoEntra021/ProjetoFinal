import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { VehicleRoutingModule } from './vehicle-routing.module';
import { VehicleComponent } from './vehicle/vehicle.component';
import { AppMaterialModule } from '../shared/app-material/app-material.module';
import { VehicleListComponent } from './vehicle-list/vehicle-list.component';
import { VehicleMenuComponent } from './vehicle-menu/vehicle-menu.component';
import { VehicleAddComponent } from './vehicle-add/vehicle-add.component';
import { ReactiveFormsModule } from '@angular/forms';
import { SharedModule } from '../shared/shared.module';
import { VehicleDetailsComponent } from './vehicle-details/vehicle-details.component';


@NgModule({
  declarations: [
    VehicleComponent,
    VehicleListComponent,
    VehicleMenuComponent,
    VehicleAddComponent,
    VehicleDetailsComponent
  ],
  imports: [
    CommonModule,
    VehicleRoutingModule,
    AppMaterialModule,
    ReactiveFormsModule,
    SharedModule
  ]
})
export class VehicleModule { }
