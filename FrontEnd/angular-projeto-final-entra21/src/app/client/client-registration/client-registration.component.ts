import { Component, OnInit } from '@angular/core';
import { NonNullableFormBuilder, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ClientService } from '../../service/client.service';
import { Client } from '../../shared/model/client';
import { Location } from '@angular/common';
import { Address } from '../../shared/model/address';
import { Contact } from '../../shared/model/contact';
import { AddressService } from 'src/app/service/address.service';

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

    addressForm = this.formBuilder.group ({
    cep: ['', Validators.required],
    street: ['', Validators.required],
    number: ['', Validators.required],
    complement: ['', Validators.required],
    district: ['', Validators.required],
    city: ['', Validators.required],
    uf: ['', Validators.required],

  })

  public client!: Client;
  public address!: Address;
  public contact!: Contact;


  constructor(
    private clientService: ClientService,
    private formBuilder: NonNullableFormBuilder,
    private snackBar: MatSnackBar,
    private location: Location,
    private addressService: AddressService,


    ) { }

  ngOnInit(): void {
  }


  addClient() {
    this.clientService.save(this.clientForm.value).subscribe(
       {
        next: () => this.onSuccess(),
        error: (e) => this.onError()
      }
    )
    this.address.client = this.client;
    this.addressService.save(this.addressForm.value).subscribe({
        next: () => this.onSuccess(),
        error: (e) => this.onError()
    })
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
