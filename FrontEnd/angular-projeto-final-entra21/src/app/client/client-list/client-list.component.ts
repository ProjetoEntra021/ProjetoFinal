import { MatDialog } from '@angular/material/dialog';
import { Component, OnInit } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { Location } from '@angular/common';
import { Client } from '../../shared/model/client';
import { ClientService } from '../../service/client.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-client-list',
  templateUrl: './client-list.component.html',
  styleUrls: ['./client-list.component.scss']
})
export class ClientListComponent implements OnInit {

  readonly displayedColumns: string[] = ['id','nome', 'cpf', 'actions'];
  dataSource!: MatTableDataSource<Client>;



  constructor(
    private clientService: ClientService,
    public dialog: MatDialog,
    private router: Router,
    private location: Location,
    private route: ActivatedRoute
  ) {

    this.clientService.list().subscribe(dados => this.dataSource = new MatTableDataSource<Client>(dados));
  }

  ngOnInit(): void {
  }

  edit(id: number) {
    this.router.navigate(['registration/' + id], { relativeTo: this.route.parent })
  }

  detail(id: number) {
    this.router.navigate(['details/' + id], {relativeTo: this.route.parent})
  }

  onCancel() {
    this.location.back();
  }


}
