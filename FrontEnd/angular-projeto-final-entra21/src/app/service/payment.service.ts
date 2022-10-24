import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Payment } from '../shared/model/payment';
import { first } from 'rxjs';
import { tap } from 'rxjs/operators';
import { paymentDashDTO } from '../shared/model/dto/paymentDashDTO';
import { VehicleDashDTO } from '../shared/model/dto/vehicleDashDTO';

@Injectable({
  providedIn: 'root'
})
export class PaymentService {

  private readonly API = 'api/payments';

  constructor(private httpClient: HttpClient) { }

  confirmPayment(id: number) {
    return this.httpClient.patch<Payment>(this.API + '/' + id, undefined).pipe(tap((data) => console.log(data)), first());
  }

  list() {
    return this.httpClient.get<paymentDashDTO[]>(this.API + '/rigthboard').pipe(tap(data => console.log(data)), first());
  }

  getData() {
    return this.httpClient.get<VehicleDashDTO>(this.API + '/leftboard').pipe(tap(data => console.log(data)), first());
  }
}
