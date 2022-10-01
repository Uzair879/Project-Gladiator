import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ɵNAMESPACE_URIS } from '@angular/platform-browser';
import { Observable } from 'rxjs';
import { User } from 'User';
import { usercred } from 'usercred';

@Injectable({
  providedIn: 'root'
})
export class UserloginService {

  
  private admin_login_url1 = "http://localhost:8088/AirlineApp/validateuser";
  constructor(private http_ser:HttpClient) { }

  validate(u : User):Observable<Object>
  {
    alert("id from service()"+u);
    return this.http_ser.get(this.admin_login_url1+'/'+u.u_id);
  }
  public getallusers()
  {
    return this.http_ser.get(this.admin_login_url1);
  }
  

}
