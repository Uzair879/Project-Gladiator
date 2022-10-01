import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { parametersForSearchFlight } from 'parametersForSearchFlight';
import { AddflightService } from 'src/app/addflight.service';


@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {
  f : parametersForSearchFlight = new parametersForSearchFlight();
  from !  :any;
  getUser: any;
  return! : any;
  
  constructor(private p:AddflightService,private router : Router) { }

  ngOnInit(): void {
  }


  fun()
  {
    this.from=true;
  }
  
  fun1()
  {
    this.from=null;
    this.return = null;
  }
search(){
  
this.p.searchflights(this.f).subscribe(data=>
  {
    this.getUser=data;
    alert(JSON.stringify(data))
    sessionStorage.setItem("searchResult", JSON.stringify(data));
    
    this.router.navigate(['searchresult']);
    

  })

  
}

}

