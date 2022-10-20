import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { MainTableComponent } from './../main-table/main-table.component';
import { MainViewComponent } from './main-view/main-view.component';

const routes: Routes = [
  {
    path: '', component: MainViewComponent,
    children: [
      { path: '', component: MainTableComponent },
      {
        path: 'vehicles',
        loadChildren: () => import('../vehicle/vehicle.module').then(m => m.VehicleModule)
      },
      {
        path: 'clients',
        loadChildren: () => import('../client/client.module').then(m => m.ClientModule)
      },
      {
        path: 'bookings',
        loadChildren: () => import('../bookings/bookings.module').then(m => m.BookingsModule)
      },
      {
        path: 'rentals',
        loadChildren: () => import('../rental/rental.module').then(m => m.RentalModule)
      },
      {
        path: 'category',
        loadChildren: () => import('../category/category.module').then(m => m.CategoryModule)
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class MainViewRoutingModule { }
