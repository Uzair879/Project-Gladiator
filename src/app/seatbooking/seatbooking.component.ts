import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';
import { update } from 'update';
import { BookService } from '../book.service';

@Component({
  selector: 'app-seatbooking',
  templateUrl: './seatbooking.component.html',
  styleUrls: ['./seatbooking.component.css']
})
export class SeatbookingComponent implements OnInit {
  ngOnInit(): void {
    console.log("implementing")
    this.mapFiltering()
  }
 ids : any;
 userid : any;
 onSubmit(){

 }
 u:update = new update();
 seatbookings : any = JSON.parse(sessionStorage.getItem("SeatBookings") || "{}");
 type_flight :string=sessionStorage.getItem("class") || "";
 filteredType : String = this.type_flight;
 color: any;
  constructor(private book:BookService, private router:Router){}
  myFunction(event: any) 
  {
    const key = event.currentTarget.id;
    const newStatus = this.seatbookings[key].sb_status == 'available' ? 'selected' : 'available';
    this.seatbookings[key].sb_status = newStatus;
  }
  // {sb_number: 1A, isDisabeled: true, sb_type: economy}

  mapFiltering() 
  {

    Object.entries(this.seatbookings).forEach((s: any)=>{
      let seatBooking = s[1]
      seatBooking["isDisabled"] = (seatBooking.sb_type != this.filteredType) ? true : null;
      this.seatbookings[seatBooking.sb_seat_number] = seatBooking;
    })

    console.log(this.seatbookings)
  }
  alertWithSuccess(){
    Swal.fire("Done!", "Seat Booked Sucessfully!", "success");
  }

  selectSeats(){
    const selectedSeats =     Object.entries(this.seatbookings).filter((s: any)=>{ 
      return s[1].sb_status == "selected" }).map((s: any)=> {return s[1].sb_id})
    console.log(selectedSeats);
    this.register();
  }
  register()

{
  this.u.user_id = this.userid=sessionStorage.getItem("u_id");
  this.seatbookings = this.selectSeats;
  this.book.updateseatbooking(this.u).subscribe(
    data=>
    {
      alert("seatBooked");

      this.alertWithSuccess();
      this.router.navigate(['/']);

      

    }
  )
}

  }