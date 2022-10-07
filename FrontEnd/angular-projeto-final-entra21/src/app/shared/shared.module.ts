import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';

import { AppMaterialModule } from './app-material/app-material.module';
import { HeaderComponent } from './header/header.component';
import { VehicleStatusPipe } from './pipes/vehicle-status.pipe';



@NgModule({
  declarations: [
    HeaderComponent,
    VehicleStatusPipe
  ],
  imports: [
    CommonModule,
    AppMaterialModule
  ],
  exports: [
    HeaderComponent,
    VehicleStatusPipe
  ]
})
export class SharedModule { }
