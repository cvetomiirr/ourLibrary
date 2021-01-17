import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import {HomePageComponent} from "./home-page/home-page.component";
import {NavbarComponent} from "./navbar/navbar.component";
import {FooterComponent} from "./footer/footer.component";
import {BookComponent} from "./book/book.component";

const routes: Routes = [
  {path:  "", pathMatch:  "full",redirectTo:  "home"},
  {path:  "navbar", component: NavbarComponent},
  {path: "home", component: HomePageComponent},
  {path: "footer", component: FooterComponent},
  {path: "book", component: BookComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
