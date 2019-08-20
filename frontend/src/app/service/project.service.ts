import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Globals } from '../global/globals';
import { Observable } from 'rxjs';
import { ProjectTime } from '../dtos/projectTime';

@Injectable({
  providedIn: 'root'
})
export class ProjectService {

  constructor(private httpClient: HttpClient, private globals: Globals) { }

  private projectBaseUri: string = this.globals.backendUri + '/project';

  getProjects(){
    console.log('Get all projects');
    return this.httpClient.get(this.projectBaseUri);
  }

  getProjectsByFilter(projectNr: number){
    console.log('Get Project with number: '+projectNr);
    return this.httpClient.get(this.projectBaseUri + '/getAll'+ '?projectNr='+projectNr);
  }

} 
