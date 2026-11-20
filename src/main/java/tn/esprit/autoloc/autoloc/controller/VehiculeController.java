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
}
