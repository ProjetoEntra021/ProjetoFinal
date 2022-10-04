import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Client } from '../shared/model/client';
import { first, tap } from 'rxjs/operators';

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
}
