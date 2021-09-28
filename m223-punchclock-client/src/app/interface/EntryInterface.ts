import {Kategorie} from "../model/Kategorie";
import {Entry} from "../model/Entry";
import {Observable} from "rxjs";

export interface EntryInterface {
  getAll(): Observable<Array<Entry>>;

  getById(id: number): boolean;

  create(entry: Entry): Observable<any>;

  deleteById(id: number): Observable<any>;

  update(id: number, entry: Entry): Observable<any>;
}
