import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'vehicle'
})
export class VehiclePipe implements PipeTransform {

  transform(value: string, ...args: unknown[]): unknown {
    switch(value){
      case 'AVAILABLE':
    }
    return null;
  }

}
