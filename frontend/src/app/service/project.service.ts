import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Globals } from '../global/globals';
import { Observable } from 'rxjs';
import { ProjectTime } from '../dtos/projectTime';
import { Project } from '../dtos/project';

@Injectable({
  providedIn: 'root'
})
export class ProjectService {

  constructor(private httpClient: HttpClient, private globals: Globals) { }

  private projectBaseUri: string = this.globals.backendUri + '/project';

  getProjects(): Observable<Project[]>{
    console.log('Get all projects');
    return this.httpClient.get<Project[]>(this.projectBaseUri);
  }

  getProjectsByFilter(projectNr: number): Observable<Project[]>{
    console.log('Get Project with number: '+projectNr);
    return this.httpClient.get<Project[]>(this.projectBaseUri + '/getAll'+ '?projectNr='+projectNr);
  }

  addProject(project: Project): Observable<Project>{
    console.log('Add Project');
    return this.httpClient.post<Project>(this.projectBaseUri, project);
  }

} 
