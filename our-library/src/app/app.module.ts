import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { NavbarModule } from "./navbar/navbar.module";
import { FooterModule } from "./footer/footer.module";
import { HomePageModule } from "./home-page/home-page.module";
import { BookModule } from "./book/book.module";
import { RouterModule } from "@angular/router";
import { AppRoutingModule } from './app-routing.module';

@NgModule({
  declarations: [
    AppComponent,
  ],
  imports: [
    BrowserModule,
    NavbarModule,
    FooterModule,
    HomePageModule,
    BookModule,
    RouterModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [ AppComponent ]
})
export class AppModule { }
