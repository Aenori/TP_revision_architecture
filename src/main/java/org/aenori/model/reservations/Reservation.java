package org.aenori.model.reservations;

import org.aenori.interfaces.IVisitableReservation;
import org.aenori.interfaces.IVisitorReservation;
import org.aenori.model.Person;

public abstract class Reservation  {
    private Person customer;
    private Person vendor;
    private Integer id;

    public Reservation() {}
}