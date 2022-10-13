import { Category } from "./category";
import { Rental } from './rental';
import { Client } from './client';

export interface Booking{
  id: number,
  client: Client | Partial<Client>,
  pickUpDate: Date,
  dropOffDate: Date,
  dayPrice: number,
  weekPrice: number,
  category: Partial<Category>,
  bookingStatus: string,
  rental: Rental
}

// export interface CreateBookingInput{
//   client: { id: number },
//   pickUpDate: Date,
//   dropOffDate: Date,
//   dayPrice: number,
//   weekPrice: number,
//   category: Category,
//   bookingStatus: string,
// }
