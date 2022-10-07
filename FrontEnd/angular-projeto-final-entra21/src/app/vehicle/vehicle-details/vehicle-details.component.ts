import { Component, OnInit } from '@angular/core';
import { VehicleService } from '../../service/vehicle.service';
import { NonNullableFormBuilder, Validators, FormBuilder } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { CategoryService } from '../../service/category.service';
import { Category } from '../../shared/model/category';
import { Location } from '@angular/common';
import { ActivatedRoute } from '@angular/router';
import { Vehicle } from '../../shared/model/vehicle';
import { Booking } from '../../shared/model/booking';

@Component({
  selector: 'app-vehicle-details',
  templateUrl: './vehicle-details.component.html',
  styleUrls: ['./vehicle-details.component.scss']
})
export class VehicleDetailsComponent implements OnInit {

  status = [
    "AVAILABLE",
    "UNAVAILABLE",
    "DISABLE",
    "MAINTENANCE",
  ];

  form = this.formBuilder.group({
    id: 0,
    vehicleModel: ['', Validators.required],
    licensePlate: ['', Validators.required],
    chassi: ['', Validators.required],
    mileage: [0, Validators.required],
    renavam: ['', Validators.required],
    vehicleYear: ['', Validators.required],
    vehicleStatus: [''],
    category: // [<Category | undefined>(undefined)]
      this.formBuilder.group({
        id: 0,
        name: '',
        dayPrice: 0,
        weekPrice: 0
      })
  })

  public vehicleId!: number;

  categories: Category[] = [];

  constructor(
    private vehicleService: VehicleService,
    private location: Location,
    private formBuilder: NonNullableFormBuilder,
    private snackBar: MatSnackBar,
    private categoryService: CategoryService,
    private route: ActivatedRoute) {

  }

  ngOnInit(): void {
    this.categoryService.list().subscribe((dados) => {
      this.categories = dados;
      this.route.params.subscribe(params => {

        this.vehicleId = params['id'];

        if (this.vehicleId) {
          this.getVehicle();
        }

      })
    });

  }

  getVehicle() {
    this.vehicleService.getVehicleById(this.vehicleId).subscribe(
      resultado => {
        console.log(resultado)
        this.form.patchValue({
          id: resultado.id,
          vehicleModel: resultado.vehicleModel,
          licensePlate: resultado.licensePlate,
          chassi: resultado.chassi,
          mileage: resultado.mileage,
          renavam: resultado.renavam,
          vehicleYear: resultado.vehicleYear,
          category:
          {
            id: resultado.category.id,
            name: resultado.category.name,
            dayPrice: resultado.category.dayPrice,
            weekPrice: resultado.category.weekPrice,
          },
          vehicleStatus: resultado.vehicleStatus
        });

      })

  }

  onCancel() {
    this.location.back();
  }

  onSubmit() {
    console.log(this.form.value)
    this.vehicleService.update(this.form.value).subscribe({
      next: () => this.onSuccess(),
      error: (e) => this.onError()
    });
  }

  private onSuccess() {
    this.snackBar.open('Veículo atualizado com sucesso!', '', { duration: 3000 })
    this.onCancel();
  }

  private onError() {
    this.snackBar.open('Erro ao cadastrar veículo.', '', { duration: 3000 })
  }


  compararObjetos(o1: any, o2: any): boolean {
    return o1.name === o2.name;
  }

}
