import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'vehicleStatusPipe'
})
export class VehicleStatusPipe implements PipeTransform {

  transform(value: string): string {
    switch (value) {
      case 'AVAILABLE': return 'Disponível';
      case 'UNAVAILABLE': return 'Indisponível';
      case 'DISABLE': return 'Desabilitado';
      case 'MAINTENANCE': return 'Em manutenção';
    }
    return 'Disponível';
  }

}
