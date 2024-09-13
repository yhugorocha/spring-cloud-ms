package io.github.yhugorocha.msclients.controller;

import io.github.yhugorocha.msclients.dto.ClientDTO;
import io.github.yhugorocha.msclients.service.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clients")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    public ResponseEntity save(@RequestBody ClientDTO clientDTO){
        return ResponseEntity.created(clientService.save(clientDTO)).build();
    }

    @GetMapping(params = "cpf")
    public ResponseEntity findClient(@RequestParam("cpf") String cpf){
        return ResponseEntity.ok(clientService.getByCPF(cpf));
    }
}
