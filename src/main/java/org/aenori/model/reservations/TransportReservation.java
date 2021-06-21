package org.aenori.model.reservations;

import org.aenori.interfaces.IVisitableReservation;
import org.aenori.interfaces.IVisitorReservation;

public abstract class TransportReservation extends Reservation implements IVisitableReservation {
	public abstract void accept(IVisitorReservation vr);
}
