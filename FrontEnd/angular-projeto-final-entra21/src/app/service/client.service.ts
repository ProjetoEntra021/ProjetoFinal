import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Client } from '../shared/model/client';
import { first, tap } from 'rxjs/operators';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ClientService {

  private readonly API = 'api/clients';

  constructor(private httpClient: HttpClient) { }

    list() {
    return this.httpClient.get<Client[]>(this.API)
      .pipe(tap(data => console.log(data)),
        first());
  }

    getId(){
      return this.httpClient.get<Client>('api/clients/1');
    }

  save(record: Partial<Client>) {
    return this.httpClient.post<Partial<Client>>(this.API, record).pipe(first());
  }
}
