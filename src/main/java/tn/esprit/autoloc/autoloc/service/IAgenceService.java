package tn.esprit.autoloc.autoloc.service;

import org.springframework.stereotype.Repository;
import tn.esprit.autoloc.autoloc.domain.Agence;

import java.util.List;


public interface IAgenceService {
    Agence ajouterAgence(Agence agence);

    Agence modifierAgence(Agence agence);

    List<Agence> afficherToutesAgences();

    Agence afficherAgenceById(Long id);

    void supprimerAgence(Long id);
}
