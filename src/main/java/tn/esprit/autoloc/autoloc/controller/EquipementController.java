//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package tn.esprit.autoloc.autoloc.controller;

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
import tn.esprit.autoloc.autoloc.domain.Equipement;
import tn.esprit.autoloc.autoloc.service.IEquipementService;

@RestController
@RequestMapping({"/equipements"})
public class EquipementController {
    private final IEquipementService equipementService;

    @GetMapping({"/afficherToutesEquipements"})
    public List<Equipement> getAllEquipements() {
        return this.equipementService.afficherToutesEquipement();
    }

    @GetMapping({"/afficherEquipementById/{id}"})
    public Equipement getEquipementById(@PathVariable Long id) {
        return this.equipementService.afficherEquipementById(id);
    }

    @PostMapping({"/ajouterEquipement"})
    public Equipement ajouterEquipement(@RequestBody Equipement equipement) {
        return this.equipementService.ajouterEquipement(equipement);
    }

    @PutMapping({"/modifierEquipement"})
    public Equipement modifierEquipement(@RequestBody Equipement equipement) {
        return this.equipementService.modifierEquipement(equipement);
    }

    @DeleteMapping({"/supprimerEquipement/{idEquipement}"})
    public void supprimerEquipement(@PathVariable Long idEquipement) {
        this.equipementService.supprimerEquipement(idEquipement);
    }

    @Generated
    public EquipementController(final IEquipementService equipementService) {
        this.equipementService = equipementService;
    }
}
