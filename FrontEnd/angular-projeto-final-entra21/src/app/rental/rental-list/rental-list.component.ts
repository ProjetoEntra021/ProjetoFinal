import { Component, OnInit, ViewChild } from '@angular/core';
import { RentalService } from '../../service/rental.service';
import { Router, ActivatedRoute } from '@angular/router';
import { MatTableDataSource } from '@angular/material/table';
import { Rental } from '../../shared/model/rental';
import { MatSort } from '@angular/material/sort';

@Component({
  selector: 'app-rental-list',
  templateUrl: './rental-list.component.html',
  styleUrls: ['./rental-list.component.scss']
})
export class RentalListComponent implements OnInit {

  readonly displayedColumns: string[] = ['status', 'rentalType', 'pickUpDate', 'dropOffDate', 'totalValue', 'vehicleModel', 'actions'];

  dataSource!: MatTableDataSource<Rental>;

  @ViewChild(MatSort) sort!: MatSort;

  constructor(
    private rentalService: RentalService,
    private router: Router,
    private route: ActivatedRoute
  ) { }

  ngOnInit(): void {
    this.rentalService.list().subscribe((dados) => {
      console.log(dados);


      this.dataSource = new MatTableDataSource(dados);
      this.dataSource.sort = this.sort;
    }
    );
  }



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
