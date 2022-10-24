import { Component, OnInit, ViewChild } from '@angular/core';
import { RentalService } from '../../service/rental.service';
import { Router, ActivatedRoute } from '@angular/router';
import { MatTableDataSource } from '@angular/material/table';
import { Rental } from '../../shared/model/rental';
import { MatSort } from '@angular/material/sort';
import { animate, state, style, transition, trigger } from '@angular/animations';
import { Payment } from '../../shared/model/payment';

@Component({
  selector: 'app-rental-list',
  templateUrl: './rental-list.component.html',
  styleUrls: ['./rental-list.component.scss'],
  animations: [
    trigger('detailExpand', [
      state('collapsed', style({ height: '0px', minHeight: '0px' })),
      state('expanded', style({ height: '*' })),
      transition('expanded <=> collapsed', animate('225ms cubic-bezier(0.4, 0.0, 0.2, 1)')),
    ]),
  ],
})
export class RentalListComponent implements OnInit {

  readonly displayedColumns: string[] = ['rentalStatus', 'rentalType', 'pickUpDate', 'dropOffDate', 'totalValue', 'vehicleModel', 'actions'];

  columnsToDisplayWithExpand = [...this.displayedColumns, 'expand'];

  expandedRental!: Rental | null;

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

  refreshComponent() {
    this.ngOnInit();
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

  checkPaymentStatus() {

  }

}
