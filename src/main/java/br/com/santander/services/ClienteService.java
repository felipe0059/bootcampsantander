package br.com.santander.services;

import br.com.santander.dto.ClienteDTO;
import br.com.santander.models.Cliente;
import br.com.santander.models.Conta;
import br.com.santander.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Date;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public void save(ClienteDTO clienteDTO) {
        Cliente cliente = new Cliente();
        cliente.setNome(clienteDTO.getNome());
        cliente.setCpf(clienteDTO.getCpf());
    //criando uma conta automática para cada cliente gerado;
        Conta conta = new Conta();
        conta.setSaldo(0.0); //saldo inicial;
        conta.setNumero(new Date().getTime()); //no instante que a conta é gerada o numero é baseado no tempo.
        cliente.setConta(conta);
        repository.save(cliente);
    }
    //talvez seja a classe dto como parametro
    public Cliente update(Cliente cliente, String cpf) {
        cliente.setCpf(cpf);
        return repository.save(cliente);
    }

    public Cliente findByCpf(String cpf) {
        Optional<Cliente> obj = repository.findByCpf(cpf);
        return obj.get();
    }

    public void delete(String cpf) {
        repository.deleteByCpf(cpf);
    }
}
