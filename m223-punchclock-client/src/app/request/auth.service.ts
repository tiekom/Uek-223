import {Injectable} from '@angular/core';
import {Router} from "@angular/router";
import {HttpClient} from "@angular/common/http";
import {FormGroup} from "@angular/forms";

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
      () => {
        this.login(registerData);
      },
      error => {
        console.log(error)
      }
    );
  }

  login(loginData: FormGroup): void {
    this.http.post<any>(this.url + 'login', loginData.value, {observe: 'response'})
      .subscribe((res) => {
        window.localStorage.setItem('token', res.headers.get("Authorization"));
        this.router.navigate(['entities']);
      });
  }
}
