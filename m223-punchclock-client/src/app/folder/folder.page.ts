import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import {Kategorie} from "../model/Kategorie";
import {EntryService} from "../request/entry.service";
import {Entry} from "../model/Entry";

@Component({
  selector: 'app-folder',
  templateUrl: './folder.page.html',
  styleUrls: ['./folder.page.scss'],
})
export class FolderPage implements OnInit {
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
