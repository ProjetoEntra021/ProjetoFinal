import { Vehicle } from './vehicle';

export interface VehicleRevenue{
  id: number,
  description: string,
  value: number,
  vehicle: Vehicle
}
