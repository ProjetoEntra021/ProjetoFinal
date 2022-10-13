import { TestBed } from '@angular/core/testing';

import { VehicleExpenseService } from './vehicle-expense.service';

describe('VehicleExpenseService', () => {
  let service: VehicleExpenseService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(VehicleExpenseService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
