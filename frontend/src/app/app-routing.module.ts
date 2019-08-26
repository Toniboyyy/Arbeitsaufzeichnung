import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { MainComponent } from './container/main/main.component';
import { ProjectComponent } from './container/project/project.component';
import { LoginComponent } from './container/login/login.component';
import {AuthGuard} from './Guard/auth.guard';
import { UserComponent } from './container/user/user.component';
import { CreateProjectComponent } from './container/create-project/create-project.component';
import { AdminGuard } from './Guard/admin.guard';


const routes: Routes = [
{ path: 'day',canActivate: [AuthGuard],  component: MainComponent },
{ path: 'project/:id', canActivate: [AuthGuard], component: ProjectComponent },
{ path: '', component: LoginComponent},
{ path: 'user', canActivate: [AuthGuard], component: UserComponent},
{ path: 'createProject', canActivate: [AuthGuard], component: CreateProjectComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
