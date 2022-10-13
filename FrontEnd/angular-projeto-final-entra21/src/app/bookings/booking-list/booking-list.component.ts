import { BookingsService } from '../../service/bookings.service';
import { Booking } from './../../shared/model/booking';
import { Component, OnInit, ViewChild, AfterViewInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { catchError, Observable, of } from 'rxjs';
import { MatTableDataSource } from '@angular/material/table';
import { MatSort, Sort } from '@angular/material/sort';
import { LiveAnnouncer } from '@angular/cdk/a11y';
import { Router, ActivatedRoute } from '@angular/router';



@Component({
  selector: 'app-booking-list',
  templateUrl: './booking-list.component.html',
  styleUrls: ['./booking-list.component.scss']
})
export class BookingListComponent implements OnInit {

  readonly displayedColumns: string[] = ['status', 'dataRetirada', 'cliente', 'categoria', 'detalhe'];

  dataSource!: MatTableDataSource<Booking>;

  @ViewChild("sort") sort: MatSort = new MatSort();

  constructor(
    private bookingsService: BookingsService,
    public dialog: MatDialog,
    private router: Router,
    private route: ActivatedRoute,
    private _liveAnnouncer: LiveAnnouncer
  ) {
    this.bookingsService.list().subscribe(dados => this.dataSource = new MatTableDataSource<Booking>(dados));

  }

  ngOnInit(): void {

    bookingsService: Observable <Booking[]>;
  }

  details(id: number) {
    console.log("clicked")
    this.router.navigate(['details/' + id], { relativeTo: this.route.parent })

  }
}
