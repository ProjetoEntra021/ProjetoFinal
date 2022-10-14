import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { VehicleExpenseDTO } from '../shared/model/dto/vehicleExpenseDTO';
import { first } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class VehicleExpenseService {

  private readonly API = 'api/vehicleExpenses';

  constructor(private httpClient: HttpClient) { }

  save(record: Partial<VehicleExpenseDTO>) {
    return this.httpClient.post<Partial<VehicleExpenseDTO>>(this.API, record).pipe(first());
  }

}
