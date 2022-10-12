import { Component, OnInit, Output } from '@angular/core';
import { VehicleService } from '../../service/vehicle.service';
import { NonNullableFormBuilder, Validators, FormBuilder } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { CategoryService } from '../../service/category.service';
import { Category } from '../../shared/model/category';
import { Location } from '@angular/common';
import { ActivatedRoute, Router } from '@angular/router';
import { Vehicle } from '../../shared/model/vehicle';
import { Booking } from '../../shared/model/booking';
import { outputAst } from '@angular/compiler';

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
    mileage: [<number | undefined>(undefined), Validators.required],
    renavam: ['', Validators.required],
    vehicleYear: ['', Validators.required],
    vehicleStatus: [''],
    category:
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
    private route: ActivatedRoute,
    private router: Router) {

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

  updatePriceValue(event: any, id: number) {
    if (event.isUserInput) {
      let tempCat = {} as Category;
      for (let cat of this.categories) {
        if (cat.id == id) {
          tempCat = cat;
        }
      }
      this.form.patchValue({
        category:
        {
          dayPrice: tempCat.dayPrice,
          weekPrice: tempCat.weekPrice
        },
      })
    }
  }

  vehicleBalance() {
    this.router.navigate(['balance'], { relativeTo: this.route });
  }
}
