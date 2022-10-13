import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';

import { AppMaterialModule } from './app-material/app-material.module';
import { HeaderComponent } from './header/header.component';
import { VehicleStatusPipe } from './pipes/vehicle-status.pipe';
import { NgxMaskModule, IConfig } from 'ngx-mask';

export const options: Partial<null | IConfig> | (() => Partial<IConfig>) = null;


@NgModule({
  declarations: [
    HeaderComponent,
    VehicleStatusPipe
  ],
  imports: [
    CommonModule,
    AppMaterialModule,
    NgxMaskModule.forRoot()
  ],
  exports: [
    HeaderComponent,
    VehicleStatusPipe,
    NgxMaskModule
  ]
})
export class SharedModule { }
