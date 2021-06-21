package org.aenori.model.reservations;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.aenori.interfaces.IVisitorReservation;
import org.aenori.model.Person;

public abstract class HotelReservation extends Reservation {
    private Person customer;
    private Person vendor;
    private Integer id;

    public HotelReservation() {}

	public Person getCustomer() {
		return customer;
	}

	public void setCustomer(Person customer) {
		this.customer = customer;
	}

	public Person getVendor() {
		return vendor;
	}

	public void setVendor(Person vendor) {
		this.vendor = vendor;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}

