import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ClientComponent } from './client/client.component';
import { ClientMenuComponent } from './client-menu/client-menu.component';
import { ClientRegistrationComponent } from './client-registration/client-registration.component';
import { ClientListComponent } from './client-list/client-list.component';
import { ClientDetailsComponent } from './client-details/client-details.component';

const routes: Routes = [
  {
    path: '', component: ClientComponent,
    children: [
      {path: '', component: ClientMenuComponent},
      {path: 'list', component: ClientListComponent},
      {path: 'registration', component: ClientRegistrationComponent},
      {path: 'registration/:id', component: ClientRegistrationComponent},
      {path: 'details/:id', component: ClientDetailsComponent}
    ]
  },

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ClientRoutingModule { }
