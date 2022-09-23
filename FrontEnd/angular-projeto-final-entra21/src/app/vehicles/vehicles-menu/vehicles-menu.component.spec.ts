import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VehiclesMenuComponent } from './vehicles-menu.component';

describe('VehiclesMenuComponent', () => {
  let component: VehiclesMenuComponent;
  let fixture: ComponentFixture<VehiclesMenuComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ VehiclesMenuComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(VehiclesMenuComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
