import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { first, tap } from 'rxjs';
import { Vehicle } from '../shared/model/vehicle';

@Injectable({
  providedIn: 'root'
})
export class VehicleService {

  private readonly API = 'api/vehicles';

  constructor(private httpClient: HttpClient) { }

  list() {
    return this.httpClient.get<Vehicle[]>(this.API)
    .pipe(tap(data => console.log(data)),
      first());
    }
}
