import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreatBookingComponent } from './creat-booking.component';

describe('CreatBookingComponent', () => {
  let component: CreatBookingComponent;
  let fixture: ComponentFixture<CreatBookingComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CreatBookingComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CreatBookingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
