import { Injectable } from '@angular/core';
import { Http, RequestOptions, Headers, Response  } from '@angular/http';
import { Observable } from 'rxjs';
import { Employee } from '../model/employee';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  baseUrl: string;

  constructor(private http: Http) {
    this.baseUrl = "http://localhost:2020/reports";
   }

   getBaseUrlById(employeeId: number): string {
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

  getAllEmployees(): Observable<Employee[]> {
    return this.http.get(this.baseUrl).pipe(
      map(data => data.json())
    );
  }

  searchEmployees(field: string, value: string): Observable<Employee[]> {
    return this.http.get(this.getSearchUrl(field,value)).pipe(
      map(data => data.json())
    );
  }

  getEmployeeById(employeeId: number): Observable<Employee> {
    return this.http.get(this.getBaseUrlById(employeeId)).pipe(
      map(data => data.json())
    );
  }

  /*deleteEmployeeById(pTitle: string): Observable<Response> {
    return this.http.delete(this.getBaseUrlById(pTitle));
  }

  addEmployee(plan: Employee): Observable<Employee> {
    return this.http.post(this.baseUrl, JSON.stringify(plan), this.getJsonContentTypeHeader()).pipe(
      map(data => data.json())
    );
  }

  updateEmployee(plan: Employee): Observable<Employee> {
    return this.http.put(this.baseUrl, JSON.stringify(plan), this.getJsonContentTypeHeader()).pipe(
      map(data => data.json())
    );
  }*/
}
