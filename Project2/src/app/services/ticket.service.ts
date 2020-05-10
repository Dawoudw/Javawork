import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Ticket } from '../models/Ticket';
import { Pizza } from '../models/Pizza';

import { promise } from 'protractor';


@Injectable({
  providedIn: 'root'
})
export class TicketService {

  ticketlist: Array<Ticket>;
  ticket: Ticket;
  constructor(private httprequest: HttpClient) { }

  // get all tcikets by user id 
  async registredUserTickets(userid: number): Promise<Array<Ticket>> {

    let response: Promise<any> = this.httprequest.get('http://localhost:9000/tickets/usertickets/' + userid).toPromise();

    return response;


  }
 //Add new  ticket 
  async createTicket(ticket: Ticket): Promise<any> {
    let ticketPromise = await this.httprequest.post("http://localhost:9000/tickets", ticket).toPromise();
    return ticketPromise;
  }

  //Update ticket (only status or note )
  async  updateTicket(ticket: Ticket): Promise<Number> {
    console.log(ticket);
    let result: Number;
    let settings = {
      method: 'PUT',
      headers: {
        'Content-Type': 'application/json',
        'Access-Control-Allow-Origin': '*'
      },
      body: JSON.stringify(ticket)
    }

    let response = await fetch("http://localhost:9000//ticktes/update", settings);
    console.log(response);
    if (response.ok) {
      result = 1;
    } else {
      result = 0;
    }
    return result;
  }
// get all pizzas and topping by ticket id 
  async getTicketDetailsById(tikectid: number) {
    let response = await fetch('http://localhost:9000/tickets/details/' + tikectid)
    if (response.ok) {
      let body = await response.text();
      //alert(body);
      let jsn = JSON.parse(body);

      // console.log(jsn);
      //    alert(jsn);

      return jsn;

    }

  }








}
