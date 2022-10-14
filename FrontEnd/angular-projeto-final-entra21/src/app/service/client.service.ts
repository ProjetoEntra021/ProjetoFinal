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

  save(record: Partial<Client>) {
    return this.httpClient.post<Partial<Client>>(this.API, record).pipe(first());
  }

  getClientById(id: number) {
    return this.httpClient.get<Client>(this.API + '/' + id).pipe(tap(data => console.log(data)),
      first());
  }

  getClientByCpf(cpf: string) {
    return this.httpClient.get<Client>(this.API + '/cpf/' + cpf).pipe(tap(data => console.log(data)),first())
  }

  update(record: Partial<Client>) {
    return this.httpClient.put<Partial<Client>>(this.API + '/' + record.id, record).pipe(first());
  }
}
