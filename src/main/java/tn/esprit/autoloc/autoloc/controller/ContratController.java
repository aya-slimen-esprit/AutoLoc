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
import tn.esprit.autoloc.autoloc.domain.Contrat;
import tn.esprit.autoloc.autoloc.service.IContratService;

@RestController
@RequestMapping({"/contrats"})
public class ContratController {
    private final IContratService contratService;

    @GetMapping({"/afficherToutesContrats"})
    public List<Contrat> getAllContrats() {
        return this.contratService.afficherToutesContrat();
    }

    @GetMapping({"/afficherContratById/{id}"})
    public Contrat getContratById(@PathVariable Long id) {
        return this.contratService.afficherContratById(id);
    }

    @PostMapping({"/ajouterContrat"})
    public Contrat ajouterContrat(@RequestBody Contrat contrat) {
        return this.contratService.ajouterContrat(contrat);
    }

    @PutMapping({"/modifierContrat"})
    public Contrat modifierContrat(@RequestBody Contrat contrat) {
        return this.contratService.modifierContrat(contrat);
    }

    @DeleteMapping({"/supprimerContrat/{idContrat}"})
    public void supprimerContrat(@PathVariable Long idContrat) {
        this.contratService.supprimerContrat(idContrat);
    }

    @Generated
    public ContratController(final IContratService contratService) {
        this.contratService = contratService;
    }
}
