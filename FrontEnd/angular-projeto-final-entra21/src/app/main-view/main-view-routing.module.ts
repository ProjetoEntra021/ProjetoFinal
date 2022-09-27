import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { VehicleComponent } from '../vehicle/vehicle/vehicle.component';
import { MainViewComponent } from './main-view/main-view.component';
import { MainTableComponent } from './main-table/main-table.component';

const routes: Routes = [
  {
    path: '', component: MainViewComponent,
    children: [
      { path: '', component: MainTableComponent },
      { path: 'vehicles', component: VehicleComponent },
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class MainViewRoutingModule { }
