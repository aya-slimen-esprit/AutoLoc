package tn.esprit.autoloc.autoloc.service;

import tn.esprit.autoloc.autoloc.domain.Equipement;

import java.util.List;

public interface IEquipementService {

    Equipement ajouterEquipement(Equipement equipement);

    Equipement modifierEquipement(Equipement equipement);

    List<Equipement> afficherToutesEquipement();

    Equipement afficherEquipementById(long id);

    void supprimerEquipement(long id);
}
