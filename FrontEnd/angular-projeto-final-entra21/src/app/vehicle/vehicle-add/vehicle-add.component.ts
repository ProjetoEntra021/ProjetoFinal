import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, FormBuilder, NonNullableFormBuilder, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Category } from 'src/app/shared/model/category';
import { VehicleService } from '../../service/vehicle.service';
import { CategoryService } from '../../service/category.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-vehicle-add',
  templateUrl: './vehicle-add.component.html',
  styleUrls: ['./vehicle-add.component.scss']
})
export class VehicleAddComponent implements OnInit {

  form = this.formBuilder.group({
    vehicleModel: ['', Validators.required],
    licensePlate: ['', Validators.required],
    chassi: ['', Validators.required],
    mileage: [, Validators.required],
    renavam: ['', Validators.required],
    vehicleYear: [, Validators.required],
    vehicleStatus: ["AVAILABLE"],
    category: [, Validators.required],
  })

  categories: Category[] = [];

  constructor(
    private vehicleService: VehicleService,
    private location: Location,
    private formBuilder: NonNullableFormBuilder,
    private snackBar: MatSnackBar,
    private categoryService: CategoryService) {

  }

  ngOnInit(): void {
    this.categoryService.list().subscribe((dados) => {
      this.categories = dados
    });
    console.log(this.categories)
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
