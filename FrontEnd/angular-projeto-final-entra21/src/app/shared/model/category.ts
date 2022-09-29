import { Vehicle } from './vehicle';
import { Booking } from './booking';

export interface Category{
  id: number,
  dayPrice: number,
  weekPrice: number,
  vehicles: Vehicle[],
  bookings: Booking[]
}
