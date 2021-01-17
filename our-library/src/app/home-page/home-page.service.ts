import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {BookComponent} from "../book/book.component";

@Injectable({
  providedIn: 'root'
})
export class HomePageService {
  private usersUrl: string;

  constructor(private http: HttpClient) {
    this.usersUrl = 'http://localhost:4200';
  }

  getSuggestedBooks(){
    return this.http.get(this.usersUrl, {responseType: 'text'});
  }


  getLatestBookByGenre(){
    return this.http.get(this.usersUrl, {responseType: 'text'});
  }

  getLatestBooks(){
    return this.http.get(this.usersUrl, {responseType: 'text'});
  }

}
