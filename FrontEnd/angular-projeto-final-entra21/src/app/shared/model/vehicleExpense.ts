import { Vehicle } from './vehicle';

export interface VehicleExpense{
  id: number,
  description: string,
  value: number,
  vehicle: Vehicle
}
