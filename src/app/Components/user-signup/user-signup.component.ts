import { Component, OnInit } from '@angular/core';
import {FormGroup,FormControl } from '@angular/forms';
import { Router } from '@angular/router';
import { UserRService } from 'src/app/user-r.service';
import Swal from 'sweetalert2';
import {User} from 'User'
@Component({
  selector: 'app-user-signup',
  templateUrl: './user-signup.component.html',
  styleUrls: ['./user-signup.component.css']
})
export class UserSignupComponent implements OnInit {
user:User=new User();
u! : any;

  constructor(private userr:UserRService, private router:Router) { }

  ngOnInit(): void {
  }
getUser:any;
alertWithSuccess(){
  Swal.fire("Done!", "Account Created Sucessfully! Your Id is " +this.u, "success");
}
register()
{

  // alert("hjh")
  this.userr.createUser(this.user).subscribe(
    data=>
    {

      this.getUser=data;
      this.router.navigate(['/']);

      

    }
  )
}
}
