package com.example.servicodepagamento;

import com.example.servicodepagamento.entities.Contrato;
import com.example.servicodepagamento.entities.Parcelas;
import com.example.servicodepagamento.exceptions.MainException;
import com.example.servicodepagamento.services.PaypalServico;
import com.example.servicodepagamento.services.ServicoContrato;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

@SpringBootApplication
public class ServicoDePagamentoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServicoDePagamentoApplication.class, args);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        try {
            Scanner leitor = new Scanner(System.in);

            System.out.println("Entre com o dados do contrato. ");
            System.out.print("Numero do contrato: ");
            int numeroContrato = leitor.nextInt();
            System.out.print("Data do contrato: ");
            LocalDate dataContrato = LocalDate.parse(leitor.next(), dtf);
            System.out.print("Valor do contrato: ");
            double valorContrato = leitor.nextDouble();

            Contrato contrato = new Contrato(numeroContrato, dataContrato, valorContrato);
            System.out.print("Parcelas: ");
            int numeroParcelas = leitor.nextInt();


            ServicoContrato servico = new ServicoContrato(new PaypalServico());
            servico.processarContrato(contrato, numeroParcelas);

            System.out.println("Informacoes do contrato: ");
            System.out.println(contrato);
            for (Parcelas parc : contrato.getParcelas()) {
                System.out.print("Data de pagamento: ");
                System.out.println(parc);

            }

        } catch (MainException e) {
            System.out.println(e.getMessage());
        } catch (InputMismatchException e){
            System.out.println(e.getMessage());
        }



    }
}
