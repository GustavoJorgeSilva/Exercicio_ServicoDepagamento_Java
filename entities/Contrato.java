package com.example.servicodepagamento.entities;

import com.example.servicodepagamento.exceptions.MainException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Contrato {

    private int numeroDoContrato;
    private LocalDate dataDoContrato;
    private double valorTotalDoContrato;
    private double valorContrato;

    private List<Parcelas> parcelas = new ArrayList<>();

    public Contrato() {
    }

    public Contrato(int numeroDoContrato, LocalDate dataDoContrato, double valorContrato) {
        if (valorContrato <= 0) {
            throw new MainException("Valor do contrato invalido.");
        } else if (dataDoContrato.isBefore(LocalDate.now())) {
            throw new MainException("A data do contrato não pode ser anterior a hoje.");
        } else {
            this.numeroDoContrato = numeroDoContrato;
            this.dataDoContrato = dataDoContrato;
            this.valorContrato = valorContrato;
        }

    }

    public int getNumeroDoContrato() {
        return numeroDoContrato;
    }

    public void setNumeroDoContrato(int numeroDoContrato) {
        this.numeroDoContrato = numeroDoContrato;
    }

    public LocalDate getDataDoContrato() {
        return dataDoContrato;
    }

    public void setDataDoContrato(LocalDate dataDoContrato) {
        this.dataDoContrato = dataDoContrato;
    }

    public double getValorTotalDoContrato() {
        return valorTotalDoContrato;
    }

    public void setValorTotalDoContrato(double valorTotalDoContrato) {
        this.valorTotalDoContrato = valorTotalDoContrato;
    }

    public double getValorContrato() {
        return valorContrato;
    }

    public void setValorContrato(double valorContrato) {
        this.valorContrato = valorContrato;
    }

    public List<Parcelas> getParcelas() {
        return parcelas;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Numero do contrato:" + numeroDoContrato + "\n");
        sb.append("valor total do contrato: " + String.format("%.2f", valorTotalDoContrato));

        return sb.toString();
    }
}
