import {Component, Injectable, OnInit} from '@angular/core';
import {Entry} from "../../model/Entry";
import {ActivatedRoute} from "@angular/router";
import {EntryService} from "../../request/entry.service";

@Component({
  selector: 'app-entities',
  templateUrl: './entities.page.html',
  styleUrls: ['./entities.page.scss'],
})

export class EntitiesPage implements OnInit {
  public folder: string;
  public entries: Array<Entry>;

  constructor(private activatedRoute: ActivatedRoute, private entryService: EntryService) {
  }

  ngOnInit() {
    this.folder = this.activatedRoute.snapshot.paramMap.get('id');
    this.loadEntries();
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

}

