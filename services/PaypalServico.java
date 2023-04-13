package com.example.servicodepagamento.services;

import com.example.servicodepagamento.interfaces.ServicoDePagamentoOnline;

import java.text.SimpleDateFormat;

public class PaypalServico implements ServicoDePagamentoOnline {

    @Override
    public double taxaDePagamento(Double valor) {
        return valor * 0.02;
    }

    @Override
    public double juros(Double valor, Integer meses) {
        return valor * 0.01 * meses;
    }
}

