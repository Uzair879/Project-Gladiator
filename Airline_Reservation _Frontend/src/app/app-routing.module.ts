import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { UserLoginComponent } from './Components/user-login/user-login.component';
import { UserSignupComponent } from './Components/user-signup/user-signup.component';
import { HomeComponent } from './Landing/home/home.component';


import {AddComponent} from './Flight/add/add.component';
import {DeleteComponent} from './Flight/delete/delete.component';
import {SearchComponent} from './Flight/search/search.component';
import {SelectComponent} from './Flight//select/select.component';
import { AdminComponent } from './Admin/admin.component';
import { DashboardComponent } from './Admin/dashboard/dashboard.component';
import { ViewComponent } from './Flight/view/view.component';
import { AppComponent } from './app.component';
import { SeatsComponent } from './seats/seats.component';
import { SelectflightComponent } from './selectflight/selectflight.component';
import { SeatbookingComponent } from './seatbooking/seatbooking.component';
import { SearchresultComponent } from './Flight/searchresult/searchresult.component';
// import {AdminComponent} from './Admin'
const routes: Routes = [
  { 
    path: 'adminroute',
    component :DashboardComponent,
    children:[
    {path:'' ,component:ViewComponent},
    {path:"admin",component:AdminComponent},
    {path:'viewflight' ,component:ViewComponent},
    {path:'addflight',component:AddComponent},
    {path:'deleteflight',component:DeleteComponent}
  ]},



    {path:'',component : HomeComponent},
    {path:'home',component : HomeComponent},
    {path:'login',component : UserLoginComponent},
    {path:'signup',component:UserSignupComponent},
    {path:'searchflight',component:SearchComponent},
    {path:'viewflight' ,component:ViewComponent},
    {path:'addflight',component:AddComponent},
    {path:'deleteflight',component:DeleteComponent},
    {path:"seatbooking",component:SeatsComponent},
    {path:"selectflight",component:SelectflightComponent},
    {path:"bookseat",component:SeatbookingComponent},
    {path:"searchresult",component:SearchresultComponent}
]


// {path:"addflight",component:AddComponent},
// {path:"deleteflight",component:DeleteComponent},

// {path:"selectflight",component:SelectComponent},
// {path:"admindashboard",component:DashboardComponent},
// {path:"viewflights",component:ViewComponent},
// ]




@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
