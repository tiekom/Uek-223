import {ERole} from "./ERole";

export class User {
  private _id: number;
  private _eRole: ERole;
  private _password: string;
  private _username: string;

  constructor(id: number, eRole: ERole, password: string, username: string) {
    this._id = id;
    this._eRole = eRole;
    this._password = password;
    this._username = username;
  }


  get id(): number {
    return this._id;
  }

  set id(value: number) {
    this._id = value;
  }

  get eRole(): ERole {
    return this._eRole;
  }

  set eRole(value: ERole) {
    this._eRole = value;
  }

  get password(): string {
    return this._password;
  }

  set password(value: string) {
    this._password = value;
  }

  get username(): string {
    return this._username;
  }

  set username(value: string) {
    this._username = value;
  }
}
