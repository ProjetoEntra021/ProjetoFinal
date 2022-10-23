import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { RentalService } from '../service/rental.service';
import { HeaderDashDTO } from '../shared/model/dto/headerDashDTO';

@Component({
  selector: 'app-header-dashboard',
  templateUrl: './header-dashboard.component.html',
  styleUrls: ['./header-dashboard.component.scss']
})
export class HeaderDashboardComponent implements OnInit {

  public headerDashDTO$?: Observable<HeaderDashDTO>;

  constructor(
    public rentalService: RentalService
  ) { }

  ngOnInit(): void {
    this.headerDashDTO$ = this.rentalService.getHeaderData();
  }

}
