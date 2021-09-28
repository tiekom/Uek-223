import {Injectable} from '@angular/core';
import {Kategorie} from "../model/Kategorie";
import {EntryInterface} from "../interface/EntryInterface";
import {HttpClient} from "@angular/common/http";
import {environment} from "../../environments/environment";
import {Entry} from "../model/Entry";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class EntryService implements EntryInterface {

  url: string;

  entries: Observable<Array<Entry>>;

  constructor(private http: HttpClient) {
    this.url = environment.backendUrl + "/entries"
  }

  create(entry: Entry): Observable<any> {
    return this.http.post(this.url, entry);
  }

  deleteById(id: number): Observable<any> {
    return this.http.delete(this.url + "/" + id);
  }

  getAll(): Observable<Array<Entry>> {
    return this.http.get<Array<Entry>>(this.url);
  }

  getById(id: number): boolean {
    return false;
  }

  update(id: number, entry: Entry): Observable<any> {
    return this.http.put(this.url + "/" + id, entry);
  }


}
