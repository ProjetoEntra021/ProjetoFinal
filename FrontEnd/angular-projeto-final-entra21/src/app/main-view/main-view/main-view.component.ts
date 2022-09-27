import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-main-view',
  templateUrl: './main-view.component.html',
  styleUrls: ['./main-view.component.scss']
})
export class MainViewComponent implements OnInit {

  value = '';

  constructor(
    private router: Router,
    private route: ActivatedRoute) {
  }

  ngOnInit(): void {
  }

  vehicles() {
    this.router.navigate(['vehicles'], { relativeTo: this.route })
  }

  homePage() {
    this.router.navigate([''], { relativeTo: this.route })
  }
}
