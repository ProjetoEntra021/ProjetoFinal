import { CategoryDetailsComponent } from './category-details/category-details.component';
import { CategoryListComponent } from './category-list/category-list.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreateCategoryComponent } from './create-category/create-category.component';

const routes: Routes = [
  { path: '', component: CategoryListComponent },
  { path: 'create', component: CreateCategoryComponent },
  { path: 'create/:id', component: CreateCategoryComponent},
  { path: 'details/:id', component: CategoryDetailsComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CategoryRoutingModule { }
