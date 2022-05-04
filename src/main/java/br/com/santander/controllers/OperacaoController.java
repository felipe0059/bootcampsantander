package br.com.santander.controllers;

import br.com.santander.dto.OperacaoDTO;
import br.com.santander.models.Operacao;
import br.com.santander.repositories.OperacaoRepository;
import br.com.santander.services.OperacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/operacoes")
public class OperacaoController {

    @Autowired
    OperacaoRepository repository;

    @Autowired
    OperacaoService service;

    @GetMapping
    public Page<Operacao> findAll (@PageableDefault(page = 0, size = 10, sort = "descricao", direction = Sort.Direction.ASC)
    Pageable pageable) {
        return repository.findAll(pageable);
    }

    @PostMapping
    public void save(@RequestBody OperacaoDTO operacao){
        service.save(operacao);
    }
}
