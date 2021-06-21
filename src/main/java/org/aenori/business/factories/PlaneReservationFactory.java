package org.aenori.business.factories;

import java.net.http.HttpRequest;

import org.aenori.interfaces.IReservationFactory;
import org.aenori.model.reservations.PlaneReservation;
import org.aenori.model.reservations.Reservation;
import org.aenori.model.reservations.bonus.Bonus;
import org.aenori.model.reservations.bonus.PlaneReservationBonus;

import jakarta.servlet.http.HttpServletRequest;

public class PlaneReservationFactory implements IReservationFactory {

	@Override
	public Reservation createReservationFromRequest(HttpServletRequest request) {
		return new PlaneReservation();
	}

	@Override
	public Bonus createBonusFromRequest(HttpServletRequest request, Reservation reservation) {
		return new PlaneReservationBonus();
	}

}
