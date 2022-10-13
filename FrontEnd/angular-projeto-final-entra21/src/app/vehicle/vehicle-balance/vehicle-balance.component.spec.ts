import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VehicleBalanceComponent } from './vehicle-balance.component';

describe('VehicleBalanceComponent', () => {
  let component: VehicleBalanceComponent;
  let fixture: ComponentFixture<VehicleBalanceComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ VehicleBalanceComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(VehicleBalanceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
