import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ClientComponent } from './client/client.component';
import { ClientMenuComponent } from './client-menu/client-menu.component';
import { ClientRegistrationComponent } from './client-registration/client-registration.component';

const routes: Routes = [
  {
    path: '', component: ClientComponent,
    children: [
      {path: '', component: ClientMenuComponent},
      {path: 'registration', component: ClientRegistrationComponent}

    ]
  },

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ClientRoutingModule { }
