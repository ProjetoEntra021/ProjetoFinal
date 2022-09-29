import { Client } from './client';

export interface Address {
  id: number,
  cep: string,
  street: string,
  district: string,
  number: string,
  complement: string,
  client: Client
}
