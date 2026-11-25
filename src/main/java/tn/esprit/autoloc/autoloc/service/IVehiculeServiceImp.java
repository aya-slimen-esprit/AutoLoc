package tn.esprit.autoloc.autoloc.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.autoloc.domain.CategorieVehicule;
import tn.esprit.autoloc.autoloc.domain.Equipement;
import tn.esprit.autoloc.autoloc.domain.StatutVehicule;
import tn.esprit.autoloc.autoloc.domain.Vehicule;
import tn.esprit.autoloc.autoloc.repository.EquipementRepository;
import tn.esprit.autoloc.autoloc.repository.VehiculeRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
@Service
@AllArgsConstructor
public class IVehiculeServiceImp implements IVehiculeService {

    private final VehiculeRepository vehiculeRepository;

    @Override
    public Vehicule ajouterVehicule(Vehicule vehicule) {
        return vehiculeRepository.save(vehicule);
    }

    @Override
    public Vehicule modifierVehicule(Vehicule vehicule) {
        return vehiculeRepository.save(vehicule);
    }

    @Override
    public List<Vehicule> afficherToutesVehicules() {
        return vehiculeRepository.findAll();
    }

    @Override
    public Vehicule afficherVehiculeById(long id) {
        return vehiculeRepository.findById(id).orElse(null);
    }

    @Override
    public void supprimerVehicule(long id) {
        vehiculeRepository.deleteById(id);

    }

    private final EquipementRepository equipementRepository;

    @Override
    @Transactional
    public Vehicule affecterEquipement(Long idVehicule, Long idEquipement) {
        Vehicule vehicule = vehiculeRepository.findById(idVehicule)
                .orElseThrow(() -> new EntityNotFoundException("Véhicule introuvable : " + idVehicule));
        Equipement equipement = equipementRepository.findById(idEquipement)
                .orElseThrow(() -> new EntityNotFoundException("Équipement introuvable : " + idEquipement));
        if (!vehicule.getEquipements().contains(equipement)) {
            vehicule.getEquipements().add(equipement);
        }
        return vehiculeRepository.save(vehicule);
    }

    @Override
    @Transactional
    public Vehicule desaffecterEquipement(
            Long idVehicule, Long idEquipement) {

        Vehicule vehicule = vehiculeRepository.findById(idVehicule)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Véhicule introuvable : " + idVehicule));

        Equipement equipement = equipementRepository.findById(idEquipement)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Équipement introuvable : " + idEquipement));

        vehicule.getEquipements().removeIf(
                e -> e.getIdEquipement().equals(idEquipement)
        );

        return vehiculeRepository.save(vehicule);
    }

    @Override
    public List<Vehicule> retournerVehiculesParMarque(String m) {
        return vehiculeRepository.findByMarque(m);
    }

    @Override
    public List<Vehicule> retournerVehiculesParCategorie(CategorieVehicule c) {
        return vehiculeRepository.findByCategorie(c);
    }

    @Override
    public List<Vehicule> retournerVehiculesParStatut(StatutVehicule s) {
        return vehiculeRepository.findByStatut(s);
    }

    @Override
    public List<Vehicule> retournerVehiculesParMarqueContenant(String m) {
        return vehiculeRepository.findByMarqueContaining(m);
    }

    @Override
    public List<Vehicule> retournerVehiculesParModeleCommencant(String m) {
        return vehiculeRepository.findByModeleStartingWith(m);
    }

    @Override
    public List<Vehicule> retournerVehiculesTarifSuperieur(BigDecimal tarif) {
        return vehiculeRepository.findByTarifJournalierGreaterThan(tarif);
    }

    @Override
    public List<Vehicule> retournerVehiculesTarifInferieur(BigDecimal tarif) {
        return vehiculeRepository.findByTarifJournalierLessThan(tarif);
    }

    @Override
    public List<Vehicule> retournerVehiculesTarifSuperieurOuEgal(BigDecimal tarif) {
        return vehiculeRepository.findByTarifJournalierGreaterThanEqual(tarif);
    }

    @Override
    public List<Vehicule> retournerVehiculesParMarqueEtStatut(String marque, StatutVehicule statut) {
        return vehiculeRepository.findByMarqueAndStatut(marque, statut);
    }

    @Override
    public List<Vehicule> retournerVehiculesParDeuxCategories(CategorieVehicule c1, CategorieVehicule c2) {
        return vehiculeRepository.findByCategorieOrCategorie(c1, c2);
    }

    @Override
    public List<Vehicule> retournerVehiculesParMarqueEtTarifInferieur(String marque, BigDecimal tarif) {
        return vehiculeRepository.findByMarqueAndTarifJournalierLessThan(marque, tarif);
    }

    @Override
    public List<Vehicule> retournerVehiculesDisponiblesParTarifCroissant() {
        return vehiculeRepository.findByStatutOrderByTarifJournalierAsc(StatutVehicule.DISPONIBLE);
    }

    @Override
    public List<Vehicule> retournerVehiculesParTarifDecroissant() {
        return vehiculeRepository.findAllByOrderByTarifJournalierDesc();
    }

    @Scheduled(initialDelay = 5000, fixedRate = 60000)
    public void actualiserEtatVehicules() {

        List<Vehicule> vehicules = vehiculeRepository.findAll();

        System.out.println("Nombre total des véhicules : " + vehicules.size());

        System.out.println("Date et heure d'actualisation : " + LocalDateTime.now());
    }


    @Scheduled(fixedRate = 10000)
    public void genererRapportVehicules() {

        List<Vehicule> vehicules = vehiculeRepository.findAll();

        int nombreTotal = vehicules.size();

        System.out.println("===== RAPPORT DES VEHICULES =====");

        System.out.println("Nombre total des véhicules : " + nombreTotal);

        System.out.println("Date et heure de génération : " + new Date());

        System.out.println("=================================");
    }

}