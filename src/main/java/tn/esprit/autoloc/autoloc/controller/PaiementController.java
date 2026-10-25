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
import tn.esprit.autoloc.autoloc.domain.Paiement;
import tn.esprit.autoloc.autoloc.service.IPaiementService;

@RestController
@RequestMapping({"/paiements"})
public class PaiementController {
    private final IPaiementService paiementService;

    @GetMapping({"/afficherToutesPaiements"})
    public List<Paiement> getAllPaiements() {
        return this.paiementService.afficherToutesPaiements();
    }

    @GetMapping({"/afficherPaiementById/{id}"})
    public Paiement getPaiementById(@PathVariable Long id) {
        return this.paiementService.afficherPaiementById(id);
    }

    @PostMapping({"/ajouterPaiement"})
    public Paiement ajouterPaiement(@RequestBody Paiement paiement) {
        return this.paiementService.ajouterPaiement(paiement);
    }

    @PutMapping({"/modifierPaiement"})
    public Paiement modifierPaiement(@RequestBody Paiement paiement) {
        return this.paiementService.modifierPaiement(paiement);
    }

    @DeleteMapping({"/supprimerPaiement/{idPaiement}"})
    public void supprimerPaiement(@PathVariable Long idPaiement) {
        this.paiementService.supprimerPaiement(idPaiement);
    }

    @Generated
    public PaiementController(final IPaiementService paiementService) {
        this.paiementService = paiementService;
    }
}
