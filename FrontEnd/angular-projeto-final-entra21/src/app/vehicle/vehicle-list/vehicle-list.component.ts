import { Component, OnInit, ViewChild, AfterViewInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { catchError, Observable, of } from 'rxjs';
import { Vehicle } from '../../shared/model/vehicle';
import { VehicleService } from '../../service/vehicle.service';
import { MatTableDataSource } from '@angular/material/table';
import { MatSort, Sort } from '@angular/material/sort';
import { LiveAnnouncer } from '@angular/cdk/a11y';
import { Router, ActivatedRoute } from '@angular/router';


@Component({
  selector: 'app-vehicle-list',
  templateUrl: './vehicle-list.component.html',
  styleUrls: ['./vehicle-list.component.scss']
})
export class VehicleListComponent implements OnInit, AfterViewInit {

  readonly displayedColumns: string[] = ['status', 'categoryName', 'licensePlate', 'vehicleModel', 'vehicleYear', 'actions'];

  //vehicles$: Observable<Vehicle[]>;

  dataSource!: MatTableDataSource<Vehicle>;

  @ViewChild(MatSort) sort!: MatSort;

  constructor(
    private vehicleService: VehicleService,
    public dialog: MatDialog,
    private router: Router,
    private route: ActivatedRoute
  ) {

    this.vehicleService.list().subscribe((dados) => {
      console.log(dados);

      for (let vehicle of dados) {
        vehicle.categoryName = vehicle.category.name;
      }


      this.dataSource = new MatTableDataSource(dados);
      this.dataSource.sort = this.sort;
    }
    );

  }

  ngOnInit(): void {

  }

  ngAfterViewInit() {

  }


  // onError(errorMsg: string) {
  //   this.dialog.open(ErrorDialogComponent, {
  //     data: errorMsg
  //   });
  // }

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource!.filter = filterValue.trim().toLowerCase();
  }


  edit(id: number) {
    console.log("clicked")
    this.router.navigate(['add/' + id], { relativeTo: this.route.parent })
  }

  details(id: number) {
    console.log("clicked")
    this.router.navigate(['details/' + id], { relativeTo: this.route.parent })
  }

}
