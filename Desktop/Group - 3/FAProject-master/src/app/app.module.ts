import { BrowserModule } from "@angular/platform-browser";
import { NgModule } from "@angular/core";
import { CarouselModule } from "ngx-bootstrap/carousel";
import { RouterModule, Routes } from "../../node_modules/@angular/router";
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { MDBBootstrapModule } from 'angular-bootstrap-md';

import { AppRoutingModule } from "./app-routing.module";
import { AppComponent } from "./app.component";
import { SignupComponent } from "./component/signup/signup.component";
import { LoginComponent } from "./component/login/login.component";
import { EmployeeComponent } from './component/employee/employee.component';
import { SkillsetComponent } from './component/skillset/skillset.component';
import { ManagerComponent } from './component/manager/manager.component';
import { EmpdashboardComponent } from './component/empdashboard/empdashboard.component';
import { ManagerAnalysisComponent } from './manager-analysis/manager-analysis.component';
import { EmployeeReportsComponent } from './employee-reports/employee-reports.component';
import { SkillReportsComponent } from './skill-reports/skill-reports.component';

const routes: Routes = [
  { path: 'signup', component: SignupComponent },
  { path: 'login', component: LoginComponent },
  { path: 'employee', component: EmployeeComponent },
  { path: 'skillset', component:SkillsetComponent },
  { path: 'empdashboard', component: EmpdashboardComponent },
  { path: 'manager', component:ManagerComponent },
  { path: 'manager-analysis', component:ManagerAnalysisComponent },
  { path: 'empName/:employeeId', component : EmployeeReportsComponent},
  { path: 'skillName/:field/:value', component : SkillReportsComponent},
  { path: 'skillName', component : SkillReportsComponent}

];
@NgModule({
  declarations: [
    AppComponent,
    SignupComponent,
    LoginComponent,
    EmployeeComponent,
    SkillsetComponent,
    ManagerComponent,
    EmpdashboardComponent,
    ManagerAnalysisComponent,
    EmployeeReportsComponent,
    SkillReportsComponent
  ],
  imports: [
    CarouselModule.forRoot(),
    BrowserModule,
    AppRoutingModule,
    HttpModule,
    FormsModule,
    MDBBootstrapModule,
    RouterModule.forRoot(routes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {}
