import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, NgModel } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
// import { NavbarComponent } from './Navigation/navbar/navbar.component';
import { HomeComponent } from './Landing/home/home.component';
import { FooterComponent } from './Navigation/footer/footer.component';
import { TripsComponent } from './Landing/trips/trips.component';
import { UserLoginComponent } from './Components/user-login/user-login.component';
import { UserSignupComponent } from './Components/user-signup/user-signup.component';
import { ReactiveFormsModule } from '@angular/forms';
import { SearchComponent } from './Flight/search/search.component';
import { AddComponent } from './Flight/add/add.component';
import { DeleteComponent } from './Flight/delete/delete.component';
import { SelectComponent } from './Flight/select/select.component';
import { HttpClient, HttpClientModule } from '@angular/common/http';
// import { AdminNavComponent } from './admin-nav/admin-nav.component';
import { NavComponent } from './Landing/nav/nav.component';
import { NavbarComponent } from './navbar/navbar.component';
import { AdminComponent } from './Admin/admin.component';
import { DashboardComponent } from './Admin/dashboard/dashboard.component';
import { AnavbarComponent } from './Admin/anavbar/anavbar.component';
import { ViewComponent } from './Flight/view/view.component';
import { SeatsComponent } from './seats/seats.component';
import { SelectflightComponent } from './selectflight/selectflight.component';
import { SeatbookingComponent } from './seatbooking/seatbooking.component';
import { SearchresultComponent } from './Flight/searchresult/searchresult.component';


@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    HomeComponent,
    FooterComponent,
    TripsComponent,
    UserLoginComponent,
    UserSignupComponent,
    SearchComponent,
    AddComponent,
    DeleteComponent,
    SelectComponent,
    AdminComponent,
    NavComponent,
    AdminComponent,
    DashboardComponent,
    AnavbarComponent,
    ViewComponent,
    SeatsComponent,
    SelectflightComponent,
    SeatbookingComponent,
    SearchresultComponent,   
   
   
  ],
  imports: [
    BrowserModule,
    AppRoutingModule, ReactiveFormsModule,
    FormsModule,HttpClientModule,
    // HttpClient
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
