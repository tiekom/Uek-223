import { Injectable } from '@angular/core';
import {Router} from "@angular/router";
import {Entry} from "../model/Entry";
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {FormGroup} from "@angular/forms";

@Injectable({
  providedIn: 'root'
})
export class UserService {
  url: string;
  constructor(private router: Router, private http: HttpClient) {
    this.url = "https://localhost:8081/"
  }
  register(registerData: FormGroup): Observable<any> {
    return this.http.post(this.url + '', registerData);
  }
  login(entry: Entry): Observable<any> {
    return this.http.post(this.url, entry);
  }
  check(entry: Entry): Observable<any> {
    return this.http.post(this.url, entry);
  }
}
