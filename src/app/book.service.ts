import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { update } from 'update';

@Injectable({
  providedIn: 'root'
})
export class BookService {
  private admin_login_url1 = "http://localhost:8088/AirlineApp/flights/updateseatbookings";
  constructor(private http_src:HttpClient) { }
  updateseatbooking(u:update):Observable<Object>{
    
    return this.http_src.post(this.admin_login_url1,u);
  }

}
