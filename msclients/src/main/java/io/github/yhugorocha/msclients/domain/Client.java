package io.github.yhugorocha.msclients.domain;

import io.github.yhugorocha.msclients.dto.ClientDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String cpf;
    private String name;
    private Integer age;

    public Client(ClientDTO client) {
        this.cpf = client.cpf();
        this.name = client.name();
        this.age = client.age();
    }
}
