import {Component, OnInit} from '@angular/core';
import {EIcon} from "../../model/EIcon";
import {PlaceService} from "../../request/place.service";
import {Entry} from "../../model/Entry";
import {Place} from "../../model/Place";
import {SnackbarService} from "../../services/snackbar.service";
import {AuthService} from "../../request/auth.service";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-places',
  templateUrl: './places.page.html',
  styleUrls: ['./places.page.scss'],
})
export class PlacesPage implements OnInit {

  public editing: boolean;

  public places: Array<Place>;

  public eIcon = EIcon;

  public newPlace: FormGroup;

  constructor(private placeService: PlaceService, private snackbarService: SnackbarService, private authService: AuthService, private fb: FormBuilder) {
    this.editing = false;
  }

  ngOnInit() {
    this.newPlace = this.fb.group({
      name: ['', Validators.required],
      iIcon: ['', Validators.required],
    });
  }

  onSubmitPlace(): void {
    this.placeService.create(this.newPlace);
  }

  deleteEntry(id: number): void {
    this.placeService.deleteById(id);
  }

  loadEntries(): void {
    this.placeService.getAll().subscribe(
      places => {
        this.places = places;
      },
      error => {
        this.snackbarService.presentToast("😬 Orte können nicht geladen werden", "danger")
      }
    )
  }

  toggleEditing(): void {
    this.editing = !this.editing;
  }

}
