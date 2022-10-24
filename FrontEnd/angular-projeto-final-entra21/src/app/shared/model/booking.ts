import { Category } from "./category";
import { Rental } from './rental';
import { Client } from './client';
import { Company } from './company';

export interface Booking {
  id: number,
  client: Client | Partial<Client>,
  pickUpDate: Date,
  dropOffDate: Date,
  dayPrice: number,
  weekPrice: number,
  previewPrice: number,
  category: Partial<Category>,
  bookingStatus: string,
  rental: Rental,
  company: Company | Partial<Company>,
  categoryName?: string,
  clientName?: string
}

