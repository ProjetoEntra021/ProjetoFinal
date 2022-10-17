import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'paymentStatus'
})
export class PaymentStatusPipe implements PipeTransform {

  transform(value: string): string {
    switch (value) {
      case 'WAITINGPAYMENT': return 'Aguardando pagamento';
      case 'PENDING': return 'Pendente';
      case 'PAID': return 'Pago';
      case 'CANCELED': return 'Cancelado';
    }
    return 'Aguardando pagamento';
  }

}
