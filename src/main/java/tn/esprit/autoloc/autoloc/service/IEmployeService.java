package tn.esprit.autoloc.autoloc.service;

import tn.esprit.autoloc.autoloc.domain.Employe;
import tn.esprit.autoloc.autoloc.domain.Paiement;

import java.util.List;

public interface IEmployeService {

    Employe ajouterEmploye(Employe employe);

    Employe modifierEmploye(Employe employe);

    List<Employe> afficherToutesEmployes();

    Employe afficherEmployeById(Long id);

    void supprimerEmploye(Employe employe);


}
