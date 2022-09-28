import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VehicleMenuComponent } from './vehicle-menu.component';

describe('VehicleMenuComponent', () => {
  let component: VehicleMenuComponent;
  let fixture: ComponentFixture<VehicleMenuComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ VehicleMenuComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(VehicleMenuComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
