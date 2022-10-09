import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { first } from 'rxjs';
import { Address } from '../shared/model/address';

@Injectable({
  providedIn: 'root'
})
export class AddressService {

  private readonly API = "/api/addresses";


  constructor(private httpClient: HttpClient) { }

  save(record: Partial<Address>){
    return this.httpClient.post<Address>(this.API, record).pipe(first());
  }
}
