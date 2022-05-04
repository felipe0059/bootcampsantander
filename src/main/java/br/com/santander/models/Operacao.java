package br.com.santander.models;

import javax.persistence.*;
import java.util.UUID;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_operacao")
public class Operacao {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false)
    private LocalDateTime dataHora;
    @Column(nullable = false, unique = true, length = 7)
    private String descricao;
    @Column(nullable = false, length = 70)
    private Double valor;
    @Enumerated(EnumType.STRING)
    private TipoOperacao tipo_operacao;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public TipoOperacao getTipo_operacao() {
        return tipo_operacao;
    }

    public void setTipo_operacao(TipoOperacao tipo_operacao) {
        this.tipo_operacao = tipo_operacao;
    }
}
