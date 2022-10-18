import { Booking } from './booking';
import { Category } from './category';
import { Vehicle } from './vehicle';
import { Receipt } from './receipt';
import { Payment } from './payment';

export interface Rental {
  id: number,
  pickUpDate: Date,
  dropOffDate: Date,
  rentalStatus: string,
  rentalType: string,
  totalValue: number,
  booking: Booking,
  vehicle: Vehicle,
  receipt: Receipt,
  payments: Payment[]
}
