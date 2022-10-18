import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { RentalAddDTO } from '../shared/model/dto/rentalAddDTO';
import { first } from 'rxjs/operators';
import { Rental } from '../shared/model/rental';

@Injectable({
  providedIn: 'root'
})
export class RentalService {

  private readonly API = 'api/rentals';

  constructor(private httpClient: HttpClient) { }

  list() {
    return this.httpClient.get<Rental[]>(this.API).pipe(first());
  }

  save(record: Partial<RentalAddDTO>) {
    return this.httpClient.post<Partial<RentalAddDTO>>(this.API, record).pipe(first());
  }

  findById(id: number) {
    return this.httpClient.get<Rental>(this.API + '/' + id).pipe(first());
  }
}
