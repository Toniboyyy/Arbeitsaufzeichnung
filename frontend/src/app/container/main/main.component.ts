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
  filterForm: FormGroup;
  private days: Day[];
  totalTime: number;
  filterDate: DayFilter;


  constructor(private router: Router, private mainService: MainService, private formBuilder: FormBuilder) {
       this.dayForm = this.formBuilder.group({
        dates: ['', [Validators.required]],
        start: ['', [Validators.required]],
        finish: ['', [Validators.required]],
      });
      this.filterForm = this.formBuilder.group({
        dates: ['', [Validators.required]]
      });
  }

  ngOnInit() {
    this.filterDate = new DayFilter(this.formatDate(new Date()));
    this.loadCurrentDays();
  }

  loadCurrentDays(){
    this.mainService.getDay(this.filterDate).subscribe(
      (day: Day[]) => {
        this.days = day;
        this.setTotalTime()
      },
      error => {
        this.defaultServiceErrorHandling(error);
      }
    );
  }

  goToProject(){
    this.router.navigate(['/project']);
  }

  setTotalTime() {
    this.totalTime = 0;
    for(let index = 0; index < this.days.length; index++)
    this.totalTime += this.days[index].working_hours;
  }

  addDay(){
    this.submitted = true;
    if (this.dayForm.valid) {
      const day: Day = new Day(null,
        this.dayForm.controls.dates.value,
        this.dayForm.controls.start.value,
        this.dayForm.controls.finish.value,
        null
      );
      console.log(this.dayForm.controls.dates.value)
      this.createDay(day);
      this.clearForm();
      
    } else {
      console.log('Invalid input');
    }
  }

  deleteDay(day: Day){
    console.log(day.id);
    this.mainService.deleteDay(day.id).subscribe(
      () => {
        this.loadCurrentDays();
    },
    error => {
      this.defaultServiceErrorHandling(error);
    }
    );
  }

  filterMonths(){
    this.days = null;
    if (this.filterForm.valid) {
      this.filterDate = new DayFilter(this.filterForm.controls.dates.value+'-01');
      this.loadCurrentDays();
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

  formatDate(date: Date) {
    let month = '' + (date.getMonth() + 1);
    let day = '' + date.getDate();
    let year = date.getFullYear();

    if (month.length < 2) month = '0' + month;
    if (day.length < 2) day = '0' + day;

    return [year, month, day].join('-');
}


}
