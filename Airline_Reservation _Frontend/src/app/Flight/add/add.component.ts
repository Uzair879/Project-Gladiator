import { Component, OnInit } from '@angular/core';
import { Route, Router } from '@angular/router';
import { Flight } from 'Flight';
import { AddflightService } from 'src/app/addflight.service';


@Component({
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.css']
})
export class AddComponent implements OnInit {

  constructor(private add:AddflightService,private router:Router) { }
  flight:Flight=new Flight();
  //tempflight:Flight=new Flight();
  ngOnInit(): void {
  }

  temp:any;
  addflight()
  {
    
    this.add.addflight(this.flight).subscribe(
      data=>{
        this.temp=data; 
        alert("from backend");
  
        //this.router.navigate(["deleteflight"]);
       

      }
    )
    
  }

}
