import { Component, OnInit ,Input} from '@angular/core';
import  { Ticket } from 'src/app/models/Ticket';
 

@Component({
  selector: 'app-ticketitem',
  templateUrl: './ticketitem.component.html',
  styleUrls: ['./ticketitem.component.css'  ]
})
export class TicketitemComponent implements OnInit {
  @Input() ticket: Ticket;
  constructor() { }

  ngOnInit(): void {
  }

}
