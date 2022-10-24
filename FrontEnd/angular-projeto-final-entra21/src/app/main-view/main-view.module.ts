import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { MatGridListModule } from '@angular/material/grid-list';
import { MatProgressBarModule } from '@angular/material/progress-bar';

import { AppMaterialModule } from '../shared/app-material/app-material.module';
import { SharedModule } from '../shared/shared.module';
import { VehicleDashboardComponent } from '../vehicle-dashboard/vehicle-dashboard.component';
import { MainTableComponent } from './../main-table/main-table.component';
import { RentalsDashboardComponent } from './../rentals-dashboard/rentals-dashboard.component';
import { MainViewRoutingModule } from './main-view-routing.module';
import { MainViewComponent } from './main-view/main-view.component';
import { HeaderDashboardComponent } from '../header-dashboard/header-dashboard.component';

@NgModule({
  declarations: [
    MainViewComponent,
    VehicleDashboardComponent,
    HeaderDashboardComponent,
    RentalsDashboardComponent,

    MainTableComponent
  ],
  imports: [
    CommonModule,
    MainViewRoutingModule,
    AppMaterialModule,
    FormsModule,
    MatGridListModule,
    MatProgressBarModule,
    SharedModule
  ]
})
export class MainViewModule { }
