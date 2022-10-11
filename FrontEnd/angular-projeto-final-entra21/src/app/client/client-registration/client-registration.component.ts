import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { NonNullableFormBuilder, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute, Router } from '@angular/router';

import { ClientService } from '../../service/client.service';
import { Contact } from '../../shared/model/contact';
import { Client } from './../../shared/model/client';

@Component({
  selector: 'app-client-registration',
  templateUrl: './client-registration.component.html',
  styleUrls: ['./client-registration.component.scss']
})
export class ClientRegistrationComponent implements OnInit {



  clientForm = this.formBuilder.group({
    id:0,
    name: ['', Validators.required],
    birthDate: ['', Validators.required],
    cpf: ['', Validators.required],
    cnh: ['', Validators.required],
    gender: ['', Validators.required],
    // addresses: [this.formBuilder.group(this.addressForm)]
    addresses: this.formBuilder.array([
      this.formBuilder.group({
        id:0,
        cep: ['', Validators.required],
        street: ['', Validators.required],
        number: ['', Validators.required],
        complement: ['', Validators.required],
        district: ['', Validators.required],
        city: ['', Validators.required],
        uf: ['', Validators.required],
      })
    ]),
    contacts: this.formBuilder.array([
      this.formBuilder.group({
        id:0,
        contactType: 0,
        description: ['', Validators.required]
      }),
      this.formBuilder.group({
        id:0,
        contactType: 1,
        description: ['', Validators.required]
      })
    ])
  });





  public client!: Client;
  public clientId!: number;
  public contact!: Contact;


  constructor(
    private clientService: ClientService,
    private formBuilder: NonNullableFormBuilder,
    private snackBar: MatSnackBar,
    private location: Location,
    private route: ActivatedRoute,
    public router: Router



  ) { }

  ngOnInit(): void {
    this.route.params.subscribe(params => {

      this.clientId = params['id'];

      if (this.clientId) {
        this.getClient();
      }

    })
  }


  addClient() {
    this.clientService.save(this.clientForm.value).subscribe({
      next: () => this.onSuccess(),
      error: (e) => this.onError()
    });
  }

  getClient() {
    this.clientService.getClientById(this.clientId).subscribe(
      resultado => {
        this.clientForm.patchValue({
          id: resultado.id,
          name: resultado.name,
          birthDate: resultado.birthDate,
          cpf: resultado.cpf,
          cnh: resultado.cnh,
          gender: resultado.gender,
          addresses: [{
            id: resultado.addresses[0].id,
            cep: resultado.addresses[0].cep,
            street: resultado.addresses[0].street,
            number: resultado.addresses[0].number,
            complement: resultado.addresses[0].complement,
            district: resultado.addresses[0].district,
            city: resultado.addresses[0].city,
            uf: resultado.addresses[0].uf
          }],
          contacts: [{
            id: resultado.contacts[0].id,
            description: resultado.contacts[0].description
          },
          {
            id: resultado.contacts[1].id,
            description: resultado.contacts[1].description
          }]

        })
      }
    )
  }

  private onSuccess() {
    this.snackBar.open('Cliente cadastrado com sucesso!', '', { duration: 3000 })
    this.onCancel();
  }

  onCancel() {
    this.location.back();
  }

  private onError() {
    this.snackBar.open('Erro ao cadastrar cliente.', '', { duration: 3000 })
  }


}
