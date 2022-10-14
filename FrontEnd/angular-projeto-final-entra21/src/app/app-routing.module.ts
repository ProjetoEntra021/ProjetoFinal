import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { VehicleModule } from './vehicle/vehicle.module';


const routes: Routes = [
  {path: '', redirectTo:'home', pathMatch: 'full'},
  {
    path:'main',
    loadChildren:()=>import('./main-view/main-view.module').then(m=>m.MainViewModule)
  },
  {
    path:'home',
    loadChildren:()=>import('./home/home.module').then(m=>m.HomeModule)
  },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
