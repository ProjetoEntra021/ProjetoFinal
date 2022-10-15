import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'rentalType'
})
export class RentalTypePipe implements PipeTransform {

  transform(value: string): string {
    switch (value) {
      case 'APP DRIVER': return 'Aplicativo';
      case 'PERSONAL': return 'Particular';
    }
    return 'Aplicativo';
  }

}
