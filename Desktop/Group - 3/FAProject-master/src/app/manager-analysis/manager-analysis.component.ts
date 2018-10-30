import { Component, OnInit } from '@angular/core';
import { Route, Router } from '@angular/router';
import { EmployeeSkillService } from '../services/employee-skill.service';

@Component({
  selector: 'app-manager-analysis',
  templateUrl: './manager-analysis.component.html',
  styleUrls: ['./manager-analysis.component.css']
})
export class ManagerAnalysisComponent implements OnInit {

  srchValue : string;
  field : string;
  constructor(private router : Router,
    private empSkillService : EmployeeSkillService) { }

  ngOnInit() {
  }

  doSearch(field : string) {
    this.field=field+"Name";
    this.router.navigate(["/skillName"],{queryParams:{field:this.field,srchValue:this.srchValue}});
  }
    /*if(field && this.srchValue){
      if(field=='employee') {
      this.empSkillService.searchPlans(field,this.srchValue).subscribe(
        (data) => this.plans=data,
        (err)=>this.plans=undefined
      );*/
    
      
    /*  this.router.navigateByUrl('/empName/'+this.srchValue);
    }
      
    else
      this.router.navigateByUrl('/skillName/'+this.srchValue);
  }*/

}
