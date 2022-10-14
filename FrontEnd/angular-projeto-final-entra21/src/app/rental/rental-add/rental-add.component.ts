import { Component, OnInit } from '@angular/core';
import { NonNullableFormBuilder, Validators } from '@angular/forms';
import { Category } from '../../shared/model/category';
import { CategoryService } from '../../service/category.service';
import { Vehicle } from '../../shared/model/vehicle';
import { ActivatedRoute } from '@angular/router';
import { BookingsService } from '../../service/bookings.service';

@Component({
  selector: 'app-rental-add',
  templateUrl: './rental-add.component.html',
  styleUrls: ['./rental-add.component.scss']
})
export class RentalAddComponent implements OnInit {

  form = this.formBuilder.group({
    categoryId: 0,
    client: [''],
    pickUpDate: [<Date | undefined>(undefined)],
    dropOffDate: [<Date | undefined>(undefined)],
    bookingId: [<number | undefined>(undefined)],
    vehicleId: [<number | undefined>(undefined)],
    rentalStatus: ["AVAILABLE"],
  })

  categories: Category[] = [];

  vehicleByCategory: Vehicle[] = [];

  bookingId: number | undefined;

  constructor(
    private formBuilder: NonNullableFormBuilder,
    private categoryService: CategoryService,
    private route: ActivatedRoute,
    private bookingService: BookingsService
  ) { }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.bookingId = params['id'];
      if (this.bookingId) {
        this.getBooking(this.bookingId);
      }
    })

    this.categoryService.listWithVehicles().subscribe((dados) => {
      this.categories = dados;
    });
  }

  onSubmit() {
    console.log(this.form.value)
  }

  onCancel() {

  }

  updateVehicles(event: any, id: number) {
    if (event) {
      let availableVehicle: Vehicle[] = [];
      for (let cat of this.categories) {
        if (cat.id === id) {
          for (let vehicle of cat.vehicles) {
            if (vehicle.vehicleStatus === "AVAILABLE") {
              availableVehicle.push(vehicle);
            }
          }
        }
      }
      this.vehicleByCategory = availableVehicle;
    }
  }

  getBooking(id: number) {
    this.bookingService.getBookingById(id).subscribe((dados) =>
      this.form.patchValue(
        {
          categoryId: dados.category.id,
          client: dados.client.name,
          bookingId: dados.id,
          pickUpDate: dados.pickUpDate,
          dropOffDate: dados.dropOffDate
        }));
  }
}
