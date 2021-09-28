import {Injectable} from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class TokenService {

  constructor() {
  }

  saveToken(key: string, value: string): void {
    window.localStorage.setItem(key, value);
  }

  checkIfTokenExists(key: string): boolean {
    return !window.localStorage.getItem(key);
  }

  deleteTokenWithKey(key: string): void {
    window.localStorage.removeItem(key);
  }

  getToken(key: string): string {
    return window.localStorage.getItem(key);
  }
}
