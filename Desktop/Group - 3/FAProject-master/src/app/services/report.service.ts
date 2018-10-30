import { Injectable } from '@angular/core';
import { Http, RequestOptions, Headers, Response  } from '@angular/http';
import { Observable } from 'rxjs';
import { Report } from '../model/report';
import { map } from 'rxjs/operators';
import { Skill } from '../model/skill';

@Injectable({
  providedIn: 'root'
})
export class ReportService {

  baseUrl: string;
  baseUrl1: string;

  constructor(private http: Http) {
    this.baseUrl = "http://localhost:3030/reports";
    this.baseUrl1 = "http://localhost:3030/skills";
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

  getAllReports(): Observable<Report[]> {
    return this.http.get(this.baseUrl).pipe(
      map(data => data.json())
    );
  }
  getAllSkills(): Observable<Skill[]> {
    return this.http.get(this.baseUrl1).pipe(
      map(data => data.json())
    );
  }

  searchReports(field: string, value: string): Observable<Report[]> {
    return this.http.get(this.getSearchUrl(field,value)).pipe(
      map(data => data.json())
    );
  }

  getReportById(employeeId: number): Observable<Report> {
    return this.http.get(this.getBaseUrlById(employeeId)).pipe(
      map(data => data.json())
    );
  }

  /*deleteReportById(pTitle: string): Observable<Response> {
    return this.http.delete(this.getBaseUrlById(pTitle));
  }

  addReport(plan: Report): Observable<Report> {
    return this.http.post(this.baseUrl, JSON.stringify(plan), this.getJsonContentTypeHeader()).pipe(
      map(data => data.json())
    );
  }

  updateReport(plan: Report): Observable<Report> {
    return this.http.put(this.baseUrl, JSON.stringify(plan), this.getJsonContentTypeHeader()).pipe(
      map(data => data.json())
    );
  }*/
}
