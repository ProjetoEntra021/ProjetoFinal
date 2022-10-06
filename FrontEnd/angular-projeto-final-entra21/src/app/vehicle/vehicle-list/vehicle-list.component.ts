import { Component, OnInit, ViewChild, AfterViewInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { catchError, Observable, of } from 'rxjs';
import { Vehicle } from '../../shared/model/vehicle';
import { VehicleService } from '../../service/vehicle.service';
import { MatTableDataSource } from '@angular/material/table';
import { MatSort, Sort } from '@angular/material/sort';
import { LiveAnnouncer } from '@angular/cdk/a11y';


@Component({
  selector: 'app-vehicle-list',
  templateUrl: './vehicle-list.component.html',
  styleUrls: ['./vehicle-list.component.scss']
})
export class VehicleListComponent implements OnInit, AfterViewInit {

  readonly displayedColumns: string[] = ['status', 'categoria', 'licensePlate', 'modelo', 'ano', 'actions'];

  //vehicles$: Observable<Vehicle[]>;

  dataSource!: MatTableDataSource<Vehicle>;

  @ViewChild(MatSort) sort!: MatSort;

  constructor(
    private vehicleService: VehicleService,
    public dialog: MatDialog,

  ) {



  }

  ngOnInit(): void {
    this.vehicleService.list().subscribe((dados) => {
      this.dataSource = new MatTableDataSource(dados);
    }
    );
  }

  ngAfterViewInit() {
    this.dataSource.sort = this.sort;
  }


  // onError(errorMsg: string) {
  //   this.dialog.open(ErrorDialogComponent, {
  //     data: errorMsg
  //   });
  // }

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }


}
