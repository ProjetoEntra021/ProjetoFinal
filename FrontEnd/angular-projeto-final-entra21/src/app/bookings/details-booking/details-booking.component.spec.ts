import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DetailsBookingComponent } from './details-booking.component';

describe('DetailsBookingComponent', () => {
  let component: DetailsBookingComponent;
  let fixture: ComponentFixture<DetailsBookingComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DetailsBookingComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DetailsBookingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
