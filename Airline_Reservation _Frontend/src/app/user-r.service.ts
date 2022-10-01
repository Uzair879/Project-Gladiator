import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from 'User';

@Injectable({
  providedIn: 'root'
})
export class UserRService {

  private url_add="http://localhost:8088/AirlineApp/user";

  constructor(private http_ser:HttpClient) { }

   createUser(user:User):Observable<Object>
   {
    return this.http_ser.post(this.url_add,user);
   }
}
