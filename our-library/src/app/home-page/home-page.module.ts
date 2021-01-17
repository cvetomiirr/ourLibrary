import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HomePageComponent } from './home-page.component';
import {HttpClientModule} from "@angular/common/http";



@NgModule({
  declarations: [HomePageComponent],
  imports: [
    CommonModule,
    HttpClientModule
  ]
})
export class HomePageModule { }
