import { Component, OnInit } from '@angular/core';

declare function setflightData(name : any,  name1 : any):any;
@Component({
  selector: 'app-seats',
  templateUrl: './seats.component.html',
  styleUrls: ['./seats.component.css']
})
export class SeatsComponent implements OnInit {
url : string = "src/assets/scripts/script.js";
  constructor() { }

  ngOnInit(): void {
    let currentseat = sessionStorage.getItem("seatlist");
    currentseat = JSON.stringify(currentseat);
    let array = document.getElementsByName("label");
    console.log(currentseat);
    console.log(array);
    for(var i = 0; i < array.length ; i++)
    {
      array[i].addEventListener("click",function handleclick(this:HTMLElement){
        console.log(this.innerHTML);
        sessionStorage.setItem("seat",this.innerHTML);
      })
    }
    console.log(array);
  }

}
