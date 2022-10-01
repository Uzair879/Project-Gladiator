import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { UserloginService } from 'src/app/userlogin.service';
import Swal from 'sweetalert2';
import { User } from 'User';
import { usercred } from 'usercred';

@Component({
  selector: 'app-user-login',
  templateUrl: './user-login.component.html',
  styleUrls: ['./user-login.component.css']
})
export class UserLoginComponent implements OnInit {
 loginobj:User =new User();
  checkobj:any;
  allUsers!: any;
  invalidLoginCustomer!: boolean;
  u! : any;
  alertWithSuccess(){
    Swal.fire("Done!", "Logged In Sucessfully!"+this.u, "success");
  }

  // find()
  // {
  //   this.userLS.getallusers().subscribe(
  //     data=>{
  //       this.allUsers=data;
  //       console.log(this.allUsers)
  //     for (let index = 0; index < this.allUsers.length; index++) {
  //       if(this.allUsers[index].email==="akashchawla103@gmail.com")
  //       {
  //         console.log(true);
  //       }
        
  //     }

  //     }
  //   )
  // }
  constructor(private userlogin: UserloginService,private router : Router) { }
  ngOnInit(): void {

    
  }
  // gotoDashboard() {
  //   this.router.navigate(['/dashboard']);
  // }

  login()
  {

    this.userlogin.validate(this.loginobj).subscribe(
      //console.log("Subsribed");
       data=>{
        alert(this.loginobj.u_id);
        this.checkobj = data; 
        alert(this.checkobj.u_password)
        if(this.checkobj.u_password == this.loginobj.u_password){
          sessionStorage.setItem('u_id', this.loginobj.u_id.toString())
          this.u = sessionStorage.getItem('u_id') || null;
          // this.invalidLoginCustomer=false;
          // alert("loginsuccessful")
          this.alertWithSuccess();
          this.router.navigate(['searchflight']);
       }
      // else{
      //   this.invalidLoginCustomer=true;
      // }
        // else
        // {
        //   alert("Invalid Credentials")
        //   //this.message=user.message
        //   this.router.navigate(['admin-register'])
        //   console.log("Incorrect credentials");
        // }
})
}
}