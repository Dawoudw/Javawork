package dev.wsd.entities;

/**
 * @author Admin
 * @version 1.0
 * @created 07-Apr-2020 8:56:24 AM
 */
public class TransactionType {

	private int id;
	private String transName;
	private boolean effect;
 

	public TransactionType(){

	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTransName() {
		return transName;
	}


	public void setTransName(String transName) {
		this.transName = transName;
	}


	public boolean isEffect() {
		return effect;
	}


	public void setEffect(boolean effect) {
		this.effect = effect;
	}

	 

}