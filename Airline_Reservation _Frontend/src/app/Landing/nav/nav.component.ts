import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.css']
})
export class NavComponent implements OnInit {
  image_url="assets/images/akash.png";
  constructor() { }

  ngOnInit(): void {
  }

}
