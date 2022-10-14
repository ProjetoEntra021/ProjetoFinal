export interface RentalAddDTO {
  id: number,
  pickUpDate: Date,
  dropOffDate: Date,
  rentalStatus: string,
  bookingId: number,
  vehicleId: number,
  totalValue: number
}
