import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'SunPizzeria';
  constructor()
  {
    this.title="The Sun Pizzeria"
    console.log(12);
  }
}
