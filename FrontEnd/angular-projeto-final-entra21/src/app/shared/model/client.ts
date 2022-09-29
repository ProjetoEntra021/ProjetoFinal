import { Booking } from './booking';
import { Address } from './address';
import { Contact } from './contact';

export interface Client{
  id: number,
  name: string,
  cpf: string,
  cnh: string,
  birthDate: Date,
  addresses: Address[],
  contacts: Contact[],
  bookings: Booking[]
}
