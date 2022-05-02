package desafioDioBanco.gbank.program;

import desafioDioBanco.gbank.entities.ContaBancaria;
import desafioDioBanco.gbank.interfaces.IConta;

import java.text.ParseException;

public class Operacoes implements IConta {

    @Override
    public void sacar(ContaBancaria conta, double valor) {
        double novoSaldo = conta.getSaldo() - valor;
        conta.setSaldo(novoSaldo);
        System.out.println("Você sacou: R$ " + valor);

    }

    @Override
    public void depositar(ContaBancaria conta, double valor) {

    }

    @Override
    public void transferir(ContaBancaria conta, double valor, ContaBancaria contaDestino) {

    }

    @Override
    public void solicitarCartao(ContaBancaria conta) throws ParseException {

    }

    @Override
    public void exibirDadosBancarios(ContaBancaria conta) {

    }

    @Override
    public void imprimirExtrato() {

    }
}
