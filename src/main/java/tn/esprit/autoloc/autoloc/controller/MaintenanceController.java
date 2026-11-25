//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package tn.esprit.autoloc.autoloc.controller;

import java.time.LocalDate;
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
import tn.esprit.autoloc.autoloc.domain.Maintenance;
import tn.esprit.autoloc.autoloc.service.IMaintenanceService;

@RestController
@RequestMapping({"/maintenances"})
public class MaintenanceController {
    private final IMaintenanceService maintenanceService;

    @GetMapping({"/afficherToutesMaintenances"})
    public List<Maintenance> getAllMaintenances() {
        return this.maintenanceService.afficherToutesMaintenance();
    }

    @GetMapping({"/afficherMaintenanceById/{id}"})
    public Maintenance getMaintenanceById(@PathVariable Long id) {
        return this.maintenanceService.afficherMaintenanceById(id);
    }

    @PostMapping({"/ajouterMaintenance"})
    public Maintenance ajouterMaintenance(@RequestBody Maintenance maintenance) {
        return this.maintenanceService.ajouterMaintenance(maintenance);
    }

    @PutMapping({"/modifierMaintenance"})
    public Maintenance modifierMaintenance(@RequestBody Maintenance maintenance) {
        return this.maintenanceService.modifierMaintenance(maintenance);
    }

    @DeleteMapping({"/supprimerMaintenance/{idMaintenance}"})
    public void supprimerMaintenance(@PathVariable Long idMaintenance) {
        this.maintenanceService.supprimerMaintenance(idMaintenance);
    }

    @Generated
    public MaintenanceController(final IMaintenanceService maintenanceService) {
        this.maintenanceService = maintenanceService;
    }

    @GetMapping("/afficherEntreDeuxDates/{date1}/{date2}")
    public List<Maintenance> afficherEntreDeuxDates(
            @PathVariable LocalDate date1,
            @PathVariable LocalDate date2) {

        return maintenanceService.retournerMaintenancesEntreDeuxDates(date1, date2);
    }
}