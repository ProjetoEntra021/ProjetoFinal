import { Client } from './client';

export interface Address {
  id: number,
  cep: string,
  street: string,
  number: string,
  complement: string,
  district: string,
  city: string,
  uf: string,
  client: Client
}
