import {Injectable} from '@angular/core';
import {Observable} from "rxjs";
import {Entry} from "../model/Entry";
import {HttpClient} from "@angular/common/http";
import {AuthService} from "./auth.service";
import {environment} from "../../environments/environment";
import {Place} from "../model/Place";
import {FormGroup} from "@angular/forms";

@Injectable({
  providedIn: 'root'
})
export class PlaceService {
  url: string;

  constructor(private http: HttpClient, private authService: AuthService) {
    this.url = environment.backendUrl + "/places"
  }

  create(formData: FormGroup): void {
    console.log("ok")
    this.http.post(this.url, formData.value, {headers: this.authService.getHeader()});
  }

  deleteById(id: number): Observable<any> {
    return this.http.delete(this.url + "/" + id, {headers: this.authService.getHeader()});
  }

  getAll(): Observable<Array<Place>> {
    return this.http.get<Array<Place>>(this.url, {headers: this.authService.getHeader()});
  }

  update(id: number, place: Place): Observable<any> {
    return this.http.put(this.url + "/" + id, {headers: this.authService.getHeader(), place});
  }
}
