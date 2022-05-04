package br.com.santander.services;

import br.com.santander.dto.ClienteDTO;
import br.com.santander.models.Cliente;
import br.com.santander.models.Conta;
import br.com.santander.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public void save(ClienteDTO clienteDTO) {
        Cliente cliente = new Cliente();
        cliente.setNome(cliente.getNome());
        cliente.setCpf(cliente.getCpf());
    //criando uma conta automática para cada cliente gerado;
        Conta conta = new Conta();
        conta.setSaldo(0.0); //saldo inicial;
        conta.setNumero(new Date().getTime()); //no instante que a conta é gerada o numero é baseado no tempo.
        cliente.setConta(conta);
        repository.save(cliente);
    }

}
