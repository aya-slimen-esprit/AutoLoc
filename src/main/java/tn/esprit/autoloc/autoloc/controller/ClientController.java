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
import tn.esprit.autoloc.autoloc.domain.Client;
import tn.esprit.autoloc.autoloc.service.IClientService;

@RestController
@RequestMapping({"/clients"})
public class ClientController {
    private final IClientService clientService;

    @GetMapping({"/afficherToutesClients"})
    public List<Client> getAllClients() {
        return this.clientService.afficherToutesClients();
    }

    @GetMapping({"/afficherClientById/{id}"})
    public Client getClientById(@PathVariable Long id) {
        return this.clientService.afficherClientById(id);
    }

    @PostMapping({"/ajouterClient"})
    public Client ajouterClient(@RequestBody Client client) {
        return this.clientService.ajouterClient(client);
    }

    @PutMapping({"/modifierClient"})
    public Client modifierClient(@RequestBody Client client) {
        return this.clientService.modifierClient(client);
    }

    @DeleteMapping({"/supprimerClient/{idClient}"})
    public void supprimerClient(@PathVariable Long idClient) {
        this.clientService.supprimerClient(idClient);
    }

    @Generated
    public ClientController(final IClientService clientService) {
        this.clientService = clientService;
    }
}