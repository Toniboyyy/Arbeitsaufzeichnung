import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Globals } from '../global/globals';
import { Observable } from 'rxjs';
import { ProjectTime } from '../dtos/projectTime';

@Injectable({
  providedIn: 'root'
})
export class ProjectTimeService {

  private projectBaseUri: string = this.globals.backendUri + '/projectTime';

  constructor(private httpClient: HttpClient, private globals: Globals) { }

  addProject(project: ProjectTime, id: number): Observable<ProjectTime>{
    console.log('Add projectTime');
    return this.httpClient.post<ProjectTime>(this.projectBaseUri, project);
  }

  changeProject(project: ProjectTime): Observable<ProjectTime>{
    console.log('Change projectTime');
    return this.httpClient.put<ProjectTime>(this.projectBaseUri, project);
  }

  deleteProject(id: number){
    console.log('Delete projectTime');
    return this.httpClient.delete(this.projectBaseUri+'?id='+id);
  }

  getProject(id: number){
    console.log('Get projectTime by Day');
    return this.httpClient.get(this.projectBaseUri+'?dayId='+id);
  }
}
