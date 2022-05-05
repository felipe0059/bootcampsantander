package br.com.santander.controllers;

import br.com.santander.dto.OperacaoDTO;
import br.com.santander.models.Operacao;
import br.com.santander.repositories.OperacaoRepository;
import br.com.santander.services.OperacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/operacoes")
public class OperacaoController {

    @Autowired
    OperacaoRepository repository;

    @Autowired
    OperacaoService service;

    @GetMapping
    public List<Operacao> findAll(@PathVariable("IdConta") UUID IdConta){
        return repository.findByIdConta(IdConta);
    }

    @PostMapping
    public void save(@RequestBody OperacaoDTO operacao){
        service.save(operacao);
    }
}
