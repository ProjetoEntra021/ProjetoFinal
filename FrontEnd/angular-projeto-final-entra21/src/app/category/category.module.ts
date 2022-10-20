import { SharedModule } from './../shared/shared.module';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CategoryRoutingModule } from './category-routing.module';
import { CategoryListComponent } from './category-list/category-list.component';
import { AppMaterialModule } from '../shared/app-material/app-material.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { CreateCategoryComponent } from './create-category/create-category.component';
import { CategoryDetailsComponent } from './category-details/category-details.component';


@NgModule({
  declarations: [
    CategoryListComponent,
    CreateCategoryComponent,
    CategoryDetailsComponent
  ],
  imports: [
    CommonModule,
    CategoryRoutingModule,
    AppMaterialModule,
    FormsModule,
    ReactiveFormsModule,
    SharedModule,
  ]
})
export class CategoryModule { }
