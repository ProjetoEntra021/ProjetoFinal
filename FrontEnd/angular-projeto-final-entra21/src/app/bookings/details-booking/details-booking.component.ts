import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';

import { BookingsService } from './../../service/bookings.service';
import { Booking } from './../../shared/model/booking';
import { Client } from './../../shared/model/client';


@Component({
  selector: 'app-details-booking',
  templateUrl: './details-booking.component.html',
  styleUrls: ['./details-booking.component.scss']
})
export class DetailsBookingComponent implements OnInit {

  public booking$?: Observable<Booking>;
  public client!: Client;
  public bookingId!: number;


  constructor(
    private bookingService: BookingsService,
    private route: ActivatedRoute,
    private router: Router,
    private snackBar: MatSnackBar,
    private location: Location,

  ) { }

  ngOnInit(): void {

    this.route.params.subscribe(params => {
      this.bookingId = params['id'];

      if (this.bookingId) {
        this.booking$ = this.bookingService.getBookingById(this.bookingId);
      }
    }
    )

  }
  edit(id: number) {
    this.router.navigate(['update/' + id], { relativeTo: this.route.parent })
  }

  createRental(id: number) {
    this.router.navigate(['../rentals/' + id + '/add'], { relativeTo: this.route.parent })
  }

  onSubmit(id:number) {
    this.bookingService.cancelBooking(id).subscribe({
      next: () => this.onSuccess(),
      error: (e) => this.onError()
    });;
  }

  private onSuccess() {
    this.snackBar.open('Cancelamento efetuado com sucesso!', '', { duration: 3000 })
    this.onCancel();
  }

  private onError() {
    this.snackBar.open('Erro ao cancelar Reserva.', '', { duration: 3000 })
  }

  onCancel() {
    this.location.back();
  }

  refreshComponent() {
    this.ngOnInit();
  }
}
