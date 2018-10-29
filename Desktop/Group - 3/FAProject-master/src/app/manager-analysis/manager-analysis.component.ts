import { Component, OnInit } from '@angular/core';
import { Route, Router } from '@angular/router';

@Component({
  selector: 'app-manager-analysis',
  templateUrl: './manager-analysis.component.html',
  styleUrls: ['./manager-analysis.component.css']
})
export class ManagerAnalysisComponent implements OnInit {

  constructor(private router : Router) { }

  ngOnInit() {
  }

  doSearch(value : string) {
    if(value=='employee')
      this.router.navigateByUrl('/empName');
    else
      this.router.navigateByUrl('/skillName');
  }

}
