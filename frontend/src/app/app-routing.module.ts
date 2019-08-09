import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { MainComponent } from './container/main/main.component';
import { ProjectComponent } from './container/project/project.component';
import { LoginComponent } from './container/login/login.component';
import {AuthGuard} from './Guard/auth.guard';


const routes: Routes = [
{ path: 'day',  canActivate: [AuthGuard], component: MainComponent },
{ path: 'project', canActivate: [AuthGuard], component: ProjectComponent },
{ path: '', component: LoginComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
