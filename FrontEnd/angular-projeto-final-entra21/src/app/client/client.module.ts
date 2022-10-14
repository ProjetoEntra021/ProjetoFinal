import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { AppMaterialModule } from '../shared/app-material/app-material.module';
import { SharedModule } from '../shared/shared.module';
import { ClientDetailsComponent } from './client-details/client-details.component';
import { ClientListComponent } from './client-list/client-list.component';
import { ClientMenuComponent } from './client-menu/client-menu.component';
import { ClientRegistrationComponent } from './client-registration/client-registration.component';
import { ClientRoutingModule } from './client-routing.module';
import { ClientComponent } from './client/client.component';

@NgModule({
  declarations: [
    ClientComponent,
    ClientMenuComponent,
    ClientRegistrationComponent,
    ClientListComponent,
    ClientDetailsComponent
  ],
  imports: [
    CommonModule,
    ClientRoutingModule,
    AppMaterialModule,
    FormsModule,
    ReactiveFormsModule,
    SharedModule
  ]
})
export class ClientModule { }
