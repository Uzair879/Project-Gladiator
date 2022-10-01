import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AdminLogin } from 'AdminLogin';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AdminLoginService {
  private admin_register_url = "http://localhost:8088/AirlineApp/adminregister";
  private admin_login_url = "http://localhost:8088/AirlineApp/adminlogin";
  
  constructor(private http_ser:HttpClient) { }

  createAdmin(admin:AdminLogin): Observable<Object>{    
    return this.http_ser.post(this.admin_register_url,admin);
  }

//  getAdminById(adminId : number): Observable<any>{
//     return this.http_ser.get(this.admin_login_url+ '/'+adminId);
//   }

  validate(admin: AdminLogin): Observable<Object> {
    alert("id from service()"+admin.adminId);
    return this.http_ser.get(this.admin_login_url + '/'+ admin.adminId);
  }
}