import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { AppMaterialModule } from '../shared/app-material/app-material.module';
import { SharedModule } from '../shared/shared.module';
import { MainTableComponent } from './../main-table/main-table.component';
import { MainViewRoutingModule } from './main-view-routing.module';
import { MainViewComponent } from './main-view/main-view.component';


@NgModule({
  declarations: [
    MainViewComponent,
    MainTableComponent
  ],
  imports: [
    CommonModule,
    MainViewRoutingModule,
    AppMaterialModule,
    FormsModule,
    SharedModule
  ]
})
export class MainViewModule { }
