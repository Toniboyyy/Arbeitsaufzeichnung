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

@Component({
  selector: 'app-project',
  templateUrl: './project.component.html',
  styleUrls: ['./project.component.scss']
})
export class ProjectComponent implements OnInit {



  projectTimes: ProjectTime[];
  project: Project[];

  error: boolean;
  errorMessage: string;

  projectForm: FormGroup;

  totalTime: number
  selectedProject: Project = undefined;

  constructor(private route: ActivatedRoute, private projectService: ProjectService, private formBuilder: FormBuilder, private projectTimeService: ProjectTimeService, private dayService: MainService) { }

  ngOnInit() {
    this.projectForm = this.formBuilder.group({
      start: ['', [Validators.required]],
      finish: ['', [Validators.required]],
      projectId: ['', [Validators.required]]
    });

    this
    this.loadProjectTimes();
    this.loadProjects();
  }

  loadDay(){
    this.route.paramMap.pipe(switchMap(params => {
      return this.dayService.getDayById(parseInt(params.get('id'),0));
      })).subscribe( (project: ProjectTime[]) => {this.projectTimes = project; this.setTotalTime();}, error => this.defaultServiceErrorHandling(error));
  }

  
  loadProjectTimes(){
    this.route.paramMap.pipe(switchMap(params => {
      return this.projectTimeService.getProject(parseInt(params.get('id'),0));
      })).subscribe( (project: ProjectTime[]) => {this.projectTimes = project; this.setTotalTime();}, error => this.defaultServiceErrorHandling(error));
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
    if (this.projectForm.valid) {
      const project: ProjectTime = new ProjectTime(null,
        this.projectForm.controls.start.value,
        this.projectForm.controls.finish.value, 
        null,null,null
      );

    this.projectTimeService.addProject(project, 3153).subscribe(      
      () => {
      this.loadCurrentDays();
    },
    error => {
      this.defaultServiceErrorHandling(error);
    });
  }
}

  selectProject(project: Project){
    this.selectedProject = project;
    console.log(this.selectedProject);
  }

  selectedProjectSet(): boolean {
    return !(this.selectProject === undefined);
  }
}
