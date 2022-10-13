import { Vehicle } from './vehicle';

export interface VehicleExpense {
  id: number,
  description: string,
  date: Date,
  value: number,
  vehicle: Vehicle | Partial<Vehicle>
}
