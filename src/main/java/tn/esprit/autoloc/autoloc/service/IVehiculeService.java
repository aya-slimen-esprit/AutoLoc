package tn.esprit.autoloc.autoloc.service;

import tn.esprit.autoloc.autoloc.domain.CategorieVehicule;
import tn.esprit.autoloc.autoloc.domain.StatutVehicule;
import tn.esprit.autoloc.autoloc.domain.Vehicule;

import java.math.BigDecimal;
import java.util.List;

public interface IVehiculeService {

    Vehicule ajouterVehicule(Vehicule vehicule);

    Vehicule modifierVehicule(Vehicule vehicule);

    List<Vehicule> afficherToutesVehicules();

    Vehicule afficherVehiculeById(long id);

    void supprimerVehicule(long id);

    Vehicule affecterEquipement(Long idVehicule, Long idEquipement);
    Vehicule desaffecterEquipement(Long idVehicule, Long idEquipement);

    public List<Vehicule> retournerVehiculesParMarque(String m);

    public List<Vehicule> retournerVehiculesParCategorie(CategorieVehicule c);

    public List<Vehicule> retournerVehiculesParStatut(StatutVehicule s);

    public List<Vehicule> retournerVehiculesParMarqueContenant(String m);

    public List<Vehicule> retournerVehiculesParModeleCommencant(String m);

    public List<Vehicule> retournerVehiculesTarifSuperieur(BigDecimal tarif);

    public List<Vehicule> retournerVehiculesTarifInferieur(BigDecimal tarif);

    public List<Vehicule> retournerVehiculesTarifSuperieurOuEgal(BigDecimal tarif);

    public List<Vehicule> retournerVehiculesParMarqueEtStatut(String marque, StatutVehicule statut);

    public List<Vehicule> retournerVehiculesParDeuxCategories(CategorieVehicule c1, CategorieVehicule c2);

    public List<Vehicule> retournerVehiculesParMarqueEtTarifInferieur(String marque, BigDecimal tarif);

    public List<Vehicule> retournerVehiculesDisponiblesParTarifCroissant();

    public List<Vehicule> retournerVehiculesParTarifDecroissant();
}