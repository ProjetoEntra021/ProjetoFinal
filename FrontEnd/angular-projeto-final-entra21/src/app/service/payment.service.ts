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

  list(companyId: number) {
    return this.httpClient.post<paymentDashDTO[]>(this.API + '/rigthboard', companyId).pipe(tap(data => console.log(data)), first());
  }

  getData(companyId: number) {
    return this.httpClient.post<VehicleDashDTO>(this.API + '/leftboard', companyId).pipe(tap(data => console.log(data)), first());
  }
}
