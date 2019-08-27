import { Component, OnInit } from '@angular/core';
import { ProjectService } from 'src/app/service/project.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Project } from 'src/app/dtos/project';

@Component({
  selector: 'app-create-project',
  templateUrl: './create-project.component.html',
  styleUrls: ['./create-project.component.scss']
})
export class CreateProjectComponent implements OnInit {

  projectForm: FormGroup;

  error: boolean;
  errorMessage: string;

  submitted: boolean = false;

  project: Project;

  constructor(private projectService: ProjectService, private formBuilder: FormBuilder) { }

  ngOnInit() {
    this.projectForm = this.formBuilder.group({
      name: ['', [Validators.required]],
      projectnumber: ['', [Validators.required]],
      desc: ['', [Validators.required]]
    });
  }

  addProject(){
    this.submitted = true;
    if(this.projectForm.valid){
      const project: Project = new Project(null,
         this.projectForm.controls.projectnumber.value,
         this.projectForm.controls.name.value,
         this.projectForm.controls.desc.value);
         this.projectService.addProject(project).subscribe(      
          (project: Project) => {
            this.project = project;
        },
        error => {
          this.defaultServiceErrorHandling(error);
        });
        this.clearForm();
    }else{
      console.log('Invalid Input');
    }
  }

  private clearForm() {
    this.submitted = false;
    this.projectForm.reset();
    
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

  vanishProject() {
    this.project = undefined;
  }

}
