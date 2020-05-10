import { Component, OnInit, Input, Output, QueryList, ViewChild, ElementRef } from '@angular/core';
import { Ticket } from 'src/app/models/Ticket';
import { ModalService } from 'src/app/services/modal.service';
import { Pizza } from 'src/app/models/Pizza';
import { TicketService } from 'src/app/services/ticket.service';
import { Topping } from 'src/app/models/Topping';


@Component({
  selector: 'app-ticketitem',
  templateUrl: './ticketitem.component.html',
  styleUrls: ['./ticketitem.component.css']
})
export class TicketitemComponent implements OnInit {
  @Input() public ticket: Ticket;
  @Input() totalprice: number = 0.00;
  @Input() toppingprice: number = 0.00;
  pizzas: Array<Pizza>;
  @ViewChild("txtnotes1") txtnotes1: ElementRef;
  @ViewChild("btnEdit") btnEdit: ElementRef;
  @ViewChild("btnSave") btnSave: ElementRef;
  @ViewChild("ddlstatus") ddlstatus: ElementRef;
  public textValue: any;
  @Input() public LayoutContainer: any;
  @Input() public Layout: any;
  @Input() public LayoutItem: any;
  public updateResult: Number = 0;
  @Input() public IsEmployee: boolean  ;
  public isVisable: boolean = true;
  public ticketstatus: any;
  Statuslist: any = [
    { id: "Submitted", status: 'Submitted' },
    { id: 'InProgress', status: 'InProgress' },
    { id: 'Ready', status: 'Ready' },
    { id: 'OutForDelivery', status: 'Out For Delivery' },
    { id: 'Delivered', status: 'Delivered' }
  ];


  constructor(private modalService: ModalService, private ticketServ: TicketService) { }
  ngOnInit(): void {
    this.getTicketDetailsById();

  }
  editMode() {
    this.isVisable = !this.isVisable;
    // this.txtnotes1.nativeElement.class = "txtareaactive";
    this.txtnotes1.nativeElement.focus()
  }

  viewMode(note: any, state: any) {
    this.isVisable = !this.isVisable;
    this.ticketstatus = ""; this.textValue = "";
    // this.txtnotes1.nativeElement.class = "txtareaInactive";
   
  }

  ngDoCheck(): void {

  }
  async getTicketDetailsById(): Promise<Array<Pizza>> {
    console.log(this.ticket.ticketId);
    this.pizzas = await this.ticketServ.getTicketDetailsById(this.ticket.ticketId);

    this.totalprice = this.sumtotal();
    return this.pizzas;

  }
  async updateTicket(ticket: Ticket) {
    this.isVisable = !this.isVisable;
    console.log("updated tciket object is: " + JSON.stringify(ticket));
    this.updateResult = await this.ticketServ.updateTicket(ticket);
    // console.log("resut is :"  + this.updateResult );
  }
  sumtotal(): number {
    let x = 0;
    // console.log("sumtotal satrt:");
    this.pizzas.forEach(function (value) {
      // console.log("Pizza Areray values:");
      // console.log(value);
      value.toppings.forEach(function (t) {
        // console.log("Topping Areray values:");
        // console.log(value.toppings);       
        x = x + t.toppingCost;
      });
    });
    return x;
  }

  sumtopping(val: Array<any>): any {
    try {

      // console.log(val);

      let z = 0;
      for (let i = 0; i < val.length; i++) {
        z = z + val[i].toppingCost;
      }
      // console.log("Total Pizza  Topping is :");
      // console.log(z);
      return z;
    }
    catch{

    }
  }
  openModal() {
    this.modalService.open(this.ticket.ticketId + '');

  }

  closeModal() {
    this.modalService.close(this.ticket.ticketId + '');
  }
  // logDropdown(id: number): void {
  //   const NAME = this.Statuslist.find((item: any) => item.id === +id).status;
  //   console.log(`Value ${NAME} was selected`);
  // }
}
