import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { RentalAddDTO } from '../shared/model/dto/rentalAddDTO';
import { first, tap } from 'rxjs';
import { Rental } from '../shared/model/rental';
import { HeaderDashDTO } from '../shared/model/dto/headerDashDTO';

@Injectable({
  providedIn: 'root'
})
export class RentalService {

  private readonly API = 'api/rentals';

  constructor(private httpClient: HttpClient) { }

  list() {
    return this.httpClient.get<Rental[]>(this.API + '/company/' + sessionStorage.getItem('token')).pipe(first());
  }

  save(record: Partial<RentalAddDTO>) {
    return this.httpClient.post<Partial<Rental>>(this.API, record).pipe(first());
  }

  findById(id: number) {
    return this.httpClient.get<Rental>(this.API + '/' + id).pipe(first());
  }

  cancelRental(id: number) {
    return this.httpClient.patch<Rental>(this.API + '/' + id, undefined).pipe(first())
  }

  getHeaderData(companyId: number) {
    return this.httpClient.post<HeaderDashDTO>(this.API + '/header', companyId).pipe(tap(data => console.log(data)), first());
  }
}
