import { PaymentService } from './../service/payment.service';
import { Component, OnInit } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { paymentDashDTO } from '../shared/model/dto/paymentDashDTO';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-rentals-dashboard',
  templateUrl: './rentals-dashboard.component.html',
  styleUrls: ['./rentals-dashboard.component.scss']
})
export class RentalsDashboardComponent implements OnInit {

  readonly displayedColumns: string[] = ['client','expirationDate', 'paymentValue'];
  dataSource!: MatTableDataSource<paymentDashDTO>;

  constructor(
    private paymentService: PaymentService,
    private router: Router,
    private route: ActivatedRoute
  ) {

    this.paymentService.list().subscribe((dados) => {
      this.dataSource = new MatTableDataSource<paymentDashDTO>(dados);
    });
  }

  ngOnInit(): void {
  }

  goRentals() {
    this.router.navigate(['../main/rentals']), {relativeTo: this.route};
  }

  goThisRental(id: number) {
    this.router.navigate(['../main/rentals/details/' + id]), {relativeTo: this.route};
  }
}
