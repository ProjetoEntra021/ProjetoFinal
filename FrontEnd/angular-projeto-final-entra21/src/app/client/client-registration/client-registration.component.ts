import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { NonNullableFormBuilder, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { AddressService } from 'src/app/service/address.service';

import { ClientService } from '../../service/client.service';
import { Address } from '../../shared/model/address';

import { Contact } from '../../shared/model/contact';
import { Client } from './../../shared/model/client';

@Component({
  selector: 'app-client-registration',
  templateUrl: './client-registration.component.html',
  styleUrls: ['./client-registration.component.scss']
})
export class ClientRegistrationComponent implements OnInit {

  addressForm = this.formBuilder.group ({
    cep: ['', Validators.required],
    street: ['', Validators.required],
    number: ['', Validators.required],
    complement: ['', Validators.required],
    district: ['', Validators.required],
    city: ['', Validators.required],
    uf: ['', Validators.required],

  })

  clientForm = this.formBuilder.group({
    name: ['', Validators.required],
    birthDate: ['', Validators.required],
    cpf: ['', Validators.required],
    cnh: ['', Validators.required],
    gender: ['', Validators.required],
    // addresses: [this.formBuilder.group(this.addressForm)]

  });



  public client!: Client;
  public address: Partial<Address> = this.addressForm.value
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
    this.client.addresses.push(this.address)
    this.clientService.save(this.clientForm.value).subscribe({
      next: () => this.onSuccess(),
      error: (e) => this.onError()
    });
  }




  // private addAddress() {

  //   this.addressService.save(this.addressForm.value).pipe(

  //   )


  // }

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
