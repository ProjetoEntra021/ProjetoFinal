import { MatTableDataSource } from '@angular/material/table';
import { Category } from 'src/app/shared/model/category';
import { MatSort, Sort } from '@angular/material/sort';
import { LiveAnnouncer } from '@angular/cdk/a11y';
import { Component, OnInit, ViewChild, AfterViewInit } from '@angular/core';
import { CategoryService } from '../../service/category.service';
import { Router, ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';


@Component({
  selector: 'app-category-list',
  templateUrl: './category-list.component.html',
  styleUrls: ['./category-list.component.scss']
})
export class CategoryListComponent implements OnInit {

  readonly  displayedColumns: string[] = ['name', 'dayPrice', 'weekPrice', 'detalhe'];

  dataSource!: MatTableDataSource<Category>;

  @ViewChild("sort") sort: MatSort = new MatSort();

  constructor(
    private categoryService : CategoryService,
    private router: Router,
    private route: ActivatedRoute,
  ) {
    this.categoryService.list().subscribe(dados => this.dataSource = new MatTableDataSource<Category>(dados));
  }

  ngOnInit(): void {

    categoryService: Observable <Category[]>

  }
  details(id: number) {
    console.log("clicked")
    this.router.navigate(['details/' + id], { relativeTo: this.route.parent })

  }
  edit(id: number) {
    console.log("clicked")
    this.router.navigate(['update/' + id], { relativeTo: this.route.parent })
  }

}
