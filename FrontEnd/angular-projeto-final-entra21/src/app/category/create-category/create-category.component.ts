import { FormBuilder } from '@angular/forms';
import { Component, OnInit } from '@angular/core';
import { NonNullableFormBuilder, Validators } from '@angular/forms';
import { CategoryService } from '../../service/category.service';
import { Category } from '../../shared/model/category';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';

@Component({
  selector: 'app-create-category',
  templateUrl: './create-category.component.html',
  styleUrls: ['./create-category.component.scss']
})
export class CreateCategoryComponent implements OnInit {

  categoryForm = this.formBuilder.group({
    id: 0,
    name:'',
    dayPrice: 0,
    weekPrice: 0,
  })

  categories: Category[] = [];

  public categoryId!: number;

  constructor(
    private formBuilder: NonNullableFormBuilder,
    private categoryService: CategoryService,
    private snackBar: MatSnackBar,
    private route: ActivatedRoute,
    private location: Location,

  ) { }

  ngOnInit(): void {
    this.categoryService.list().subscribe((data) => {
      this.categories = data;
    })

    this.route.params.subscribe(params => {
      this.categoryId = params['id'];
      if (this.categoryId) {
        this.getCategory();
      }

  })
}
getCategory() {
  this.categoryService.getCategoryById(this.categoryId).subscribe(
    result => {
      console.log(result)
      this.categoryForm.patchValue({
        id:result.id,
        name:result.name,
        dayPrice:result.dayPrice,
        weekPrice:result.weekPrice,
      })
})
}
onSubmit() {
  this.categoryService.addCategory(this.categoryForm.value).subscribe({
    next: () => this.onSuccess(),
    error: (e) => this.onError()
  });
}

private onSuccess() {
  if (this.categoryId) {
    this.snackBar.open('Reserva atualizada com sucesso!', '', { duration: 3000 })
  } else {
    this.snackBar.open('Reserva realizada com sucesso!', '', { duration: 3000 })
  }
  this.back();
}

private onError() {
  this.snackBar.open('Erro ao realizar reserva', '', { duration: 3000 })
}
back() {
  this.location.back();
}
}

