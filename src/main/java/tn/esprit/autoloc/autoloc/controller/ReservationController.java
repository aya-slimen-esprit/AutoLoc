//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package tn.esprit.autoloc.autoloc.controller;

import java.time.LocalDate;
import java.util.List;
import lombok.Generated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.autoloc.autoloc.domain.Reservation;
import tn.esprit.autoloc.autoloc.service.IReservationService;

@RestController
@RequestMapping({"/reservations"})
public class ReservationController {
    private final IReservationService reservationService;

    @GetMapping({"/afficherToutesReservations"})
    public List<Reservation> getAllReservations() {
        return this.reservationService.afficherToutesReservations();
    }

    @GetMapping({"/afficherReservationById/{id}"})
    public Reservation getReservationById(@PathVariable Long id) {
        return this.reservationService.afficherReservationById(id);
    }

    @PostMapping({"/ajouterReservation"})
    public Reservation ajouterReservation(@RequestBody Reservation reservation) {
        return this.reservationService.ajouterReservation(reservation);
    }

    @PutMapping({"/modifierReservation"})
    public Reservation modifierReservation(@RequestBody Reservation reservation) {
        return this.reservationService.modifierReservation(reservation);
    }

    @DeleteMapping({"/supprimerReservation"})
    public void supprimerReservation(@RequestBody Reservation reservation) {
        this.reservationService.supprimerReservation(reservation);
    }

    @Generated
    public ReservationController(final IReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping("/afficherApresDateDebut/{date}")
    public List<Reservation> afficherApresDateDebut(@PathVariable LocalDate date) {
        return reservationService.retournerReservationsApresDateDebut(date);
    }

    @GetMapping("/afficherAvantDateFin/{date}")
    public List<Reservation> afficherAvantDateFin(@PathVariable LocalDate date) {
        return reservationService.retournerReservationsAvantDateFin(date);
    }
}