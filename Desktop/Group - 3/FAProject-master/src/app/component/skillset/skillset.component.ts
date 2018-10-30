import { Component, OnInit } from '@angular/core';
import { Skill } from '../../model/skill';
import { ReportService } from '../../services/report.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-skillset',
  templateUrl: './skillset.component.html',
  styleUrls: ['./skillset.component.css']
})
export class SkillsetComponent implements OnInit {

  skills : Skill[];

  constructor(private reportService : ReportService) { }

  ngOnInit() {
    this.reportService.getAllSkills().subscribe(
      (data) => this.skills=data
      // (err)=>this.employees=undefined
    );
    console.log(this.skills);
  }

  }


