import { Client } from './../../shared/model/client';
import { ActivatedRoute, Router } from '@angular/router';
import { BookingsService } from './../../service/bookings.service';
import { Booking } from './../../shared/model/booking';
import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Location } from '@angular/common';


@Component({
  selector: 'app-details-booking',
  templateUrl: './details-booking.component.html',
  styleUrls: ['./details-booking.component.scss']
})
export class DetailsBookingComponent implements OnInit {

  public booking!: Booking;
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

      if(this.bookingId) {
        this.bookingService.getBookingById(this.bookingId).subscribe(
          resultado => {
            if(resultado) {
              this.booking = resultado;
            }
            else {
              this.snackBar.open('Erro ao consultar reserva.', '', { duration: 3000 })
            }
          }
        )
      }
    }
    )

  }
  edit(id: number) {
    this.router.navigate(['update/' + id], {relativeTo: this.route.parent})
  }

  onCancel() {
    this.location.back();
  }
}