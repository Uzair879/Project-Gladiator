import { Component, OnInit } from '@angular/core';
import { Route, Router } from '@angular/router';

@Component({
  selector: 'app-selectflight',
  templateUrl: './selectflight.component.html',
  styleUrls: ['./selectflight.component.css']
})
export class SelectflightComponent implements OnInit {

select! : any;

  constructor(private router : Router) { }

  ngOnInit(): void {
  }
  flightselect() {

alert(this.select);
sessionStorage.setItem("class",this.select);
this.router.navigate(['bookseat']);
  }
}
