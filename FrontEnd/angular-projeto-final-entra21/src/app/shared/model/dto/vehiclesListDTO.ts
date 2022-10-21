import { Category } from '../category';
export interface VehiclesListDTO {

  id: number,
  vehicleModel: string,
  licensePlate: string,
  vehicleYear: string,
  categoryName: string,
  vehicleStatus: string,
  companyId: number

}
