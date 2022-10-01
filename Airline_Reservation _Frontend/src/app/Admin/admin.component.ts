import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AdminLogin } from 'AdminLogin';
import Swal from 'sweetalert2';
import { AdminLoginService } from '../admin-login.service';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

imageurl="assets/images/admin.jpg";

ngOnInit(): void {
 
}




loginobj:AdminLogin =new AdminLogin();
checkobj:any;
//declaring properties
adminId! : number ;
password! : string ;
constructor(private adminLoginService: AdminLoginService,private router : Router) { }
alertWithSuccess(){
  Swal.fire("Good job!", "You clicked the button!", "success");
}
login()
{
  
  this.adminLoginService.validate(this.loginobj).subscribe(
    //console.log("Subsribed");
    data=>{
      alert(this.loginobj.adminId);
      this.checkobj = data; 
      if(this.checkobj.password == this.loginobj.password){
        this.alertWithSuccess();
        sessionStorage.setItem("admin","true");
        this.router.navigate(['adminroute/viewflight']);

     }
  })
}
}
