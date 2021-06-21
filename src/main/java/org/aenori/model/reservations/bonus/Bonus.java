package org.aenori.model.reservations.bonus;

import org.aenori.model.reservations.Reservation;

public class Bonus {
	private Reservation reservation;
	private int price;
	private String details;
	
	public Reservation getReservation() {
		return reservation;
	}
	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	
	
	
}
