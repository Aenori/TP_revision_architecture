package org.aenori.model.reservations;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.aenori.interfaces.IVisitorReservation;
import org.aenori.model.Person;

public class TrainReservation extends TransportReservation {
    private Date date;
    private String villeDeDepart;
    private String villeDArrivee;

    public TrainReservation() {}

    @Override
    public void accept(IVisitorReservation vr) { vr.visit(this); }
}