import {Injectable} from '@angular/core';
import {Router} from "@angular/router";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {FormGroup} from "@angular/forms";
import {TokenService} from "../services/token.service";
import {SnackbarService} from "../services/snackbar.service";

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  url: string;
  headers: HttpHeaders;

  constructor(
    private router: Router,
    private http: HttpClient,
    private snackbarService: SnackbarService,
    private tokenService: TokenService) {
    this.url = "http://localhost:8081/"
  }

  register(registerData: FormGroup): void {
    this.http.post(this.url + 'users/sign-up', registerData.value).subscribe(
      () => {
        this.snackbarService.presentToast("😃 Registrierung Erfolgreich", 'success').then(() => this.login(registerData));
      },
      error => {
        this.snackbarService.presentToast("😕 Registrierung Fehlgeschlagen", 'danger');
      }
    );
  }

  login(loginData: FormGroup): void {
    this.http.post<any>(this.url + 'login', loginData.value, {observe: 'response'})
      .subscribe((res) => {
        this.tokenService.saveToken('token', res.headers.get("Authorization"));
        this.router.navigate(['entities']).then(() => this.snackbarService.presentToast("😉 Erfolgreiche Anmeldung", 'success'));
      }, () => {
          this.snackbarService.presentToast("🤔 Benutzername oder Passwort Falsch", 'primary')
      });
  }

  signOut(){
    this.tokenService.deleteTokenWithKey('token');
    this.router.navigate(['login']).then(() => this.snackbarService.presentToast("🖐️ Erfolgreiche Abgemeldung", 'primary'));;
  }

  getHeader(): HttpHeaders {
    this.headers = new HttpHeaders({
      Authorization:
        'Bearer ' + this.tokenService.getToken('token'),
    });
    return this.headers;
  }
}
