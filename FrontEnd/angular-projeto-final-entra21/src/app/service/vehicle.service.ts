import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { first, tap } from 'rxjs';
import { Vehicle } from '../shared/model/vehicle';
import { VehiclesListDTO } from '../shared/model/dto/vehiclesListDTO';
import { VehicleDashDTO } from '../shared/model/dto/vehicleDashDTO';

@Injectable({
  providedIn: 'root'
})
export class VehicleService {

  private readonly API = 'api/vehicles';

  constructor(private httpClient: HttpClient) { }

  list() {
    return this.httpClient.get<VehiclesListDTO[]>(this.API + "/company/" + sessionStorage.getItem('token'))
      .pipe(tap(data => console.log(data)),
        first());
  }

  save(record: Partial<Vehicle>) {
    return this.httpClient.post<Partial<Vehicle>>(this.API, record).pipe(first());
  }

  getVehicleById(id: number) {
    return this.httpClient.get<Vehicle>(this.API + '/' + id).pipe(tap(data => console.log(data)),
      first());
  }

  update(record: Partial<Vehicle>) {
    return this.httpClient.put<Partial<Vehicle>>(this.API + '/' + record.id, record).pipe(first());
  }


}
