package tn.esprit.autoloc.autoloc.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.autoloc.domain.Agence;
import tn.esprit.autoloc.autoloc.service.IAgenceService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/agences")
public class AgenceController {
    private final IAgenceService agenceService;

    @GetMapping("/afficherTouteAgences")
    public List<Agence> getAllAgence(){
        return agenceService.afficherToutesAgences();
    }

    @GetMapping("/afficherAgenceById/{id}")
    public Agence getAgenceById(@PathVariable Long id){
        return agenceService.afficherAgenceById(id);
    }

    @PostMapping("/ajouterAgence")
    public Agence ajouterAgence(@RequestBody Agence agence){
        return agenceService.ajouterAgence(agence);
    }

    @PutMapping("/modifierAgence")
    public Agence modifierAgence(@RequestBody Agence agence){
        return agenceService.modifierAgence(agence);
    }

    @DeleteMapping("/supprimerAgence/{idAgence}")
    public void supprimerAgence(@PathVariable Long idAgence){
        agenceService.supprimerAgence(idAgence);
    }

    @PostMapping("/ajouterAgenceEtAffecterVehicules")
    public Agence ajouterAgenceEtAffecterVehicules(
            @RequestBody Agence agence) {
        return agenceService.ajouterAgenceEtAffecterVehicules(agence);
    }
}