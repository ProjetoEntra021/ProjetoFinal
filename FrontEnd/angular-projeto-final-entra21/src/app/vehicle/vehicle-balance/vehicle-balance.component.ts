import { Component, OnInit } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { Vehicle } from '../../shared/model/vehicle';
import { VehicleService } from '../../service/vehicle.service';
import { ActivatedRoute, Router } from '@angular/router';
import { VehicleExpense } from '../../shared/model/vehicleExpense';
import { VehicleRevenue } from '../../shared/model/vehicleRevenue';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-vehicle-balance',
  templateUrl: './vehicle-balance.component.html',
  styleUrls: ['./vehicle-balance.component.scss']
})
export class VehicleBalanceComponent implements OnInit {

  readonly displayedColumns: string[] = ['description', 'value'];

  public vehicleId!: number;

  public vehicle$?: Observable<Vehicle>;

  public vehicleBalance?: number;

  public vehicleExpenses!: VehicleExpense[];

  public vehicleRevenues!: VehicleRevenue[];

  constructor(
    private vehicleService: VehicleService,
    private route: ActivatedRoute,
  ) {
    this.route.params.subscribe(params => {
      this.vehicleId = params['id'];
      if (this.vehicleId) {
        this.getVehicle(this.vehicleId);
      }
    })

  }

  ngOnInit(): void {

  }

  getVehicle(id: number) {
    this.vehicle$ = this.vehicleService.getVehicleById(id);

    this.vehicle$.subscribe(
      resultado => {
        this.vehicleExpenses = resultado.expenses;
        this.vehicleRevenues = resultado.revenues;
        this.vehicleBalance = this.calculateBalance(resultado);
      })

  }

  calculateBalance(vehicle: Vehicle) {
    let sum = 0;
    for (let expenses of vehicle.expenses) {
      sum -= expenses.value;
    }
    for (let revenues of vehicle.revenues) {
      sum += revenues.value;
    }
    return sum;
  }
}
