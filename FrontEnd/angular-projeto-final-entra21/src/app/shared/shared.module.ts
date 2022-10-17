import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { IConfig, NgxMaskModule } from 'ngx-mask';

import { AppMaterialModule } from './app-material/app-material.module';
import { HeaderComponent } from './header/header.component';
import { BookingStatusPipe } from './pipes/booking-status.pipe';
import { PaymentStatusPipe } from './pipes/payment-status.pipe';
import { RentalTypePipe } from './pipes/rental-type.pipe';
import { VehicleStatusPipe } from './pipes/vehicle-status.pipe';

export const options: Partial<null | IConfig> | (() => Partial<IConfig>) = null;


@NgModule({
  declarations: [
    HeaderComponent,
    VehicleStatusPipe,
    BookingStatusPipe,
    RentalTypePipe,
    PaymentStatusPipe,
  ],
  imports: [
    CommonModule,
    AppMaterialModule,
    NgxMaskModule.forRoot()
  ],
  exports: [
    HeaderComponent,
    VehicleStatusPipe,
    NgxMaskModule,
    BookingStatusPipe,
    RentalTypePipe,
    PaymentStatusPipe
  ]
})
export class SharedModule { }
