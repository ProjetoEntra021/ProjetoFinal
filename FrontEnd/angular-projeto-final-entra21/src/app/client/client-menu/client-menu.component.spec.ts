import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ClientMenuComponent } from './client-menu.component';

describe('ClientMenuComponent', () => {
  let component: ClientMenuComponent;
  let fixture: ComponentFixture<ClientMenuComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ClientMenuComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ClientMenuComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
