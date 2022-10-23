import { Component, OnInit } from '@angular/core';
import { MatCard } from '@angular/material/card';
import { Observable } from 'rxjs/internal/Observable';
import { VehicleService } from '../service/vehicle.service';
import { VehicleDashDTO } from '../shared/model/dto/vehicleDashDTO';

@Component({
  selector: 'app-vehicle-dashboard',
  templateUrl: './vehicle-dashboard.component.html',
  styleUrls: ['./vehicle-dashboard.component.scss']
})
export class VehicleDashboardComponent implements OnInit {

  public vehicleDashDTO$?: Observable<VehicleDashDTO>;

  constructor(
    private vehicleService: VehicleService,

  ) { }

  ngOnInit(): void {
    this.vehicleDashDTO$ = this.vehicleService.getData();

  }




}
