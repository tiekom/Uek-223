import {ERole} from "./ERole";
import {EIcon} from "./EIcon";

export class Category {
  private _id:number;
  private _applicationUserId: number;
  private _description: string;
  private _eIcon: EIcon;
  private _name: string;

  constructor(id: number, applicationUserId: number, description: string, eIcon: EIcon, name: string) {
    this._id = id;
    this._applicationUserId = applicationUserId;
    this._description = description;
    this._eIcon = eIcon;
    this._name = name;
  }


  get id(): number {
    return this._id;
  }

  set id(value: number) {
    this._id = value;
  }

  get applicationUserId(): number {
    return this._applicationUserId;
  }

  set applicationUserId(value: number) {
    this._applicationUserId = value;
  }

  get description(): string {
    return this._description;
  }

  set description(value: string) {
    this._description = value;
  }

  get eIcon(): EIcon {
    return this._eIcon;
  }

  set eIcon(value: EIcon) {
    this._eIcon = value;
  }

  get name(): string {
    return this._name;
  }

  set name(value: string) {
    this._name = value;
  }
}
