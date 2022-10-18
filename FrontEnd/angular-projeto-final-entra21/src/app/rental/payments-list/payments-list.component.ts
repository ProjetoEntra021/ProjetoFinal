import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { Payment } from '../../shared/model/payment';
import { PaymentService } from '../../service/payment.service';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-payments-list',
  templateUrl: './payments-list.component.html',
  styleUrls: ['./payments-list.component.scss']
})
export class PaymentsListComponent implements OnInit {

  @Input() payments: Payment[] = [];
  @Output() add = new EventEmitter(false);

  readonly displayedColumns = ['expirationDate', 'paymentValue', 'discount', 'paymentStatus', 'actions'];

  constructor(
    private paymentService: PaymentService,
    private snackBar: MatSnackBar
  ) {
  }

  ngOnInit(): void {
  }


  confirmPayment(id: number) {
    this.paymentService.confirmPayment(id).subscribe({
      next: () => this.onSuccess(),
      error: (e) => this.onError()
    });;
  }

  private onSuccess() {
    this.add.emit(true);
    this.snackBar.open('Pagamento registrado com sucesso!', '', { duration: 3000 })
  }

  private onError() {
    this.snackBar.open('Erro ao registrar pagamento.', '', { duration: 3000 })
  }

  // onClick() {
  //   if (this.action == "Confirmar pagamento") {
  //     this.action = '<mat-icon>done</mat-icon>';
  //   }
  // }

}
