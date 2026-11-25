package tn.esprit.autoloc.autoloc.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.autoloc.domain.Maintenance;
import tn.esprit.autoloc.autoloc.repository.MaintenanceRepository;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class IMaintenanceServiceImp implements IMaintenanceService{
    private final MaintenanceRepository maintenanceRepository;
    @Override
    public Maintenance ajouterMaintenance(Maintenance maintenance) {
        return maintenanceRepository.save(maintenance);
    }

    @Override
    public Maintenance modifierMaintenance(Maintenance maintenance) {
        return maintenanceRepository.save(maintenance);
    }

    @Override
    public List<Maintenance> afficherToutesMaintenance() {
        return maintenanceRepository.findAll();
    }

    @Override
    public Maintenance afficherMaintenanceById(long id) {
        return maintenanceRepository.findById(id).orElse(null);
    }

    @Override
    public void supprimerMaintenance(long id) { maintenanceRepository.deleteById(id); }

    @Override
    public List<Maintenance> retournerMaintenancesEntreDeuxDates(LocalDate date1, LocalDate date2) {
        return maintenanceRepository.findByDateFinBetween(date1, date2);
    }
}