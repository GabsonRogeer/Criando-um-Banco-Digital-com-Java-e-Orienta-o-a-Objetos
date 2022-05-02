package desafioDioBanco.gbank.interfaces;

import desafioDioBanco.gbank.entities.ContaBancaria;

import java.text.ParseException;

public interface IConta {

    void sacar(ContaBancaria conta, double valor);

    void depositar(ContaBancaria conta, double valor);

    void transferir(ContaBancaria conta, double valor, ContaBancaria contaDestino);

    void solicitarCartao(ContaBancaria conta) throws ParseException;

    void exibirDadosBancarios(ContaBancaria conta);

    void imprimirExtrato();
}

