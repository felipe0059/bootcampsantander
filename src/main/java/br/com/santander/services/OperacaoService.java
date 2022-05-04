package br.com.santander.services;

import br.com.santander.dto.OperacaoDTO;
import br.com.santander.models.Cliente;
import br.com.santander.models.Operacao;
import br.com.santander.models.TipoOperacao;
import br.com.santander.repositories.ClienteRepository;
import br.com.santander.repositories.OperacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class OperacaoService {

    @Autowired
    OperacaoRepository repository;

    @Autowired
    private ClienteRepository clienteRepository;

    public void save(OperacaoDTO operacaoDTO){
        Operacao operacao = new Operacao();
        Double valor = operacaoDTO.getValor();
        if(operacaoDTO.getTipo_operacao() == TipoOperacao.DESPESA)
           valor = valor * -1;

        operacao.setDataHora(LocalDateTime.now());
        operacao.setDescricao(operacaoDTO.getDescricao());
        operacao.setValor(operacaoDTO.getValor());
        operacao.setTipo_operacao(operacaoDTO.getTipo_operacao());

        Cliente cliente = clienteRepository.findById(operacaoDTO.getIdConta()).orElse(null);
        if(cliente != null) {
            cliente.getConta().setSaldo(cliente.getConta().getSaldo() + valor);
            clienteRepository.save(cliente);
        }

        repository.save(operacao);
    }
}
/* operador ternário
Double valor = operacaoDTO.getTipo_operacao()== TipoOperacao.RECEITA ? operacaoDTO.getValor() : operacaoDTO.getValor() * -1;
 */