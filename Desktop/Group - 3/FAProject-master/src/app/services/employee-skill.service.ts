import { Injectable } from '@angular/core';
import { Http, RequestOptions, Headers  } from '@angular/http';
import { Observable } from 'rxjs';
import { EmployeeSkill } from '../model/employee-skill';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class EmployeeSkillService {
  
  baseUrl: string;

  constructor(private http: Http) {
    this.baseUrl = "http://localhost:3030/employeeskills";
   }

   getBaseUrlById(employeeId : number): string {
    return this.baseUrl + "/" + employeeId;
  }

  getSearchUrl(field: string, value: string): string {
    return this.baseUrl + "/" + field + "/" + value;
  }

  getJsonContentTypeHeader(): RequestOptions {
    const headers = new Headers();
    headers.append('Content-Type', 'application/json');
    return new RequestOptions({ headers: headers });
  }

  getAllEmployeeSkills(): Observable<EmployeeSkill[]> {
    return this.http.get(this.baseUrl).pipe(
      map(data => data.json())
    );
  }

  /*searchEmployeeSkills(field: string, value: string): Observable<EmployeeSkill[]> {
    return this.http.get(this.getSearchUrl(field,value)).pipe(
      map(data => data.json())
    );
  }*/

 
  getEmployeeSkillsById(employeeId: number): Observable<EmployeeSkill[]> {
    return this.http.get(this.getBaseUrlById(employeeId)).pipe(
      map(data => data.json())
    );
  }

  searchPlans(field: string, value: string): Observable<EmployeeSkill[]> {
    return this.http.get(this.getSearchUrl(field,value)).pipe(
      map(data => data.json())
    );
  }

}
