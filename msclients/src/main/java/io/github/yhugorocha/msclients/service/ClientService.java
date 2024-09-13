package io.github.yhugorocha.msclients.service;

import io.github.yhugorocha.msclients.domain.Client;
import io.github.yhugorocha.msclients.dto.ClientDTO;
import io.github.yhugorocha.msclients.repository.ClientRepository;
import jakarta.ws.rs.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public URI save(ClientDTO client){
        var exists = this.clientRepository.findByCpf(client.cpf());
        if(exists.isPresent()){
            throw new RuntimeException("Customer is already registered in the system");
        }
        var newClient = new Client(client);
        this.clientRepository.save(newClient);

        URI headerLocation = ServletUriComponentsBuilder.fromCurrentRequest()
                .query("cpf={cpf}")
                .buildAndExpand(newClient.getCpf())
                .toUri();
        return headerLocation;
    }

    public Client getByCPF(String cpf){
        return this.clientRepository.findByCpf(cpf).orElseThrow(NotFoundException::new);
    }
}
