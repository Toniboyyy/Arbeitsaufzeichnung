import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {MainService} from '../../service/main.service';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Day} from '../../dtos/day';
import {DayFilter} from '../../dtos/dayFilter';

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.scss']
})
export class MainComponent implements OnInit {

  error: boolean = false;
  errorMessage: string = '';
  submitted: boolean = false;
  dayForm: FormGroup;
  private days: Day[];


  constructor(private router: Router, private mainService: MainService, private formBuilder: FormBuilder) {
       this.dayForm = this.formBuilder.group({
      dates: ['', [Validators.required]],
      start: ['', [Validators.required]],
      finish: ['', [Validators.required]],
    });
  }

  ngOnInit() {
    this.loadCurrentDays();
  }

  loadCurrentDays(){
    var today: DayFilter = new DayFilter(new Date(2018, 8))
    this.mainService.getDay(today).subscribe(
      (day: Day[]) => {
        this.days = day;
      },
      error => {
        this.defaultServiceErrorHandling(error);
      }
    );
  }

  goToProject(){
    this.router.navigate(['/project']);
  }

  addDay(){
    this.submitted = true;
    if (this.dayForm.valid) {
      const day: Day = new Day(null,
        this.dayForm.controls.dates.value,
        this.dayForm.controls.start.value,
        this.dayForm.controls.finish.value
      );
      this.createDay(day);
      this.clearForm();
    } else {
      console.log('Invalid input');
    }
  }

  createDay(day: Day) {
    this.mainService.addDay(day).subscribe(
      () => {
          this.loadCurrentDays();
      },
      error => {
        this.defaultServiceErrorHandling(error);
      }
    );
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
    this.dayForm.reset();
    this.submitted = false;
  }


}
