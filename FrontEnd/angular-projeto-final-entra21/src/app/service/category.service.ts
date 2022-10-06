import { tap, first } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Category } from '../shared/model/category';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {
  private readonly API = 'api/categories/';

  constructor(private httpClient: HttpClient) { }

  list() {
    return this.httpClient.get<Category[]>(this.API)
    .pipe(tap(data => console.log(data)),
      first());
    }
}
