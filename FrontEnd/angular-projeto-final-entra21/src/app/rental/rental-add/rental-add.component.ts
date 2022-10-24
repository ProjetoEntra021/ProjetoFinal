import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { NonNullableFormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';

import { BookingsService } from '../../service/bookings.service';
import { CategoryService } from '../../service/category.service';
import { Category } from '../../shared/model/category';
import { Vehicle } from '../../shared/model/vehicle';
import { RentalService } from '../../service/rental.service';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-rental-add',
  templateUrl: './rental-add.component.html',
  styleUrls: ['./rental-add.component.scss']
})
export class RentalAddComponent implements OnInit {

  rentalTypes = ["APP_DRIVER", "PERSONAL"]

  form = this.formBuilder.group({
    pickUpDate: [<Date | undefined>(undefined)],
    dropOffDate: [<Date | undefined>(undefined)],
    totalValue: [<number | undefined>(undefined)],
    rentalStatus: ["PENDING"],
    rentalType: ['', Validators.required],

    bookingId: [<number | undefined>(undefined)],
    vehicleId: [<number | undefined>(undefined), Validators.required],
    companyId: Number(sessionStorage.getItem('token'))
  })

  optionalForm = this.formBuilder.group({
    clientName: [''],
    categoryId: [<number | undefined>(undefined)],
  })

  categories: Category[] = [];

  vehicleByCategory: Vehicle[] = [];

  bookingId: number | undefined;

  public difDays!: number;

  public difWeeks!: number;

  constructor(
    private formBuilder: NonNullableFormBuilder,
    private categoryService: CategoryService,
    private route: ActivatedRoute,
    private bookingService: BookingsService,
    private location: Location,
    private router: Router,
    private rentalService: RentalService,
    private snackBar: MatSnackBar
  ) { }

  ngOnInit(): void {
    this.categoryService.list().subscribe((dados) => {
      this.categories = dados;
    });

    this.route.params.subscribe(params => {
      this.bookingId = params['id'];
      if (this.bookingId) {
        this.getBooking(this.bookingId);
      }
    })
  }

  onSubmit() {
    // console.log(this.form.value)
    this.rentalService.save(this.form.value).subscribe({
      next: (rental) => this.onSuccess(rental.id!),
      error: () => this.onError()
    })
  }

  private onSuccess(id: number) {
    this.snackBar.open('Locação cadastrada com sucesso!', '', { duration: 3000 })
    this.router.navigate(['../main/rentals/details/' + id]), { relativeTo: this.route };
  }

  private onError() {
    this.snackBar.open('Erro ao cadastrar locação.', '', { duration: 3000 })
  }


  onCancel() {
    this.location.back();
  }

  updateVehicles(id: number) {
    if (this.vehicleByCategory.length == 0) {
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
    this.bookingService.getBookingById(id).subscribe((dados) => {
      this.optionalForm.patchValue(
        {
          clientName: dados.client.name,
          categoryId: dados.category.id
        }),
        this.form.patchValue(
          {
            bookingId: dados.id,
            pickUpDate: dados.pickUpDate,
            dropOffDate: dados.dropOffDate
          })
    }
    );
  }

  updatePriceValue(rentalType: string, event: any) {
    if (event.isUserInput) {
      let id = this.optionalForm.value.categoryId;
      let tempCat = {} as Category;
      for (let cat of this.categories) {
        if (cat.id == id) {
          tempCat = cat;
        }
      }
      this.estimatedDate();
      if (rentalType == "APP_DRIVER") {
        if (this.difDays % 7 == 0) {
          let estPrice = this.difWeeks * tempCat.weekPrice;
          this.form.patchValue({
            totalValue: estPrice
          })
        }
        else {
          console.log("Error");
        }
      } else {
        let estPrice = this.difDays * tempCat.dayPrice;
        this.form.patchValue({
          totalValue: estPrice
        })
      }
    }
  }

  estimatedDate() {
    if (this.form.value.pickUpDate && this.form.value.dropOffDate) {
      const d1 = (Number(new Date(this.form.value.pickUpDate)));
      const d2 = (Number(new Date(this.form.value.dropOffDate)));

      let difDias = (d2 - d1) / (1000 * 60 * 60 * 24);

      this.difDays = difDias;
      this.difWeeks = difDias / 7;
    }
  }
}
