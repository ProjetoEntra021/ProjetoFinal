import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';

import { AppMaterialModule } from '../shared/app-material/app-material.module';
import { SharedModule } from '../shared/shared.module';
import { VehicleAddComponent } from './vehicle-add/vehicle-add.component';
import { VehicleBalanceComponent } from './vehicle-balance/vehicle-balance.component';
import { VehicleDetailsComponent } from './vehicle-details/vehicle-details.component';
import { VehicleListComponent } from './vehicle-list/vehicle-list.component';
import { VehicleMenuComponent } from './vehicle-menu/vehicle-menu.component';
import { VehicleRoutingModule } from './vehicle-routing.module';
import { VehicleComponent } from './vehicle/vehicle.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AddExpenseDialogComponent } from './add-expense-dialog/add-expense-dialog.component';



@NgModule({
  declarations: [
    VehicleComponent,
    VehicleListComponent,
    VehicleMenuComponent,
    VehicleAddComponent,
    VehicleDetailsComponent,
    VehicleBalanceComponent,
    AddExpenseDialogComponent
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
