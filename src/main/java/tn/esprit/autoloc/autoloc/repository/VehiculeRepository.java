package tn.esprit.autoloc.autoloc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.autoloc.autoloc.domain.CategorieVehicule;
import tn.esprit.autoloc.autoloc.domain.StatutVehicule;
import tn.esprit.autoloc.autoloc.domain.Vehicule;

import java.math.BigDecimal;
import java.util.List;

public interface VehiculeRepository extends JpaRepository<Vehicule,Long> {
    List<Vehicule> findByMarque(String marque);
    List<Vehicule> findByCategorie(CategorieVehicule c);
    List<Vehicule> findByStatut(StatutVehicule s);
    List<Vehicule> findByMarqueContaining(String marque);
    List<Vehicule> findByModeleStartingWith(String modele);
    List<Vehicule> findByTarifJournalierGreaterThan(BigDecimal tarif);
    List<Vehicule> findByTarifJournalierLessThan(BigDecimal tarif);
    List<Vehicule> findByTarifJournalierGreaterThanEqual(BigDecimal tarif);
    List<Vehicule> findByMarqueAndStatut(String marque, StatutVehicule statut);
    List<Vehicule> findByCategorieOrCategorie(CategorieVehicule c1, CategorieVehicule c2);
    List<Vehicule> findByMarqueAndTarifJournalierLessThan(String marque, BigDecimal tarif);
    List<Vehicule> findByStatutOrderByTarifJournalierAsc(StatutVehicule statut);
    List<Vehicule> findAllByOrderByTarifJournalierDesc();
}