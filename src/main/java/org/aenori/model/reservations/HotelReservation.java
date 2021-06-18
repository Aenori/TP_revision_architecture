package org.aenori.model.reservations;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.annotation.ManagedBean;

import org.aenori.model.Person;

public abstract class HotelReservation extends Reservation {
    private Person customer;
    private Person vendor;
    private Integer id;

    public Reservation() {}
}

