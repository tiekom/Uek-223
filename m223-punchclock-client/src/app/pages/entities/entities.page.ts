import {Component, Injectable, OnInit} from '@angular/core';
import {Entry} from "../../model/Entry";
import {ActivatedRoute} from "@angular/router";
import {EntryService} from "../../request/entry.service";
import {SnackbarService} from "../../services/snackbar.service";

@Component({
  selector: 'app-entities',
  templateUrl: './entities.page.html',
  styleUrls: ['./entities.page.scss'],
})

export class EntitiesPage implements OnInit {
  public folder: string;
  public entries: Array<Entry>;
  public editing: boolean;

  constructor(private activatedRoute: ActivatedRoute, private entryService: EntryService, private snackbarService: SnackbarService) {
    this.editing = false;
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
        this.snackbarService.presentToast("😬 Zeiten können nicht geladen werden", "danger")
      }
    )
  }

  activateEditing(): void{
    this.editing = !this.editing;
  }

}

