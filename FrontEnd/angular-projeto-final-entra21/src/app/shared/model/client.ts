import { Booking } from './booking';
import { Address } from './address';
import { Contact } from './contact';

export interface Client {
  id: number,
  name: string,
  birthDate: string,
  gender: string,
  cpf: string,
  cnh: string,
  addresses: Address[] | Partial<Address>[],
  contacts: Contact[],
  bookings: Booking[]
}
