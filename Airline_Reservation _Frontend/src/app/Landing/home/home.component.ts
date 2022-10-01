import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  image_url="assets/images/logo2.png";
  constructor() { }

  ngOnInit(): void {
  }

}
