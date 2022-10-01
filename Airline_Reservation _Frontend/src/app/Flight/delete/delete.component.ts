import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Flight } from 'Flight';
import { AddflightService } from 'src/app/addflight.service';

@Component({
  selector: 'app-delete',
  templateUrl: './delete.component.html',
  styleUrls: ['./delete.component.css']
})
export class DeleteComponent implements OnInit {
f : Flight = new Flight();
deletedflight : any;
id! : number;
  constructor(private fdel: AddflightService,private router : Router) { }

  ngOnInit(): void {
  }
fdelete(){

 this.id = this.f.flight_id;
 alert(this.id);
    this.fdel.deleteflight(this.f).subscribe(
      //console.log("Subscribed");
       data=>{
        //alert(this.f.flight_id);
        //this.deletedflight = data; 
        alert("deleted");
       // this.router.navigate(['viewflight']);
      })
    }
    }
