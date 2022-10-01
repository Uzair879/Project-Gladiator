import { Component, OnInit } from '@angular/core';
import { Data, Router } from '@angular/router';
import { Flight } from 'Flight';
import { AddflightService } from 'src/app/addflight.service';

@Component({
  selector: 'app-searchresult',
  templateUrl: './searchresult.component.html',
  styleUrls: ['./searchresult.component.css']
})
export class SearchresultComponent implements OnInit {

  constructor(private add:AddflightService,private router:Router) { }
  temp:any;
  tempData: any = {};
  ngOnInit(): void {
  }
  listofFlights = JSON.parse(sessionStorage.getItem("searchResult") || "[]");
  selectFlight = (f: Flight)=> {
    this.add.fetchSeatBookings(f.flight_id).subscribe(
      data=>{
        this.temp=data;
        data.forEach((element: any) => {
          this.tempData[element.sb_seat_number] = element
        });

      
        sessionStorage.setItem("SeatBookings",JSON.stringify(this.tempData))
        this.router.navigate(["selectflight"]);
       

      }
    )
  }

}
