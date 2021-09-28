import {Component, OnInit} from '@angular/core';
import {Kategorie} from "./model/Kategorie";
import {Router} from "@angular/router";
import {TokenService} from "./services/token.service";

@Component({
  selector: 'app-root',
  templateUrl: 'app.component.html',
  styleUrls: ['app.component.scss'],
})
export class AppComponent implements OnInit {
  public appPages = [
    {title: 'Zeiten', url: '/entities', icon: 'alarm'},
    {title: 'Orten', url: '/places', icon: 'pin'},
    {title: 'Kategorien', url: '/categories', icon: 'albums'},
    {title: 'Administrator', url: '/administrator', icon: 'body'},
    {title: 'Einstellungen', url: '/settings', icon: 'settings'},
  ];
  public kategorie = Kategorie;

  constructor(public router: Router, public tokenService: TokenService) {
  }

  ngOnInit(): void {
  }

  public filters(): Array<string> {
    const keys = Object.keys(Kategorie);
    return keys;
  }

  signOut(): void {
    this.tokenService.deleteTokenWithKey('token');
    this.router.navigate(['login']);
  }
}
