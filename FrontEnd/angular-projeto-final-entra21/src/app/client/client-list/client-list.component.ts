import { MatDialog } from '@angular/material/dialog';
import { Component, OnInit } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';

import { Client } from '../../shared/model/client';
import { ClientService } from '../../service/client.service';

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
    public dialog: MatDialog
  ) {

    this.clientService.list().subscribe(dados => this.dataSource = new MatTableDataSource<Client>(dados));
  }

  ngOnInit(): void {
  }



}
