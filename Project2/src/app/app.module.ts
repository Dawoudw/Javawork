import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TicketsComponent } from './components/tickets/tickets.component';
import { PizzaComponent } from './components/pizza/pizza.component';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';
import { UserRoleComponent } from './components/user-role/user-role.component';
import { UserComponent } from './components/user/user.component';
import { ToppingComponent } from './components/topping/topping.component';
import { CurrencyPipe } from './pipes/currency.pipe';
import { TimestampPipe } from './pipes/timestamp.pipe';
import { APP_BASE_HREF } from '@angular/common';
import { GalleryComponent } from './components/gallery/gallery.component';
import { AboutComponent } from './components/about/about.component';
import { ContactComponent } from './components/contact/contact.component';
import { TicketitemComponent } from './components/ticketitem/ticketitem.component';
import { EvenoddPipe } from './pipes/evenodd.pipe';
import { TicketdetailsComponent } from './components/ticketdetails/ticketdetails.component';




@NgModule({
  declarations: [
    AppComponent,
    TicketsComponent,
    PizzaComponent,
    LoginComponent,
    RegisterComponent,
    UserRoleComponent,
    UserComponent,
    ToppingComponent,
    CurrencyPipe,
    TimestampPipe,
    GalleryComponent,
    AboutComponent,
    ContactComponent,
    TicketitemComponent,
    EvenoddPipe,
    TicketdetailsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
  ],
  providers: [{ provide: APP_BASE_HREF, useValue: '' }],
  bootstrap: [AppComponent]
})
export class AppModule { }
