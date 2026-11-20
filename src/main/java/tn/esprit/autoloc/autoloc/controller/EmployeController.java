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
import tn.esprit.autoloc.autoloc.domain.Employe;
import tn.esprit.autoloc.autoloc.service.IEmployeService;

@RestController
@RequestMapping({"/employes"})
public class EmployeController {
    private final IEmployeService employeService;

    @GetMapping({"/afficherToutesEmployes"})
    public List<Employe> getAllEmployes() {
        return this.employeService.afficherToutesEmployes();
    }

    @GetMapping({"/afficherEmployeById/{id}"})
    public Employe getEmployeById(@PathVariable Long id) {
        return this.employeService.afficherEmployeById(id);
    }

    @PostMapping({"/ajouterEmploye"})
    public Employe ajouterEmploye(@RequestBody Employe employe) {
        return this.employeService.ajouterEmploye(employe);
    }

    @PutMapping({"/modifierEmploye"})
    public Employe modifierEmploye(@RequestBody Employe employe) {
        return this.employeService.modifierEmploye(employe);
    }

    @DeleteMapping({"/supprimerEmploye"})
    public void supprimerEmploye(@RequestBody Employe employe) {
        this.employeService.supprimerEmploye(employe);
    }

    @Generated
    public EmployeController(final IEmployeService employeService) {
        this.employeService = employeService;
    }

    @PutMapping("/desaffecterEmploye/{idEmploye}")
    public Employe desaffecterEmploye(
            @PathVariable Long idEmploye) {
        return employeService.desaffecterEmploye(idEmploye);
    }

    @PutMapping("/affecterEmploye/{idEmploye}/{idAgence}")
    public Employe affecterEmploye(
            @PathVariable Long idEmploye,
            @PathVariable Long idAgence) {
        return employeService.affecterEmploye(idEmploye, idAgence);
    }
}
