import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { NonNullableFormBuilder, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute, Router } from '@angular/router';

import { ClientService } from '../../service/client.service';
import { Contact } from '../../shared/model/contact';
import { Client } from './../../shared/model/client';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-client-registration',
  templateUrl: './client-registration.component.html',
  styleUrls: ['./client-registration.component.scss']
})
export class ClientRegistrationComponent implements OnInit {



  clientForm = this.formBuilder.group({
    id: 0,
    name: ['', Validators.required],
    birthDate: ['', Validators.required],
    cpf: ['', Validators.required],
    cnh: ['', Validators.required],
    gender: ['', Validators.required],
    addresses: this.formBuilder.array([
      this.formBuilder.group({
        id: 0,
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
        id: [<number | undefined>(undefined)],
        contactType: 0,
        description: ['', Validators.required]
      }),
      this.formBuilder.group({
        id: [<number | undefined>(undefined)],
        contactType: 1,
        description: ['', Validators.required]
      })
    ]),
    company: this.formBuilder.group({
      id: Number(sessionStorage.getItem('token'))
    })
  });


  public nullContact: Partial<Contact> = {
    id: 0,
    description: ''
  }


  public client!: Client;
  public clientId!: number;
  public contact!: Contact;


  constructor(
    private clientService: ClientService,
    private formBuilder: NonNullableFormBuilder,
    private snackBar: MatSnackBar,
    private location: Location,
    private route: ActivatedRoute,
    public router: Router,
    private httpClient: HttpClient


  ) { }

  ngOnInit(): void {

    this.route.params.subscribe(params => {

      this.clientId = params['id'];

      if (this.clientId) {
        this.getClient();
      }

    })
  }

  onClickSave() {
    if (this.clientId) {
      this.updateClient();
    }
    else {
      this.addClient();
    }
  }

  addClient() {
    console.log(this.clientForm.value)
    this.clientService.save(this.clientForm.value).subscribe({
      next: (client) => this.onSuccess(client.id!),
      error: (e) => this.onError()
    });
  }

  updateClient() {
    console.log(this.clientForm.value)
    this.clientService.update(this.clientForm.value).subscribe({
      next: () => this.onSuccess(this.clientId),
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
        })

        if (resultado.addresses.length != 0) {
          this.clientForm.patchValue({
            addresses: [{
              id: resultado.addresses[0].id,
              cep: resultado.addresses[0].cep,
              street: resultado.addresses[0].street,
              number: resultado.addresses[0].number,
              complement: resultado.addresses[0].complement,
              district: resultado.addresses[0].district,
              city: resultado.addresses[0].city,
              uf: resultado.addresses[0].uf
            }]

          })
        }

        if (resultado.contacts.length != 0) {
          this.clientForm.patchValue({
            contacts: [{
              id: resultado.contacts[0].id,
              description: resultado?.contacts[0].description
            },
            {
              id: resultado.contacts[1].id,
              description: resultado?.contacts[1].description
            }]

          })
        }

      }
    )
  }

  private onSuccess(id: number) {
    this.snackBar.open('Cliente cadastrado com sucesso!', '', { duration: 3000 })
    this.router.navigate(['../main/clients/details/' + id]), { relativeTo: this.route };
  }

  onCancel() {
    this.location.back();
  }

  private onError() {
    this.snackBar.open('Erro ao cadastrar cliente.', '', { duration: 3000 })
  }


  consultaViaCep(cep: string) {
    type ViaCepObject = {
      logradouro: string,
      complemento: string,
      bairro: string,
      localidade: string,
      uf: string
    }

    this.httpClient.get<ViaCepObject>('https:viacep.com.br/ws/' + cep + '/json/').subscribe((dados) => {
      this.clientForm.patchValue({
        addresses: [{
          street: dados.logradouro,
          complement: dados.complemento,
          district: dados.bairro,
          city: dados.localidade,
          uf: dados.uf
        }]
      })
    })
  }
}
