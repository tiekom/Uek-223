import { Injectable } from '@angular/core';
import {Router} from "@angular/router";
import {HttpClient} from "@angular/common/http";
import {FormGroup} from "@angular/forms";
import {Observable} from "rxjs";
import {Entry} from "../model/Entry";

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  url: string;
  constructor(private router: Router, private http: HttpClient) {
    this.url = "http://localhost:8081/"
  }
  register(registerData: FormGroup): void {
    this.http.post(this.url + 'users/sign-up', registerData.value).subscribe(
      response => {
        console.log(response)},
      error => {console.log(error)}
    );
  }
  login(loginData:FormGroup): void {
    this.http.post(this.url + 'login', loginData).subscribe(
      response => {
        console.log(response)},
      error => {console.log(error)}
    );
  }
}
