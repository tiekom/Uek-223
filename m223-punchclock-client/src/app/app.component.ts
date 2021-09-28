import { Component } from '@angular/core';
import {Kategorie} from "./model/Kategorie";
import {EntryService} from "./request/entry.service";
import {Entry} from "./model/Entry";
@Component({
  selector: 'app-root',
  templateUrl: 'app.component.html',
  styleUrls: ['app.component.scss'],
})
export class AppComponent {
  public appPages = [
    { title: 'Punchclock', url: '/folder/punchclock', icon: 'alarm' },
  ];
  public kategorie = Kategorie;
  constructor() {
  }
  public filters(): Array<string> {
    const keys = Object.keys(Kategorie);
    return keys;
  }
}
