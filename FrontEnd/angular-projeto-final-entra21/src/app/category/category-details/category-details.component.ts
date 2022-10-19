import { Vehicle } from './../../shared/model/vehicle';
import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { NonNullableFormBuilder, Validators } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute, Router } from '@angular/router';
import { MatTableDataSource } from '@angular/material/table';
import { CategoryService } from '../../service/category.service';
import { VehicleService } from '../../service/vehicle.service';
import { Category } from '../../shared/model/category';
import { Observable } from 'rxjs';



@Component({
  selector: 'app-category-details',
  templateUrl: './category-details.component.html',
  styleUrls: ['./category-details.component.scss']
})
export class CategoryDetailsComponent implements OnInit {

  readonly  displayedColumns: string[] = ['vehicleModel', 'vehicleStatus'];
  dataSource!: MatTableDataSource<Category>;

  public categoryId!: number;
  category$?: Observable<Category>;


  constructor(
    // private formBuilder: NonNullableFormBuilder,
    // private vehicleService: VehicleService,
     private location: Location,
     private snackBar: MatSnackBar,
     private categoryService: CategoryService,
     private route: ActivatedRoute,
    // private router: Router,
    // public dialog: MatDialog

    ) { }

  ngOnInit(): void {
      this.route.params.subscribe(params => {
      this.categoryId = params['id'];
      if (this.categoryId) {
        this.getCategory(this.categoryId);
      }
   })
  }
   getCategory(id:number){
    this.category$ = this.categoryService.getCategoryById(id);
  //   this.categoryService.getCategoryById(id).subscribe(
  //     result => {
  //       console.log(result);
  //       this.categoryForm.patchValue({
  //         id: result.id,
  //         name: result.name,
  //         dayPrice: result.dayPrice,
  //         weekPrice: result.weekPrice,
  //         vehicle:
  //           {
  //           id:result.veh,
  //           vehicleModel: '',
  //           licensePlate: '',
  //           vehicleStatus: '',
  //          }
  //   })
   }
  //  onSubmit(id: number) {
  //   this.rentalService.cancelRental(id).subscribe({
  //     next: () => this.onSuccess(),
  //     error: (e) => this.onError()
  //   });;
  // }

  private onSuccess() {
    this.snackBar.open('Cancelamento efetuado com sucesso!', '', { duration: 3000 })
    this.onCancel();
  }

  private onError() {
    this.snackBar.open('Erro ao cancelar Locação. Verifique Pendências.', '', { duration: 3000 })
  }


  onCancel() {
    this.location.back();
  }

  refreshComponent() {
    this.ngOnInit();
  }
  }


