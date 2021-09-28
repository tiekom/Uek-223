import {Component, OnInit} from '@angular/core';
import {Kategorie} from "./model/Kategorie";
import {EntryService} from "./request/entry.service";
import {Entry} from "./model/Entry";
import {Router} from "@angular/router";
@Component({
  selector: 'app-root',
  templateUrl: 'app.component.html',
  styleUrls: ['app.component.scss'],
})
export class AppComponent implements OnInit{
  public appPages = [
    { title: 'Punchclock', url: '/folder/punchclock', icon: 'alarm' },
  ];
  public kategorie = Kategorie;
  constructor(public router:Router) {
  }

  ngOnInit(): void {
    console.log(this.router.url);
    }
  public filters(): Array<string> {
    const keys = Object.keys(Kategorie);
    return keys;
  }
}
