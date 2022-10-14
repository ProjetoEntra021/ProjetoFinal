import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'bookingStatus'
})
export class BookingStatusPipe implements PipeTransform {

  transform(value: string): string {
    switch (value) {
      case 'ACTIVE': return 'Ativa';
      case 'FINISHED': return 'Concluída';
      case 'PENDING': return 'Pendente';
      case 'CANCELED': return 'Cancelada';
    }
    return 'Disponível';
  }

}
