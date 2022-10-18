import { MainViewModule } from './../main-view/main-view.module';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { HomeRoutingModule } from './home-routing.module';
import { HomePageComponent } from './home-page/home-page.component';
import { HomeLoginComponent } from './home-login/home-login.component';
import { AppMaterialModule } from '../shared/app-material/app-material.module';
import { SharedModule } from '../shared/shared.module';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    HomePageComponent,
    HomeLoginComponent
  ],
  imports: [
    CommonModule,
    HomeRoutingModule,
    MainViewModule,
    AppMaterialModule,
    FormsModule,
    SharedModule
  ]
})
export class HomeModule { }
