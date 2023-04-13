package com.example.servicodepagamento.interfaces;

public interface ServicoDePagamentoOnline {

    public abstract double taxaDePagamento(Double valor);
    public abstract double juros(Double valor, Integer meses);

}
