package desafioDioBanco;

import java.util.Random;

public abstract class Conta implements IConta {

    protected static final int AGENCIA_PADRAO = 1;
    //protected static int SEQUENCIAL = 1;
    protected static Cliente cliente;
    protected int agencia;
    protected String numConta;
    protected double saldo;

    public Conta(Cliente cliente) {
        Random random = new Random();
        this.agencia = AGENCIA_PADRAO;
        this.numConta = "" + random.nextInt(4) + "-" + random.nextInt(1);
        Conta.cliente = cliente;
    }

    @Override
    public void sacar(double valor) {
        saldo -= valor;
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;

    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
        this.sacar(valor);
        contaDestino.depositar(valor);
    }

    protected void imprimirInfosComuns() {
        System.out.println(String.format("Titular: %s", Cliente.cliente.getNome()));
        System.out.println(String.format("Cpf do Titular %s",cliente.getCpf()));
        System.out.println(String.format("Agencia: %d", this.agencia));
        System.out.println(String.format("Conta: %s", this.numConta));
        System.out.println(String.format("Saldo: %.2f", this.saldo));
    }

    public static Cliente getCliente() {
        return cliente;
    }

    public static void setCliente(Cliente cliente) {
        Conta.cliente = cliente;
    }

    public int getAgencia() {
        return agencia;
    }


    public String getNumConta() {
        return numConta;
    }

    public double getSaldo() {
        return saldo;
    }

}
