import { Booking, CreateBookingInput } from '../shared/model/booking';
import { Injectable } from '@angular/core';
import { first, tap } from 'rxjs/operators';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class BookingsService {

  private readonly API = 'api/bookings/';

  constructor(private httpClient: HttpClient) { }

  list() {
    return this.httpClient.get<Booking[]>(this.API)
    .pipe(tap(data => console.log(data)),
      first());
    }

  addBooking(record: Partial<Booking>){
    return this.httpClient.post<Booking>(this.API, record).pipe(first());
  }

}
