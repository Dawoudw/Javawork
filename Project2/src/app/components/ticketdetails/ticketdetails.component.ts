import { Component, OnInit, Input } from '@angular/core';
import { TicketService } from 'src/app/services/ticket.service';
import { Pizza } from 'src/app/models/Pizza';
import { ModalService } from 'src/app/services/modal.service';
import { Ticket } from 'src/app/models/Ticket';
import { Topping } from 'src/app/models/Topping';
@Component({
  selector: 'app-ticketdetails',
  templateUrl: './ticketdetails.component.html',
  styleUrls: ['./ticketdetails.component.css']
})
export class TicketdetailsComponent implements OnInit {

  @Input() ticketObj: Ticket;
  
  pizzas: Array<Pizza>;
  constructor(private ticketServ: TicketService) { }

  ngOnInit(): void {
  }
  async getTicketDetailsById(): Promise<Array<Pizza>> {
    this.pizzas = await this.ticketServ.getTicketDetailsById(this.ticketObj.ticketId);

    return this.pizzas;

  }




  // openModal(id: string) {
  //   this.modalService.open(id);
  // }

  // closeModal(id: string) {
  //   this.modalService.close(id);
  // }
}
