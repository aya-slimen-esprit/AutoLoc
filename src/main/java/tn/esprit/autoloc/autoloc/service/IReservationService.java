package tn.esprit.autoloc.autoloc.service;

import tn.esprit.autoloc.autoloc.domain.Reservation;

import java.time.LocalDate;
import java.util.List;

public interface IReservationService {

    Reservation ajouterReservation(Reservation reservation);

    Reservation modifierReservation(Reservation reservation);

    List<Reservation> afficherToutesReservations();

    Reservation afficherReservationById(long id);

    void supprimerReservation(Reservation reservation);

    public List<Reservation> retournerReservationsApresDateDebut(LocalDate date);

    public List<Reservation> retournerReservationsAvantDateFin(LocalDate date);
}