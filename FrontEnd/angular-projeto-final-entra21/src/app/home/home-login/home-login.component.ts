import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';
import { ResponseDTO } from '../../shared/model/dto/responseDTO';
import { UserDTO } from '../../shared/model/dto/userDTO';

@Component({
  selector: 'app-home-login',
  templateUrl: './home-login.component.html',
  styleUrls: ['./home-login.component.scss']
})
export class HomeLoginComponent implements OnInit {

  form = this.formBuilder.group({
    username: '',
    password: ''
  })
  constructor(
    private router: Router,
    private formBuilder: FormBuilder,
    private httpClient: HttpClient
  ) { }

  ngOnInit(): void {
  }

  login() {
    let user: UserDTO = {
      username: this.form.value.username!,
      password: this.form.value.password!
    };

    this.httpClient.post<ResponseDTO>("/api/login", user).subscribe((response) => {
      if (response) {
        sessionStorage.setItem('token', response.sessionId);
        this.router.navigate(['/main'])
      } else {
        alert("Authentication failed.")
      }

    });

  }

}
