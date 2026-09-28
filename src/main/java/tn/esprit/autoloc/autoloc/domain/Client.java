package tn.esprit.autoloc.autoloc.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idClient;

    String nom;

    String prenom;

    String email;

    String telephone;

    String numPermis;

    LocalDate dateInscription;

    @OneToMany(
            mappedBy = "client",
            fetch = FetchType.LAZY
    )
    List<Reservation> reservations = new ArrayList<>();

    @OneToMany(
            mappedBy = "client",
            fetch = FetchType.LAZY
    )
    List<Contrat> contrats = new ArrayList<>();
}