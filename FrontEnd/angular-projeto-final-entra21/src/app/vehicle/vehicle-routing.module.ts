import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { VehicleListComponent } from './vehicle-list/vehicle-list.component';
import { VehicleMenuComponent } from './vehicle-menu/vehicle-menu.component';
import { VehicleComponent } from './vehicle/vehicle.component';
import { VehicleAddComponent } from './vehicle-add/vehicle-add.component';
import { VehicleDetailsComponent } from './vehicle-details/vehicle-details.component';
import { VehicleBalanceComponent } from './vehicle-balance/vehicle-balance.component';

const routes: Routes = [
  { path: '', component: VehicleMenuComponent },
  { path: 'list', component: VehicleListComponent },
  { path: 'add', component: VehicleAddComponent },
  { path: 'add/:id', component: VehicleAddComponent },
  { path: 'details/:id', component: VehicleDetailsComponent },
  { path: 'details/:id/balance', component: VehicleBalanceComponent }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class VehicleRoutingModule { }
