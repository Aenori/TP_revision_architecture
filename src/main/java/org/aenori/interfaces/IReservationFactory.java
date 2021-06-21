package org.aenori.interfaces;

import java.net.http.HttpRequest;

import org.aenori.model.reservations.Reservation;
import org.aenori.model.reservations.bonus.Bonus;

import jakarta.servlet.http.HttpServletRequest;

public interface IReservationFactory {
    public Reservation createReservationFromRequest(
    		HttpServletRequest request
    ) throws Exception;
    public Bonus createBonusFromRequest(
    		HttpServletRequest request, 
    		Reservation reservation
    )  throws Exception;
}