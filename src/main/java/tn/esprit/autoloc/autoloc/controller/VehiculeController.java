//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package tn.esprit.autoloc.autoloc.controller;

import java.math.BigDecimal;
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
import tn.esprit.autoloc.autoloc.domain.CategorieVehicule;
import tn.esprit.autoloc.autoloc.domain.StatutVehicule;
import tn.esprit.autoloc.autoloc.domain.Vehicule;
import tn.esprit.autoloc.autoloc.service.IVehiculeService;

@RestController
@RequestMapping({"/vehicules"})
public class VehiculeController {
    private final IVehiculeService vehiculeService;

    @GetMapping({"/afficherToutesVehicules"})
    public List<Vehicule> getAllVehicules() {
        return this.vehiculeService.afficherToutesVehicules();
    }

    @GetMapping({"/afficherVehiculeById/{id}"})
    public Vehicule getVehiculeById(@PathVariable Long id) {
        return this.vehiculeService.afficherVehiculeById(id);
    }

    @PostMapping({"/ajouterVehicule"})
    public Vehicule ajouterVehicule(@RequestBody Vehicule vehicule) {
        return this.vehiculeService.ajouterVehicule(vehicule);
    }

    @PutMapping({"/modifierVehicule"})
    public Vehicule modifierVehicule(@RequestBody Vehicule vehicule) {
        return this.vehiculeService.modifierVehicule(vehicule);
    }

    @DeleteMapping({"/supprimerVehicule/{idVehicule}"})
    public void supprimerVehicule(@PathVariable Long idVehicule) {
        this.vehiculeService.supprimerVehicule(idVehicule);
    }

    @Generated
    public VehiculeController(final IVehiculeService vehiculeService) {
        this.vehiculeService = vehiculeService;
    }

    @PutMapping("/affecterEquipement/{idVehicule}/{idEquipement}")
    public Vehicule affecterEquipement(
            @PathVariable Long idVehicule,
            @PathVariable Long idEquipement) {
        return vehiculeService.affecterEquipement(
                idVehicule, idEquipement);
    }

    @PutMapping("/desaffecterEquipement/{idVehicule}/{idEquipement}")
    public Vehicule desaffecterEquipement(
            @PathVariable Long idVehicule,
            @PathVariable Long idEquipement) {
        return vehiculeService.desaffecterEquipement(
                idVehicule, idEquipement);
    }

    @GetMapping("/afficherParMarque/{b}")
    public List<Vehicule> afficherVehiculesMarque(@PathVariable String b){
        return vehiculeService.retournerVehiculesParMarque(b);
    }

    @GetMapping("/afficherParCategorie/{c}")
    public List<Vehicule> afficherVehiculesCategorie(@PathVariable CategorieVehicule c) {
        return vehiculeService.retournerVehiculesParCategorie(c);
    }

    @GetMapping("/afficherParStatut/{s}")
    public List<Vehicule> afficherVehiculesStatut(@PathVariable StatutVehicule s) {
        return vehiculeService.retournerVehiculesParStatut(s);
    }

    @GetMapping("/afficherParMarqueContenant/{m}")
    public List<Vehicule> afficherVehiculesParMarqueContenant(@PathVariable String m) {
        return vehiculeService.retournerVehiculesParMarqueContenant(m);
    }

    @GetMapping("/afficherParModeleCommencant/{m}")
    public List<Vehicule> afficherVehiculesParModeleCommencant(@PathVariable String m) {
        return vehiculeService.retournerVehiculesParModeleCommencant(m);
    }

    @GetMapping("/afficherTarifSuperieur/{tarif}")
    public List<Vehicule> afficherTarifSuperieur(@PathVariable BigDecimal tarif) {
        return vehiculeService.retournerVehiculesTarifSuperieur(tarif);
    }

    @GetMapping("/afficherTarifInferieur/{tarif}")
    public List<Vehicule> afficherTarifInferieur(@PathVariable BigDecimal tarif) {
        return vehiculeService.retournerVehiculesTarifInferieur(tarif);
    }

    @GetMapping("/afficherTarifSuperieurOuEgal/{tarif}")
    public List<Vehicule> afficherTarifSuperieurOuEgal(@PathVariable BigDecimal tarif) {
        return vehiculeService.retournerVehiculesTarifSuperieurOuEgal(tarif);
    }

    @GetMapping("/afficherParMarqueEtStatut/{marque}/{statut}")
    public List<Vehicule> afficherParMarqueEtStatut(@PathVariable String marque, @PathVariable StatutVehicule statut) {
        return vehiculeService.retournerVehiculesParMarqueEtStatut(marque, statut);
    }

    @GetMapping("/afficherParDeuxCategories/{c1}/{c2}")
    public List<Vehicule> afficherParDeuxCategories(@PathVariable CategorieVehicule c1, @PathVariable CategorieVehicule c2) {
        return vehiculeService.retournerVehiculesParDeuxCategories(c1, c2);
    }

    @GetMapping("/afficherParMarqueEtTarif/{marque}/{tarif}")
    public List<Vehicule> afficherParMarqueEtTarif(@PathVariable String marque, @PathVariable BigDecimal tarif) {
        return vehiculeService.retournerVehiculesParMarqueEtTarifInferieur(marque, tarif);
    }

    @GetMapping("/afficherDisponiblesParTarifCroissant")
    public List<Vehicule> afficherDisponiblesParTarifCroissant() {
        return vehiculeService.retournerVehiculesDisponiblesParTarifCroissant();
    }

    @GetMapping("/afficherParTarifDecroissant")
    public List<Vehicule> afficherParTarifDecroissant() {
        return vehiculeService.retournerVehiculesParTarifDecroissant();
    }
}