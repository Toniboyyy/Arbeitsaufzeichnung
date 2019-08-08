import { Injectable } from '@angular/core';
import {Globals} from '../global/globals';
import {HttpClient} from '@angular/common/http';
import {Day} from '../dtos/day';


@Injectable({
  providedIn: 'root'
})
export class MainService {

  private messageBaseUri: string = this.globals.backendUri + '/day';

  constructor(private httpClient: HttpClient, private globals: Globals) {
  }

  addDay(day: Day) {
    console.log('Add day');
    return this.httpClient.post(this.messageBaseUri, day);
  }

}
