package org.aenori.model.reservations;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.aenori.interfaces.IVisitorReservation;
import org.aenori.model.Person;

public class PlaneReservation extends TransportReservation {
    private String flightNumber;
    private String companyName;

    public PlaneReservation() {}

    @Override
    public void accept(IVisitorReservation vr) { vr.visit(this); }

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
}