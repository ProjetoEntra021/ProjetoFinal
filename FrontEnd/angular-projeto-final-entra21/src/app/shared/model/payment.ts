import { Rental } from './rental';

export interface Payment {
  id: number,
  expirationDate: Date,
  paymentValue: number,
  discount: number,
  paymentStatus: string,
  rental: Rental
}
