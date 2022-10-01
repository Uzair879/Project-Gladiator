import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Flight } from 'Flight';
import { AddflightService } from 'src/app/addflight.service';

@Component({
  selector: 'app-view',
  templateUrl: './view.component.html',
  styleUrls: ['./view.component.css']
})
export class ViewComponent implements OnInit {

  checkobj:any;
  f:Flight=new Flight();
  listofFlights:any;

  constructor(private fs:AddflightService,private router : Router) { }
 

  ngOnInit(): void {
    
    this.getall();
  }



getall()
{
  this.fs.getallflightt().subscribe(
    data=>{
      this.listofFlights=data;
})
 
}
}
