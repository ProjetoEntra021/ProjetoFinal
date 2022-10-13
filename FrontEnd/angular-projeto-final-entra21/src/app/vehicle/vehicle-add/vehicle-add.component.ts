import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { NonNullableFormBuilder, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Category } from 'src/app/shared/model/category';

import { CategoryService } from '../../service/category.service';
import { VehicleService } from '../../service/vehicle.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-vehicle-add',
  templateUrl: './vehicle-add.component.html',
  styleUrls: ['./vehicle-add.component.scss']
})
export class VehicleAddComponent implements OnInit {

  form = this.formBuilder.group({
    id: 0,
    vehicleModel: ['', Validators.required],
    licensePlate: ['', Validators.required],
    chassi: ['', Validators.required],
    mileage: [<number | undefined>(undefined), Validators.required],
    renavam: ['', Validators.required],
    vehicleYear: ['', Validators.required],
    vehicleStatus: ["AVAILABLE"],
    category: this.formBuilder.group({
      id: 0,
      name: ''
    })
  })

  categories: Category[] = [];

  public vehicleId!: number;

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
      this.vehicleId = params['id'];
      if (this.vehicleId) {
        this.getVehicle(this.vehicleId);
      }
      this.categoryService.list().subscribe((dados) => {
        this.categories = dados;
      });
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

  getVehicle(id: number) {
    this.vehicleService.getVehicleById(id).subscribe(
      resultado => {
        console.log(resultado);
        this.form.patchValue({
          id: resultado.id,
          vehicleModel: resultado.vehicleModel,
          licensePlate: resultado.licensePlate,
          chassi: resultado.chassi,
          mileage: resultado.mileage,
          renavam: resultado.renavam,
          vehicleYear: resultado.vehicleYear,
          category: {
            id: resultado.category.id,
            name: resultado.category.name
          },
          vehicleStatus: resultado.vehicleStatus
        });
      })
  }

  compararObjetos(o1: any, o2: any): boolean {
    return o1.name === o2.name;
  }
}
