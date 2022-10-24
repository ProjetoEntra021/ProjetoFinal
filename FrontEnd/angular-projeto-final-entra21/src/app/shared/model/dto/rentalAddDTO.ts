export interface RentalAddDTO {
  pickUpDate: Date,
  dropOffDate: Date,
  rentalStatus: string,
  rentalType: string,
  totalValue: number,
  bookingId: number,
  vehicleId: number,
  companyId: number
}
