package com.example.servicodepagamento.services;

import com.example.servicodepagamento.entities.Contrato;
import com.example.servicodepagamento.entities.Parcelas;
import com.example.servicodepagamento.interfaces.ServicoDePagamentoOnline;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ServicoContrato {
    static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private ServicoDePagamentoOnline servicoDePagamentoOnline;

    public ServicoContrato(ServicoDePagamentoOnline servicoDePagamentoOnline) {
        this.servicoDePagamentoOnline = servicoDePagamentoOnline;
    }

    public void processarContrato(Contrato contrato, int meses) {

        double parcelaBasica = contrato.getValorContrato() / meses;

        double total = 0;
        for (int i = 1; i <= meses; i++) {
            LocalDate dataVencimento = contrato.getDataDoContrato().plusMonths(i);

            double juros = servicoDePagamentoOnline.juros(parcelaBasica,i);
            double taxa = servicoDePagamentoOnline.taxaDePagamento(parcelaBasica + juros);
            double quota = parcelaBasica + juros + taxa;

            contrato.getParcelas().add(new Parcelas(dataVencimento,quota));
            total += quota;


        }

        contrato.setValorTotalDoContrato(total);
    }
}