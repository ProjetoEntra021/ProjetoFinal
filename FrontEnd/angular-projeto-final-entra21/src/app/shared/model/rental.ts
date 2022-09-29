import { Booking } from './booking';
import { Category } from './category';
import { Vehicle } from './vehicle';
import { Receipt } from './receipt';

export interface Rental{
  id: number,
  pickUpDate: Date,
  dropOffDate: Date,
  rentalStatus: string,
  booking: Booking,
  vehicle: Vehicle,
  receipt: Receipt
}
