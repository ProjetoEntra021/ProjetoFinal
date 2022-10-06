import { Component, OnInit } from '@angular/core';
import { NonNullableFormBuilder, Validators } from '@angular/forms';

import { ClientService } from '../../service/client.service';
import { Client } from '../../shared/model/client';

@Component({
  selector: 'app-client-registration',
  templateUrl: './client-registration.component.html',
  styleUrls: ['./client-registration.component.scss']
})
export class ClientRegistrationComponent implements OnInit {

  clientForm = this.formBuilder.group({
    name: ['', Validators.required],
    birthDate: ['', Validators.required],
    cpf: ['', Validators.required],
    cnh: ['', Validators.required],
    gender: ['', Validators.required],
  })

  public client!: Client;

  constructor(
    private clientService: ClientService,
    private formBuilder: NonNullableFormBuilder,

    ) { }

  ngOnInit(): void {
  }

  addClient() {
    this.clientService.addClient(this.client).subscribe(
      resultado => {
        this.client = resultado;
        alert("Cliente salvo!");

      }
    )
  }
}
