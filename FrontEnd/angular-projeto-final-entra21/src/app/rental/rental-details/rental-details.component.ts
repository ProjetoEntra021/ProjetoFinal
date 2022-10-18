import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';

import { RentalService } from '../../service/rental.service';
import { Rental } from '../../shared/model/rental';

@Component({
  selector: 'app-rental-details',
  templateUrl: './rental-details.component.html',
  styleUrls: ['./rental-details.component.scss']
})
export class RentalDetailsComponent implements OnInit {

  rental$?: Observable<Rental>;

  rentalId?: number;

  constructor(
    private route: ActivatedRoute,
    private rentalService: RentalService,
    private location: Location,
    private snackBar: MatSnackBar

  ) {

  }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.rentalId = params['id'];
      if (this.rentalId) {
        this.getRental(this.rentalId);
      }
    })
  }


  getRental(id: number) {
    this.rental$ = this.rentalService.findById(id);
    // this.form.patchValue(
    //   {
    //     category: dados.vehicle.category.name,
    //     pickUpDate: dados.pickUpDate,
    //     dropOffDate: dados.dropOffDate,
    //     totalValue: dados.totalValue,
    //     rentalStatus: dados.rentalStatus,
    //     rentalType: dados.rentalType,
    //     clientName: dados.booking.client.name,
    //     vehicleModel: dados.vehicle.vehicleModel + " - " + dados.vehicle.licensePlate
    //   })
  }

  onSubmit(id: number) {
    this.rentalService.cancelRental(id).subscribe({
      next: () => this.onSuccess(),
      error: (e) => this.onError()
    });;
  }

  private onSuccess() {
    this.snackBar.open('Pagamento registrado com sucesso!', '', { duration: 3000 })
  }

  private onError() {
    this.snackBar.open('Erro ao registrar pagamento.', '', { duration: 3000 })
  }
  

  onCancel() {
    this.location.back();
  }

  refreshComponent() {
    this.ngOnInit();
  }
}
