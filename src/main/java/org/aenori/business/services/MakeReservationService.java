package org.aenori.business.services;

import java.util.*;

import org.aenori.interfaces.IReservationFactory;
import org.aenori.model.Person;
import org.aenori.model.reservations.Reservation;

import jakarta.servlet.http.HttpServletRequest;

public class MakeReservationService {
	public class MakeReservationRequest {
		public Reservation reservation;
		public List<String> errors = new ArrayList<String>();
		
		public MakeReservationRequest(Reservation r) {
			reservation = r;
		}
		public MakeReservationRequest(Reservation r, String error) {
			reservation = r;
			errors.add(error);
		}
	}
	
	public MakeReservationRequest makeReservation(
		IReservationFactory reservationFactory,
		Person customer,
		Person agent,
		HttpServletRequest request
	) {
		try {
			 checkCustomerIsRegistered(customer);
			 Double price = computePrice(request);
			 
			 checkAgentPriceThreshold(agent, price);
			 checkCustomerBalance(customer, price);
			 
			 Reservation reservation = reservationFactory.createReservationFromRequest(request);
			
			 updateAgentPriceThreshold(agent, price);
			 updateCustomerBalance(customer, price);
			 
			return new MakeReservationRequest(reservation);
		}
		catch(Exception e) {
			return new MakeReservationRequest(null, e.getMessage());
		}
	}

	private void updateCustomerBalance(Person customer, Double price) {
		// TODO Auto-generated method stub
		
	}

	private void updateAgentPriceThreshold(Person agent, Double price) {
		// TODO Auto-generated method stub
		
	}

	private void checkCustomerBalance(Person customer, Double price) {
		// TODO Auto-generated method stub
		
	}

	private void checkAgentPriceThreshold(Person agent, Double price) {
		// TODO Auto-generated method stub
		
	}

	private Double computePrice(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	private void checkCustomerIsRegistered(Person customer) {
		// TODO Auto-generated method stub
		
	}
}
