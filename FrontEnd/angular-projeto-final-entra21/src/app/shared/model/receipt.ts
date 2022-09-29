import { Rental } from "./rental";

export interface Receipt{
  id: number,
  rental: Rental,
  discount: number,
  totalValue: number
}
