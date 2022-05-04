package br.com.santander.models;

import javax.persistence.*;

@Embeddable
@Table(name = "tb_conta")
public class Conta {

    private static final long serialVersionUID = 1L;

    @Column
    private Long numero;
    @Column
    private Double saldo;

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }
}
