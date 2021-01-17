import { Component, OnInit } from '@angular/core';
import {HomePageModule} from "./home-page.module";
import {HomePageService} from "./home-page.service";

@Component({
  selector: 'home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})
export class HomePageComponent implements OnInit {

  service : HomePageService;

  suggestedBooks : any;

  latestBooks : any;

  findLatestBookByGenre : any;

  constructor(private homePageService: HomePageService) { }

  ngOnInit(): void {
    this.homePageService.getSuggestedBooks().subscribe(response => {this.suggestedBooks = response} );
    this.homePageService.getLatestBooks().subscribe(response => {this.latestBooks = response} );
    this.homePageService.getLatestBookByGenre().subscribe(response => {this.findLatestBookByGenre = response} )
  }

}
