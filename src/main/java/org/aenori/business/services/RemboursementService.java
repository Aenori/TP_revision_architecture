package org.aenori.business.services;

import org.aenori.business.remboursement.RemboursementVisitor;
import org.aenori.interfaces.IVisitableReservation;
import org.aenori.model.reservations.Reservation;
import org.aenori.model.reservations.TrainReservation;
import org.aenori.model.reservations.TransportReservation;

public class RemboursementService {
	public void rembourser(IVisitableReservation reservation) {
		reservation.accept(new RemboursementVisitor());
	}
}
