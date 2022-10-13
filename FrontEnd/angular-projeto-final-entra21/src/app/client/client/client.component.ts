import { Component, OnInit, Input } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute, Router } from '@angular/router';
import { ClientService } from '../../service/client.service';
import { Client } from '../../shared/model/client';


@Component({
  selector: 'app-client',
  templateUrl: './client.component.html',
  styleUrls: ['./client.component.scss']
})
export class ClientComponent implements OnInit {

  constructor(
    private clientService: ClientService,
    private snackBar: MatSnackBar,
    private router: Router,
    private route: ActivatedRoute
  ) { }

  ngOnInit(): void {
  }
  public client!: Client;
  public clientParam!: string;

  
  onSubmit() {
  return this.clientParam;
}

  clientList() {
    this.router.navigate(['list'], {relativeTo: this.route});
  }

  findClientByCpf() {
    this.router.navigate(['details/cpf/' + this.onSubmit()], {relativeTo: this.route});
          console.log(this.onSubmit);
  }


}
