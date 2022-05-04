package br.com.santander.controllers;

import br.com.santander.dto.ClienteDTO;
import br.com.santander.models.Cliente;
import br.com.santander.repositories.ClienteRepository;
import br.com.santander.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository repository;

    @Autowired //ponto de injeção da classe onde os métodos são implementados.
    private ClienteService service;

    @GetMapping
    public List<Cliente> findAll() {
        return repository.findAll();
    }

    @PostMapping
    public void save(@RequestBody ClienteDTO cliente) {
        service.save(cliente);
    }




}
