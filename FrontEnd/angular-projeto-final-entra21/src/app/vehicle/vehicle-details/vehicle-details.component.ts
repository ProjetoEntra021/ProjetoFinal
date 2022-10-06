import { Component, OnInit } from '@angular/core';
import { VehicleService } from '../../service/vehicle.service';
import { NonNullableFormBuilder, Validators, FormBuilder } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { CategoryService } from '../../service/category.service';
import { Category } from '../../shared/model/category';
import { Location } from '@angular/common';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-vehicle-details',
  templateUrl: './vehicle-details.component.html',
  styleUrls: ['./vehicle-details.component.scss']
})
export class VehicleDetailsComponent implements OnInit {

  form = this.formBuilder.group({
    vehicleModel: ['', Validators.required],
    licensePlate: ['', Validators.required],
    chassi: ['', Validators.required],
    mileage: [0, Validators.required],
    renavam: ['', Validators.required],
    vehicleYear: ['', Validators.required],
    category: [<Category | undefined>(undefined), Validators.required],
    vehicleStatus: ["AVAILABLE"]
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

    this.route.params.subscribe(params => {
      //TODO testar
      this.vehicleId = params['id'];

      if (this.vehicleId) {
        this.getVehicle();
      }
      this.categoryService.list().subscribe((dados) => {
        this.categories = dados
      });
      console.log(this.categories)
    })
  }

  getVehicle() {
    this.vehicleService.getVehicleById(this.vehicleId).subscribe(
      resultado => {
        console.log(resultado)
        this.form.setValue({
          vehicleModel: resultado.vehicleModel,
          licensePlate: resultado.licensePlate,
          chassi: resultado.chassi,
          mileage: resultado.mileage,
          renavam: resultado.renavam,
          vehicleYear: resultado.vehicleYear,
          category: resultado.category,
          vehicleStatus: resultado.vehicleStatus
        })
      })
  }

  onCancel() {
    this.location.back();
  }

  onSubmit() {
    this.vehicleService.save(this.form.value).subscribe({
      next: () => this.onSuccess(),
      error: (e) => this.onError()
    });
  }

  private onSuccess() {
    this.snackBar.open('Veículo cadastrado com sucesso!', '', { duration: 3000 })
    this.onCancel();
  }

  private onError() {
    this.snackBar.open('Erro ao cadastrar veículo.', '', { duration: 3000 })
  }


}
