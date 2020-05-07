package dev.sun.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "topping")
public class Topping {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "topping_id")
	private int toppingId;

	@Column(name = "topping_name")
	private String toppingName;

	@Column(name = "topping_cost")
	private double toppingCost;

	@ManyToMany(mappedBy = "toppings")
	Set<Pizza> pizzas = new HashSet<Pizza>();

	public Topping() {
		super();
	}

	public Topping(int toppingId, String toppingName, double toppingCost) {
		super();
		this.toppingId = toppingId;
		this.toppingName = toppingName;
		this.toppingCost = toppingCost;
	}

	public int getToppingId() {
		return toppingId;
	}

	public void setToppingId(int toppingId) {
		this.toppingId = toppingId;
	}

	public String getToppingName() {
		return toppingName;
	}

	public void setToppingName(String toppingName) {
		this.toppingName = toppingName;
	}

	public double getToppingCost() {
		return toppingCost;
	}

	public void setToppingCost(double toppingCost) {
		this.toppingCost = toppingCost;
	}

	@Override
	public String toString() {
		return "Topping [toppingId=" + toppingId + ", toppingName=" + toppingName + ", toppingCost=" + toppingCost
				+ "]";
	}

}
