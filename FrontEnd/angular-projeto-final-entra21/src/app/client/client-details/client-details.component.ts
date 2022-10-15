import { Observable } from 'rxjs';
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

  public client$?: Observable<Client>;
  public clientId?: number;
  public clientCpf?: string;

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
      this.clientCpf = params['cpf'];

      if (this.clientId) {
        this.client$ = this.clientService.getClientById(this.clientId);
      }
      else if (this.clientCpf) {
        this.client$ = this.clientService.getClientByCpf(this.clientCpf);
      }
    })

  }
  edit(id: number) {
    this.router.navigate(['registration/' + id], { relativeTo: this.route.parent })
  }

  addBooking(id: number) {
    console.log(this.route.parent?.parent)
    this.router.navigate(['../main/bookings/create/' + id]), { relativeTo: this.route }
  }

  onCancel() {
    this.location.back();
  }



}
