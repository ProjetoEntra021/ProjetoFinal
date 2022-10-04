import { Component, OnInit, ViewChild, AfterViewInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { catchError, Observable, of } from 'rxjs';
import { Vehicle } from '../../shared/model/vehicle';
import { VehicleService } from '../vehicle.service';
import { MatTableDataSource } from '@angular/material/table';
import { MatSort, Sort } from '@angular/material/sort';
import { LiveAnnouncer } from '@angular/cdk/a11y';


@Component({
  selector: 'app-vehicle-list',
  templateUrl: './vehicle-list.component.html',
  styleUrls: ['./vehicle-list.component.scss']
})
export class VehicleListComponent implements OnInit {

  readonly displayedColumns: string[] = ['status', 'categoria', 'modelo', 'ano', 'actions'];

  //vehicles$: Observable<Vehicle[]>;

  dataSource!: MatTableDataSource<Vehicle>;

  @ViewChild("sort") sort: MatSort = new MatSort();

  constructor(
    private vehicleService: VehicleService,
    public dialog: MatDialog,

  ) {
    this.vehicleService.list().subscribe(dados => this.dataSource = new MatTableDataSource<Vehicle>(dados));


  }

  ngOnInit(): void {

  }

  ngAfterViewInit() {
    this.sort.disableClear = true;
    this.dataSource.sort = this.sort;
  }


  // onError(errorMsg: string) {
  //   this.dialog.open(ErrorDialogComponent, {
  //     data: errorMsg
  //   });
  // }



}
