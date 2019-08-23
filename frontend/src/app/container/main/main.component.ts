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
  editForm: FormGroup;

  filterDate: DayFilter;

  private days: Day[];
  totalTime: number;

  selectedDay: Day;

  allocatedMonthTime: number;


  constructor(private router: Router, private mainService: MainService, private formBuilder: FormBuilder) {
       this.dayForm = this.formBuilder.group({
        dates: ['', [Validators.required]]
      });
      this.filterForm = this.formBuilder.group({
        dates: ['', [Validators.required]]
      });
      this.editForm = this.formBuilder.group({
        dates: ['', [Validators.required]]
      });
  }

  ngOnInit() {
    this.filterDate = new DayFilter(this.formatDate(new Date()));
    this.loadCurrentDays();
  }



  loadCurrentDays(){
    this.loadMonthTime();
    this.mainService.getDay(this.filterDate).subscribe(
      (day: Day[]) => {
        this.days = day;
        this.setTotalTime();
        this.loadMonthTime();
      },
      error => {
        this.defaultServiceErrorHandling(error);
      }
    );
  }

  loadMonthTime(){
    const date: Date = this.parse(this.filterDate.dates);
    var d = new Date(date.getFullYear(),date.getMonth(), 0).getDate();
    this.allocatedMonthTime = 0;
    
    for(var count = 0; count < d; count++){
      this.allocatedMonthTime += this.isWeekday(new Date(date.getFullYear(),date.getMonth(), count+1))
    }
  }

  isWeekday(day: Date): number{
    if(day.getDay() == 0 || day.getDay() == 6){
      return 0;
    }else if(day.getDay() == 5){
      return 5.75;
    }
    return 8.5;
  }

  goToProject(){
    this.router.navigate(['/project']);
  }

  addDay(){
    this.submitted = true;
    if (this.dayForm.valid) {
      const day: Day = new Day(null,
        this.dayForm.controls.dates.value,
        null, null
      );
      console.log(this.dayForm.controls.dates.value)
      this.createDay(day);
      this.clearForm();
      
    } else {
      console.log('Invalid input');
    }
  }

  deleteDay(day: Day){
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
    let day = '01';
    let year = date.getFullYear();

    if (month.length < 2) month = '0' + month;

    return [year, month, day].join('-');
}

  setSelected(day: Day){
    this.selectedDay = day;
  }

  submitDayToEdit(day: Day){
    this.submitted = true;
    console.log(this.editForm.controls.dates.value);
    if (this.dayForm.valid) {
      const newDay: Day = new Day(day.id,
        this.editForm.controls.dates.value,
        null, null
      );
      this.editDay(newDay);
      this.clearForm();
    } else {
      console.log('Invalid input');
    }
  }

  editDay(day: Day){
    this.mainService.editDay(day).subscribe(
      () => {
          this.loadCurrentDays();
      },
      error => {
        this.defaultServiceErrorHandling(error);
      }
    );
  }

  setTotalTime(){
    this.totalTime = 0;
    for(let i = 0; i < this.days.length; i++){
      this.totalTime += this.days[i].project_hours;
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


}
