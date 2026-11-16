package tn.esprit.autoloc.autoloc.service;


import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.autoloc.domain.Agence;
import tn.esprit.autoloc.autoloc.domain.Vehicule;
import tn.esprit.autoloc.autoloc.repository.AgenceRepository;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
@AllArgsConstructor
public class IAgenceServiceImp implements IAgenceService{

    /*@Autowired
    private AgenceRepository agenceRepository;*/
    private final AgenceRepository agenceRepository;

    @Override
    public Agence ajouterAgence(Agence agence) {
        return agenceRepository.save(agence);
    }

    @Override
    public Agence modifierAgence(Agence agence) {
        return agenceRepository.save(agence);
    }

    @Override
    public List<Agence> afficherToutesAgences() {
        return agenceRepository.findAll();
    }

    @Override
    public Agence afficherAgenceById(Long id) {
        return agenceRepository.findById(id).orElse(null) ;
    }

    @Override
    public void supprimerAgence(Long id) {
        agenceRepository.deleteById(id);

    }

    @Override
    @Transactional
    public Agence ajouterAgenceEtAffecterVehicules(Agence agence) {
        for (Vehicule vehicule : agence.getVehicules()) {
            vehicule.setAgence(agence);
        }
        return agenceRepository.save(agence);
    }

    @Scheduled(fixedDelay = 2, timeUnit = TimeUnit.MINUTES)
    public void suivreNombreAgences() {

        List<Agence> agences = agenceRepository.findAll();

        System.out.println("Nombre total des agences : " + agences.size());

        System.out.println("Date et heure : " + new Date());
    }

}