import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-vehicle-menu',
  templateUrl: './vehicle-menu.component.html',
  styleUrls: ['./vehicle-menu.component.scss']
})
export class VehicleMenuComponent implements OnInit {

  @Output() show = new EventEmitter(false);

  constructor(
    private router: Router,
    private route: ActivatedRoute) { }

  ngOnInit(): void {
  }

  vehicleList() {
   this.router.navigate(['list'], {relativeTo: this.route});
  }

  vehicleAdd() {
    this.router.navigate(['add'], {relativeTo: this.route});
   }

   vehicleEdit() {
    this.router.navigate(['details/2'], {relativeTo: this.route});
   }
}
