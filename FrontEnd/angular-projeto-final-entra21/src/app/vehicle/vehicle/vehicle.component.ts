import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-vehicle',
  templateUrl: './vehicle.component.html',
  styleUrls: ['./vehicle.component.scss']
})
export class VehicleComponent implements OnInit {

  showList = false;

  showEdit = false;

  showMenu = true;

  constructor() { }

  ngOnInit(): void {
  }


  vehicleList() {
    this.showList = true;
    this.showEdit = false;
    this.showMenu = false;
  }


}
