import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { VehicleModule } from './vehicle/vehicle.module';


const routes: Routes = [
  {path: '', redirectTo:'main', pathMatch: 'full'},
  {
    path:'main',
    loadChildren:()=>import('./main-view/main-view.module').then(m=>m.MainViewModule)
  },
  {path: 'vehicle', component: VehicleModule}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
