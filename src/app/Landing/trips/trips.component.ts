import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-trips',
  templateUrl: './trips.component.html',
  styleUrls: ['./trips.component.css']
})
export class TripsComponent implements OnInit {
  image_url="assets/images/logo.png";
  image_url1="assets/images/air.png";
  constructor() { }

  ngOnInit(): void {
  }

}
