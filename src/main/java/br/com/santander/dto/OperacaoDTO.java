package br.com.santander.dto;

import br.com.santander.models.TipoOperacao;
import java.util.UUID;

public class OperacaoDTO {
    private String descricao;
    private Double valor;
    private UUID idConta;
    private TipoOperacao tipo_operacao;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public UUID getIdConta() {
        return idConta;
    }

    public void setIdConta(UUID idConta) {
        this.idConta = idConta;
    }

    public TipoOperacao getTipo_operacao() {
        return tipo_operacao;
    }

    public void setTipo_operacao(TipoOperacao tipo_operacao) {
        this.tipo_operacao = tipo_operacao;
    }
}
