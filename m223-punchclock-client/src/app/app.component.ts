import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import {TokenService} from "./services/token.service";
import {AuthService} from "./request/auth.service";

@Component({
  selector: 'app-root',
  templateUrl: 'app.component.html',
  styleUrls: ['app.component.scss'],
})
export class AppComponent implements OnInit {
  public appPages = [
    {title: 'Zeiten', url: '/entities', icon: 'alarm'},
    {title: 'Orte', url: '/places', icon: 'pin'},
    {title: 'Kategorien', url: '/categories', icon: 'albums'},
    {title: 'Administrator', url: '/administrator', icon: 'body'},
    {title: 'Einstellungen', url: '/settings', icon: 'settings'},
  ];

  constructor(public router: Router, public tokenService: TokenService, public authService: AuthService) {
  }


  ngOnInit(): void {
  }
}
