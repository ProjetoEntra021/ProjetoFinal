import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Client } from '../../shared/model/client';
import { ClientService } from '../../service/client.service';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Location } from '@angular/common';

@Component({
  selector: 'app-client-details',
  templateUrl: './client-details.component.html',
  styleUrls: ['./client-details.component.scss']
})
export class ClientDetailsComponent implements OnInit {

  public client!: Client;
  public clientId!: number;

  constructor(
    private snackBar: MatSnackBar,
    private route: ActivatedRoute,
    private router: Router,
    private location: Location,
    private clientService: ClientService
  ) { }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.clientId = params['id'];

      if(this.clientId) {
        this.clientService.getClientById(this.clientId).subscribe(
          resultado => {
            if(resultado) {
              this.client = resultado;
            }
            else {
              this.snackBar.open('Erro ao consultar cliente.', '', { duration: 3000 })
            }
          }
        )
      }
    })

  }
  edit(id: number) {
    this.router.navigate(['registration/' + id], {relativeTo: this.route.parent})
  }

  onCancel() {
    this.location.back();
  }



}
