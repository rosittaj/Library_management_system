package com.clientserver.dto;

public class Cart extends Book{
	private int quantity;
	private int person_id;
	private int id;
	private String status;
	
	
	
	
	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public Cart() {}



	public int getQuantity() {
		return quantity;
	}



	public int getPerson_id() {
		return person_id;
	}



	public void setPerson_id(int person_id) {
		this.person_id = person_id;
	}



	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	

}
