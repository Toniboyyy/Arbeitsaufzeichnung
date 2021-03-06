import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MainComponent } from './container/main/main.component';
import { FooterComponent } from './container/footer/footer.component';
import { HeaderComponent } from './container/header/header.component';
import { ProjectComponent } from './container/project/project.component';
import {Globals} from './global/globals';
import {httpInterceptorProviders} from './interceptors';
import { LoginComponent } from './container/login/login.component';
import { UserComponent } from './container/user/user.component';
import { CreateProjectComponent } from './container/create-project/create-project.component';

@NgModule({
  declarations: [
    AppComponent,
    MainComponent,
    FooterComponent,
    HeaderComponent,
    ProjectComponent,
    LoginComponent,
    UserComponent,
    CreateProjectComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    ReactiveFormsModule,
    FormsModule
  ],
  providers: [Globals, httpInterceptorProviders],
  bootstrap: [AppComponent]
})
export class AppModule { }
