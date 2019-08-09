import { Injectable } from '@angular/core';
import {Globals} from '../global/globals';
import {HttpClient} from '@angular/common/http';
import {Day} from '../dtos/day';
import {DayFilter} from '../dtos/dayFilter';
import {Observable} from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class MainService {

  private dayBaseUri: string = this.globals.backendUri + '/day';

  constructor(private httpClient: HttpClient, private globals: Globals) {
  }

  addDay(day: Day) {
    console.log('Add day');
    return this.httpClient.post(this.dayBaseUri, day);
  }

  getDay(dayfilter: DayFilter): Observable<Day[]>{
    console.log('Get day');
    return this.httpClient.post<Day[]>(this.dayBaseUri + '/getAll', dayfilter);
  }

}
