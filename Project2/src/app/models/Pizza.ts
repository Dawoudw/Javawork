import { Topping } from './Topping';

export class Pizza {
    pizzaId: number;
    private _toppings: Array<Topping>;
    public get toppings(): Array<Topping> {
        return this._toppings;
    }
    public set toppings(value: Array<Topping>) {
        this._toppings = value;
    }
}

