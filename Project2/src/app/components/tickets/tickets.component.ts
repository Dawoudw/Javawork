import { Component, OnInit, Input } from '@angular/core';
import { Ticket } from 'src/app/models/Ticket';
import { TicketService } from 'src/app/services/ticket.service';


@Component({
  selector: 'app-tickets',
  templateUrl: './tickets.component.html',
  styleUrls: ['./tickets.component.css']
})
export class TicketsComponent implements OnInit {

  tickets:Array<Ticket>;

  ticket: any;
  constructor(private ticketServ: TicketService) { }
  columns: string[][] = [];
  
  ngOnInit(): void {
    this.getUserTickets();
  }
  async getUserTickets(): Promise<Array<Ticket>> {
    this.tickets = await this.ticketServ.registredUserTickets(3);
   
     return this.tickets;

  }
}

