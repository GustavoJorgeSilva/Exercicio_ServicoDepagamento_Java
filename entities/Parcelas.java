package com.example.servicodepagamento.entities;

import com.example.servicodepagamento.exceptions.MainException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Parcelas {
    private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private LocalDate dataVencimento;
    private Double valorParcela;

    public Parcelas() {

    }

    public Parcelas(LocalDate dataVencimento, Double valorParcela) {
        this.dataVencimento = dataVencimento;
        this.valorParcela = valorParcela;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public Double getValorParcela() {
        return valorParcela;
    }

    public void setValorParcela(Double valorParcela) {
        valorParcela = valorParcela;
    }

    @Override
    public String toString() {
        return dataVencimento.format(dtf) + " - " + " valor a ser pago: " + String.format("%.2f", valorParcela);
    }
}

