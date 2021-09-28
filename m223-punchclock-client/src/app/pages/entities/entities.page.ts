import { Component, OnInit } from '@angular/core';
import {Entry} from "../../model/Entry";
import {ActivatedRoute} from "@angular/router";
import {EntryService} from "../../request/entry.service";
import {Kategorie} from "../../model/Kategorie";

@Component({
  selector: 'app-entities',
  templateUrl: './entities.page.html',
  styleUrls: ['./entities.page.scss'],
})
export class EntitiesPage implements OnInit {
  public folder: string;
  public entries: Array<Entry>;

  constructor(private activatedRoute: ActivatedRoute, private entryService: EntryService) {
    this.loadEntries();
  }

  ngOnInit() {
    this.folder = this.activatedRoute.snapshot.paramMap.get('id');
  }

  deleteEntry(id: number): void{
    this.entryService.deleteById(id);
  }

  loadEntries(): void {
    this.entryService.getAll().subscribe(
      entries => {
        this.entries = entries;
      },
      error => {
        console.log(error)
      }
    )
  }

  public filters(): Array<string> {
    const keys = Object.keys(Kategorie);
    return keys;
  }

}

