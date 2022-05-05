package br.com.santander.repositories;

import br.com.santander.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, UUID> {

    void deleteByCpf(String cpf);

    Optional<Cliente> findByCpf(String cpf);
}
