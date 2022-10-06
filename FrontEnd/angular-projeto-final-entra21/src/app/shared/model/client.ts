import { Booking } from './booking';
import { Address } from './address';
import { Contact } from './contact';

export interface Client{
  id: number,
  name: string,
  birthDate: Date,
  gender: string,
  cpf: string,
  cnh: string,
  addresses: Address[],
  contacts: Contact[],
  bookings: Booking[]
}
