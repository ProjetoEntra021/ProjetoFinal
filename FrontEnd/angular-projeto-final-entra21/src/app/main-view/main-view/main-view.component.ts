import { Component, OnInit, EventEmitter, Output } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-main-view',
  templateUrl: './main-view.component.html',
  styleUrls: ['./main-view.component.scss']
})
export class MainViewComponent implements OnInit {

  value = '';
  title: string = '';

  constructor(
    public router: Router,
    private route: ActivatedRoute) {
  }

  ngOnInit(): void {
  }
  clientRegistration() {
    this.router.navigate(['main/clients/registration']);
  }
  clientList() {
    this.router.navigate(['main/clients/list']);
  }
  vehicleList() {
    this.router.navigate(['main/vehicles/list']);
  }

  vehicleAdd() {
    this.router.navigate(['main/vehicles/add']);
  }
  categoryList() {
    this.router.navigate(['main/category'])
  }
  vehicles() {
    this.router.navigate(['vehicles', ''], { relativeTo: this.route })
  }

  homePage() {
    this.router.navigate(['/main'], { relativeTo: this.route })
  }

  setHeader() {
    let path = this.router.url.split('/');
    if (path.length < 3) {
      this.title = "PÁGINA INICIAL";
    } else {

      let answer = decodeURIComponent(path[2]);
      if (answer == "vehicles") {
        this.title = "MENU VEÍCULOS";
      }
      if (answer == "clients") {
        this.title = "MENU CLIENTES";
      }
      if (answer == "bookings") {
        this.title = "MENU RESERVAS"
      }
      if (answer == "rentals") {
        this.title = "MENU LOCAÇÕES"
      }
    }
  }

  logout() {
    sessionStorage.removeItem('token');
    this.router.navigate(['/home']);
  }
}
