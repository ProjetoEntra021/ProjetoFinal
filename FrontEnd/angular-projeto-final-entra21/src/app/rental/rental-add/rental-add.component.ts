import { Component, OnInit } from '@angular/core';
import { NonNullableFormBuilder, Validators } from '@angular/forms';
import { Category } from '../../shared/model/category';
import { CategoryService } from '../../service/category.service';

@Component({
  selector: 'app-rental-add',
  templateUrl: './rental-add.component.html',
  styleUrls: ['./rental-add.component.scss']
})
export class RentalAddComponent implements OnInit {

  form = this.formBuilder.group({
    id: 0,
    vehicleModel: ['', Validators.required],
    pickUpDate: [],
    dropOffDate: [],
    booking: [],
    vehicle: [],
    receipt: [],
    rentalStatus: ["AVAILABLE"],
  })

  categories: Category[] = [];

  constructor(
    private formBuilder: NonNullableFormBuilder,
    private categoryService: CategoryService
  ) { }

  ngOnInit(): void {
    this.categoryService.list().subscribe((dados) => {
      this.categories = dados;
    });
  }

  onSubmit() {

  }

  onCancel() {

  }

}
