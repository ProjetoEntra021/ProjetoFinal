import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RentalsDashboardComponent } from './rentals-dashboard.component';

describe('RentalsDashboardComponent', () => {
  let component: RentalsDashboardComponent;
  let fixture: ComponentFixture<RentalsDashboardComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RentalsDashboardComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RentalsDashboardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
