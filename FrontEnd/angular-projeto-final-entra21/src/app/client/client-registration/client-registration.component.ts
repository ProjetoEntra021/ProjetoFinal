import { Component, OnInit } from '@angular/core';
import { Client } from '../../shared/model/client';
import { ClientService } from '../../service/client.service';

@Component({
  selector: 'app-client-registration',
  templateUrl: './client-registration.component.html',
  styleUrls: ['./client-registration.component.scss']
})
export class ClientRegistrationComponent implements OnInit {

  public client!: Client;
  constructor(private clientService: ClientService) { }

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
