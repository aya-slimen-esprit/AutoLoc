package tn.esprit.autoloc.autoloc.service;

import tn.esprit.autoloc.autoloc.domain.Vehicule;

import java.util.List;

public interface IVehiculeService {

    Vehicule ajouterVehicule(Vehicule vehicule);

    Vehicule modifierVehicule(Vehicule vehicule);

    List<Vehicule> afficherToutesVehicules();

    Vehicule afficherVehiculeById(long id);

    void supprimerVehicule(long id);

    Vehicule affecterEquipement(Long idVehicule, Long idEquipement);
    Vehicule desaffecterEquipement(Long idVehicule, Long idEquipement);

}
