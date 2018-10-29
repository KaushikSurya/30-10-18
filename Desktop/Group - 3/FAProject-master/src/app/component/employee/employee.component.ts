import { Component, OnInit } from '@angular/core';
import { EmployeeService } from '../../services/employee.service';
import { ActivatedRoute } from '@angular/router';
import { Employee } from '../../model/employee';

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent implements OnInit {

  employees : Employee[];

  constructor(private employeeService : EmployeeService,
  private activatedRoute : ActivatedRoute) { }

  ngOnInit() {
    this.employeeService.getAllEmployees().subscribe(
      (data) => this.employees=data,
      (err)=>this.employees=undefined
    );
  }

}
