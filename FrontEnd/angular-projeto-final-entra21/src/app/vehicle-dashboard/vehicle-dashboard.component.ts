import { Component, OnInit } from '@angular/core';
import { MatCard } from '@angular/material/card';
import { Observable } from 'rxjs/internal/Observable';
import { VehicleService } from '../service/vehicle.service';
import { VehicleDashDTO } from '../shared/model/dto/vehicleDashDTO';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-vehicle-dashboard',
  templateUrl: './vehicle-dashboard.component.html',
  styleUrls: ['./vehicle-dashboard.component.scss']
})
export class VehicleDashboardComponent implements OnInit {

  public vehicleDashDTO$?: Observable<VehicleDashDTO>;

  constructor(
    private vehicleService: VehicleService,
    private router: Router,
    private route: ActivatedRoute

  ) { }

  ngOnInit(): void {
    this.vehicleDashDTO$ = this.vehicleService.getData();

  }

  goVehicles() {
    this.router.navigate(['../main/vehicles/list']), {relativeTo: this.route};
  }




}
