import { RentalsDashboardComponent } from './../rentals-dashboard/rentals-dashboard.component';
import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { AppMaterialModule } from '../shared/app-material/app-material.module';
import { SharedModule } from '../shared/shared.module';
import { MainTableComponent } from './../main-table/main-table.component';
import { MainViewRoutingModule } from './main-view-routing.module';
import { MainViewComponent } from './main-view/main-view.component';
import { VehicleDashboardComponent } from '../vehicle-dashboard/vehicle-dashboard.component';
import { MatProgressBarModule } from '@angular/material/progress-bar';


@NgModule({
  declarations: [
    MainViewComponent,
    VehicleDashboardComponent,
    RentalsDashboardComponent,
    MainTableComponent
  ],
  imports: [
    CommonModule,
    MainViewRoutingModule,
    AppMaterialModule,
    FormsModule,
    MatProgressBarModule,
    SharedModule
  ]
})
export class MainViewModule { }
