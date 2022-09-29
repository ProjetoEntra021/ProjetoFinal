import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { catchError, Observable, of } from 'rxjs';
import { Vehicle } from '../../shared/model/vehicle';
import { VehicleService } from '../vehicle.service';


@Component({
  selector: 'app-vehicle-list',
  templateUrl: './vehicle-list.component.html',
  styleUrls: ['./vehicle-list.component.scss']
})
export class VehicleListComponent implements OnInit {

  vehicles$: Observable<Vehicle[]>;

  constructor(
    private vehicleService: VehicleService,
    public dialog: MatDialog
  ) {
    this.vehicles$ = this.vehicleService.list()
      // .pipe(
      //   catchError(error => {
      //      this.onError('Erro ao carregar pedidos.')
      //     return of([]) )
      //   }
      ;
  }


  // onError(errorMsg: string) {
  //   this.dialog.open(ErrorDialogComponent, {
  //     data: errorMsg
  //   });
  // }

  ngOnInit(): void {
  }

  readonly displayedColumns: string[] = ['status', 'categoria', 'modelo', 'ano', 'actions'];
}
