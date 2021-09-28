import {Kategorie} from "./Kategorie";

export class Entry {
  private _id: number;
  private _checkIn: Date;
  private _checkOut: Date;
  private _kategorie: Kategorie;

  constructor(id: number, checkIn: Date, checkOut: Date, kategorie: Kategorie) {
    this._id = id;
    this._checkIn = checkIn;
    this._checkOut = checkOut;
    this._kategorie = kategorie;
  }

  get id(): number {
    return this._id;
  }

  set id(value: number) {
    this._id = value;
  }

  get checkIn(): Date {
    return this._checkIn;
  }

  set checkIn(value: Date) {
    this._checkIn = value;
  }

  get checkOut(): Date {
    return this._checkOut;
  }

  set checkOut(value: Date) {
    this._checkOut = value;
  }

  get kategorie(): Kategorie {
    return this._kategorie;
  }

  set kategorie(value: Kategorie) {
    this._kategorie = value;
  }
}
