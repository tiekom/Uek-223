import { NgModule } from '@angular/core';
import { PreloadAllModules, RouterModule, Routes } from '@angular/router';
import {UnauthorizedGuard} from "./guard/unauthorized.guard";
import {AuthGuard} from "./guard/auth.guard";

const routes: Routes = [
  {
    path: '',
    redirectTo: 'login',
    pathMatch: 'full'
  },
  {
    canActivate: [UnauthorizedGuard],
    path: 'login',
    loadChildren: () => import('./pages/login/login.module').then( m => m.LoginPageModule)
  },
  {
    canActivate: [UnauthorizedGuard],
    path: 'register',
    loadChildren: () => import('./pages/register/register.module').then( m => m.RegisterPageModule)
  },
  {
    canActivate: [AuthGuard],
    path: 'categories',
    loadChildren: () => import('./pages/categories/categories.module').then( m => m.CategoriesPageModule)
  },
  {
    canActivate: [AuthGuard],
    path: 'places',
    loadChildren: () => import('./pages/places/places.module').then( m => m.PlacesPageModule)
  },
  {
    canActivate: [AuthGuard],
    path: 'administrator',
    loadChildren: () => import('./pages/admin/admin.module').then( m => m.AdminPageModule)
  },
  {
    canActivate: [AuthGuard],
    path: 'entities',
    loadChildren: () => import('./pages/entities/entities.module').then( m => m.EntitiesPageModule)
  },
  {
    canActivate: [AuthGuard],
    path: 'settings',
    loadChildren: () => import('./pages/settings/settings.module').then( m => m.SettingsPageModule)
  }
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes, { preloadingStrategy: PreloadAllModules })
  ],
  exports: [RouterModule]
})
export class AppRoutingModule {}
