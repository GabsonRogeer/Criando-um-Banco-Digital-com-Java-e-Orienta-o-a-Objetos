package desafioDioBanco.gbank.interfaces;

import desafioDioBanco.gbank.entities.ContaBancaria;

import java.text.ParseException;

public interface Operacoes {

    public void sacar(ContaBancaria conta, double valor);

    public void depositar(ContaBancaria conta, double valor);

    void transferir(ContaBancaria conta, double valor, ContaBancaria contaDestino);

    public void solicitarCartao(ContaBancaria conta) throws ParseException;

    public void exibirDadosBancarios(ContaBancaria conta);

}

