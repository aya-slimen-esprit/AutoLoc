package tn.esprit.autoloc.autoloc.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.autoloc.domain.Agence;
import tn.esprit.autoloc.autoloc.domain.Employe;
import tn.esprit.autoloc.autoloc.repository.AgenceRepository;
import tn.esprit.autoloc.autoloc.repository.EmployeRepository;

import java.util.List;
@Service
@AllArgsConstructor
public class IEmployeServiceImp implements IEmployeService {

    private final EmployeRepository employeRepository;

    @Override
    public Employe ajouterEmploye(Employe employe) {
        return employeRepository.save(employe);
    }

    @Override
    public Employe modifierEmploye(Employe employe) {
        return employeRepository.save(employe);
    }

    @Override
    public List<Employe> afficherToutesEmployes() {
        return employeRepository.findAll();
    }

    @Override
    public Employe afficherEmployeById(Long id) {
        return employeRepository.findById(id).orElse(null);
    }

    @Override
    public void supprimerEmploye(Employe employe) {
        employeRepository.delete(employe);

    }

    private final AgenceRepository agenceRepository;

    @Override
    @Transactional
    public Employe affecterEmploye(Long idEmploye, Long idAgence) {
        Employe employe = employeRepository.findById(idEmploye)
                .orElseThrow(() -> new EntityNotFoundException("Employé introuvable : " + idEmploye));
        Agence agence = agenceRepository.findById(idAgence)
                .orElseThrow(() -> new EntityNotFoundException("Agence introuvable : " + idAgence));
        employe.setAgence(agence);
        return employeRepository.save(employe);
    }

    @Override
    @Transactional
    public Employe desaffecterEmploye(Long idEmploye) {
        Employe employe = employeRepository.findById(idEmploye)
                .orElseThrow(() -> new EntityNotFoundException("Employé introuvable : " + idEmploye));
        employe.setAgence(null);
        return employeRepository.save(employe);
    }
}
