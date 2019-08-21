import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { MainService } from 'src/app/service/main.service';
import { ProjectService } from 'src/app/service/project.service';
import { switchMap } from 'rxjs/operators';
import { ProjectTime } from 'src/app/dtos/projectTime';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ProjectTimeService } from 'src/app/service/project-time.service';
import { Project } from 'src/app/dtos/project';
import { isUndefined, isNullOrUndefined } from 'util';
import { Day } from 'src/app/dtos/day';
import { formatDate } from '@angular/common';

@Component({
  selector: 'app-project',
  templateUrl: './project.component.html',
  styleUrls: ['./project.component.scss']
})
export class ProjectComponent implements OnInit {

  dayId: number;
  day: Day;

  projectTimes: ProjectTime[];
  project: Project[];

  error: boolean;
  errorMessage: string;

  projectForm: FormGroup;
  projectNrForm: FormGroup;

  totalTime: number
  selectedProject: Project;

  submitted: boolean = false;
  allocatedTime: number; 

  constructor(private route: ActivatedRoute, private projectService: ProjectService, private formBuilder: FormBuilder, private projectTimeService: ProjectTimeService, private dayService: MainService) { }

  ngOnInit() {
    this.projectForm = this.formBuilder.group({
      start: ['', [Validators.required]],
      finish: ['', [Validators.required]]
    });

    this.projectNrForm = this.formBuilder.group({
      projectNr: ['', [Validators.required]]
    });

    this.loadDay();
    this.loadProjectTimes();
    this.loadProjects();
    
  }

  loadDay(){
    this.route.paramMap.pipe(switchMap(params => {
      this.dayId = parseInt(params.get('id'),0);
      return this.dayService.getDayById(parseInt(params.get('id'),0));
      })).subscribe(
        (day: Day) => {
          this.day = day;
          this.setTimes();
        },
        error => this.defaultServiceErrorHandling(error));
  }

  setTimes(){
    const date: Date = this.parse(this.day.dates);
    const today: number = date.getDay();
    if(1 <= today && today <= 5){
      this.allocatedTime = 8.5;
    }else if(today == 6){
      this.allocatedTime = 5.75;
    }
  }

  parse(value: any): Date | null {
    if ((typeof value === 'string') && (value.indexOf('/') > -1)) {
      const str = value.split('/');

      const year = Number(str[2]);
      const month = Number(str[1]) - 1;
      const date = Number(str[0]);

      return new Date(year, month, date);
    } else if((typeof value === 'string') && value === '') {
      return new Date();
    }
    const timestamp = typeof value === 'number' ? value : Date.parse(value);
    return isNaN(timestamp) ? null : new Date(timestamp);
  }

  
  loadProjectTimes(){
      return this.projectTimeService.getProject(this.dayId).subscribe( 
        (project: ProjectTime[]) => {
          this.projectTimes = project;
          this.setTotalTime();
        }, 
        error => 
          this.defaultServiceErrorHandling(error));
  }

  loadProjects(){
    this.projectService.getProjects().subscribe(
      (project: Project[]) => {
        this.project = project;
      },
      error => {
        this.defaultServiceErrorHandling(error);
      }
    );
  }

  deleteProjectTime(id: number){
    this.projectTimeService.deleteProject(id).subscribe(      
      () => {
      this.loadProjectTimes();
    },
    error => {
      this.defaultServiceErrorHandling(error);
    });
  }

  getProjectsByProjektnr(){
    if(this.projectNrForm.valid){
        this.projectService.getProjectsByFilter(this.projectNrForm.controls.projectNr.value).subscribe(
        (project: Project[]) => {
          this.project = project;
        },
        error => {
          this.defaultServiceErrorHandling(error);
        });
    }else{
      console.log(this.projectNrForm.controls.projectNr.value);
      console.log('Invalid input');
    }

  }

  setTotalTime() {
    this.totalTime = 0;
    for(let index = 0; index < this.projectTimes.length; index++)
    this.totalTime += this.projectTimes[index].working_hours;
  }


    /**
   * Error flag will be deactivated, which clears the error message
   */
  vanishError() {
    this.error = false;
  }

  private defaultServiceErrorHandling(error: any) {
    console.log(error);
    this.error = true;
    if (error.error.message !== 'No message available') {
      this.errorMessage = error.error.message;
    } else {
      this.errorMessage = error.error.error;
    }
  }

  addProjectTime() {
    this.submitted = true;
    if (this.projectForm.valid) {
      const project: ProjectTime = new ProjectTime(null,
        this.projectForm.controls.start.value,
        this.projectForm.controls.finish.value, 
        null,new Project(this.selectedProject.id, null, null, null), new Day(this.dayId,null,null,null)
      );

    this.projectTimeService.addProject(project, this.dayId).subscribe(      
      () => {
      this.loadProjectTimes();
    },
    error => {
      this.defaultServiceErrorHandling(error);
    });
    this.clearForm();
  }
}

  selectProject(project: Project){
    this.selectedProject = project;
    console.log(this.selectedProject);
  }

  selectedProjectSet(): boolean {
    return (this.selectedProject === undefined);
  }

  private clearForm() {
    this.projectForm.reset();
    this.submitted = false;
  }


}
