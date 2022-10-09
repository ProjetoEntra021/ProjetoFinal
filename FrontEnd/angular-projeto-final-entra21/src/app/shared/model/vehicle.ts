import { Category } from "./category";
import { VehicleRevenue } from './vehicleRevenue';
import { VehicleExpense } from './vehicleExpense';

export interface Vehicle {
  id: number,
  vehicleModel: string,
  licensePlate: string,
  chassi: string,
  mileage: number,
  renavam: string,
  vehicleYear: string,
  category: Category | Partial<Category>,
  vehicleStatus: string,
  revenues: VehicleRevenue[],
  expenses: VehicleExpense[]
}
