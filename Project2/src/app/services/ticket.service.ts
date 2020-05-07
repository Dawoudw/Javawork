import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Ticket } from '../models/Ticket';
import { promise } from 'protractor';


@Injectable({
  providedIn: 'root'
})
export class TicketService {

  ticketlist: Array<Ticket>;
  ticket: Ticket;
  constructor(private httprequest: HttpClient) { }

  async registredUserTickets(userid: number): Promise<Array<Ticket>> {

    let response: Promise<any> = this.httprequest.get('http://localhost:9000/tickets/usertickets/' + userid).toPromise();
 
    return response;


  }



  async function (userid: number) {
    let response = await fetch('http://localhost:9000/tickets/usertickets/' + userid)
    if (response.ok) {
        let body = await response.text();
        //alert(body);
        let jsn = JSON.parse(body);
        //    alert(jsn);
       
     
       
    }
  
}









}
