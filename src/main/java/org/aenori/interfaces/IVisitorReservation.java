package org.aenori.interfaces;

import org.aenori.model.reservations.BlablaCarReservation;
import org.aenori.model.reservations.HotelReservation;
import org.aenori.model.reservations.PlaneReservation;
import org.aenori.model.reservations.TrainReservation;

public interface IVisitorReservation 
{
	// Note : en fait il serait plus correct d'appeler ces methodes 
	//   visitPlaneReservation, visitTrainReservation, visitHotelReservation
    void visitPlaneReservation(PlaneReservation pr);
    void visitTrainReservation(TrainReservation tr);
	void visitBlablaCarReservation(BlablaCarReservation blablaCarReservation);
}