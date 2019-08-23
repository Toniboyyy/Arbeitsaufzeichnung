import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import { User } from 'src/app/dtos/user';
import { UserService } from 'src/app/service/user.service';
import { isNullOrUndefined } from 'util';


@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.scss']
})
export class UserComponent implements OnInit {

  error: boolean = false;
  errorMessage: string = '';
  userForm:FormGroup;
  submitted: boolean = false;
  user: User;

  constructor(private formBuilder: FormBuilder, private userService: UserService) {
    this.userForm = this.formBuilder.group({
      username: ['', [Validators.required]],
      firstname: ['', [Validators.required]],
      lastname: ['', [Validators.required]],
      password: ['', [Validators.required, Validators.minLength(8)]],
      second_pw: ['', [Validators.required]]
    });
   }

  ngOnInit() {
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

  private clearForm() {
    this.userForm.reset();
    this.submitted = false;
  }

  addUser(){
    this.submitted = true;
    if(this.userForm.valid){
      const user = new User(null, 
        this.userForm.controls.username.value,
        this.userForm.controls.firstname.value,
        this.userForm.controls.lastname.value,
        this.userForm.controls.password.value);
        this.userService.createUser(user).subscribe( 
          (user: User) => {
            this.user = user;console.log(this.user);
          }, 
          error => {
            this.defaultServiceErrorHandling(error);
          });
            this.clearForm();
    }else{
      console.log('Invalid Input');
    }
    
  }

  passwordEqual(): boolean{
    return this.userForm.controls.password.value === this.userForm.controls.second_pw.value;
  }

  userSet(): boolean{
    return !isNullOrUndefined(this.user);
    }
}