import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';

import { AppMaterialModule } from '../shared/app-material/app-material.module';
import { MainViewRoutingModule } from './main-view-routing.module';
import { MainViewComponent } from './main-view/main-view.component';
import { FormsModule } from '@angular/forms';
import { MainTableComponent } from './main-table/main-table.component';


@NgModule({
  declarations: [
    MainViewComponent,
    MainTableComponent
  ],
  imports: [
    CommonModule,
    MainViewRoutingModule,
    AppMaterialModule,
    FormsModule
  ]
})
export class MainViewModule { }
