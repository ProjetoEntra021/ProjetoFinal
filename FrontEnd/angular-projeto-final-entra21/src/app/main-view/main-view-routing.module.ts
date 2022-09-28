import { MainTableComponent } from './../main-table/main-table.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { VehicleComponent } from '../vehicle/vehicle/vehicle.component';
import { MainViewComponent } from './main-view/main-view.component';
import { VehicleModule } from '../vehicle/vehicle.module';

const routes: Routes = [
  {
    path: '', component: MainViewComponent,
    children: [
      { path: '', component: MainTableComponent },
      {
        path: 'vehicles',
        loadChildren: () => import('../vehicle/vehicle.module').then(m => m.VehicleModule)
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class MainViewRoutingModule { }
