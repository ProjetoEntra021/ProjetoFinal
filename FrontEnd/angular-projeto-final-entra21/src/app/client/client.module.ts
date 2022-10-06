import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ClientRoutingModule } from './client-routing.module';
import { ClientComponent } from './client/client.component';
import { AppMaterialModule } from '../shared/app-material/app-material.module';
import { ClientMenuComponent } from './client-menu/client-menu.component';
import { ClientRegistrationComponent } from './client-registration/client-registration.component';
import { ClientListComponent } from './client-list/client-list.component';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    ClientComponent,
    ClientMenuComponent,
    ClientRegistrationComponent,
    ClientListComponent
  ],
  imports: [
    CommonModule,
    ClientRoutingModule,
    AppMaterialModule,
    FormsModule
  ]
})
export class ClientModule { }
