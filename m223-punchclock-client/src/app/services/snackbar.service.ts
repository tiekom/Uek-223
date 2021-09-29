import {Injectable} from '@angular/core';
import {ToastController} from "@ionic/angular";
import {PredefinedColors} from "@ionic/core";

@Injectable({
  providedIn: 'root'
})
export class SnackbarService {

  constructor(public toastController: ToastController) {
  }

  public async presentToast(message: string, color: PredefinedColors) {
    const toast = await this.toastController.create({
      message,
      duration: 5000,
      color
    });
    toast.present();
  }
}
