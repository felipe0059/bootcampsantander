package br.com.santander.repositories;

import br.com.santander.models.Operacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface OperacaoRepository extends JpaRepository<Operacao, UUID> {
}
