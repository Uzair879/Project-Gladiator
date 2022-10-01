import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-anavbar',
  templateUrl: './anavbar.component.html',
  styleUrls: ['./anavbar.component.css']
})
export class AnavbarComponent implements OnInit {

  image_url="asse"
  constructor(private route:Router) { }

  ngOnInit(): void {
  }
logout()
{
  sessionStorage.removeItem("admin");
  this.route.navigate(['/']);
}
}
