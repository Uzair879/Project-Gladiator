import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Flight } from 'Flight';
import { parametersForSearchFlight } from 'parametersForSearchFlight';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AddflightService {

  private url="http://localhost:8088/AirlineApp/flights";
  constructor(private http_src:HttpClient) { }
  

  addflight(flight:Flight):Observable<any>
  {
    alert(flight.flight_departure);
    flight.flight_bs_price = 500;
    flight.flight_es_price = 100;
    flight.flight_no_es = 50;
    flight.flight_no_bs = 10;
    return this.http_src.post(this.url,flight);
  }

  getallflightt():Observable<Object>
  {
    return this.http_src.get(this.url)
  }
  private deleteurl="http://localhost:8088/AirlineApp/removeflights/";
  deleteflight(f:Flight):Observable<any>
  {
    alert("inside service"+f.flight_id);
    return this.http_src.post(this.deleteurl,f);

  }
  //search flight
  private searchurl="http://localhost:8088/AirlineApp/flights/search";
  //localhost:8089/airline-service/flights?from=kolkata&to=mumbai&departureDate=2017-01-13&returnDate=2017-01-13&passengerCount=0
  searchflights(f:parametersForSearchFlight):Observable<any>
  {
    alert("inside service"+f.flight_departure_date);
    return this.http_src.get(this.searchurl+'?from='+f.flight_from +'&to=' +f.flight_to +'&departureDate=' +f.flight_departure_date +'&returnDate=' +f.flight_return_date +'&passengerCount=' +f.passengercount);

  }
  

    //fetch seatBookings for flight
    private fetchurl="http://localhost:8088/AirlineApp/flights/";
    //localhost:8089/airline-service/flights?from=kolkata&to=mumbai&departureDate=2017-01-13&returnDate=2017-01-13&passengerCount=0
    fetchSeatBookings(flight_id:number):Observable<any>
    {
      return this.http_src.get(this.fetchurl+flight_id+"/seatbookings");
  
    }

  }

