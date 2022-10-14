import { HomePageComponent } from './home-page/home-page.component';
import { MainViewModule } from './../main-view/main-view.module';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeLoginComponent } from './home-login/home-login.component';

const routes: Routes = [
  {path: '', component: HomePageComponent},
  {path: 'login', component: HomeLoginComponent},
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class HomeRoutingModule { }
