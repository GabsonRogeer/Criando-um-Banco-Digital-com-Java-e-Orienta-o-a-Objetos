package desafioDioBanco.gbank.entities;

import java.util.Date;
import java.util.Random;

public class ContaBancaria extends Instituicao {
    private String numConta;
    private boolean ativa;
    private Double saldo;
    private Cliente pessoa;
    private Date dataCriacao;
    private CartaoDigital cartaoCredito;
    private boolean possuiCredito;

    private String chavePix;

    public ContaBancaria(String numConta, boolean ativa, Double saldo, Cliente pessoa) {
        Random random = new Random();
        this.numConta = "" + random.nextInt(4) + "-" + random.nextInt(1);
        this.ativa = Boolean.TRUE;
        this.saldo = 0.0;
        this.pessoa = pessoa;
    }

    public ContaBancaria() {
        Random random = new Random();
        this.numConta = "" + random.nextInt(4) + "-" + random.nextInt(1);
        this.pessoa = new Cliente();
        this.saldo = 0.0;
        this.ativa = Boolean.TRUE;
    }

    public String getNumConta() {
        return numConta;
    }

    public void setNumConta(String numConta) {
        this.numConta = numConta;
    }

    public boolean isAtiva() {
        return ativa;
    }

    public void setAtiva(boolean ativa) {
        this.ativa = ativa;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Cliente getPessoa() {
        return pessoa;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public String getChavePix() {
        return chavePix;
    }

    public void setChavePix(String chavePix) {
        this.chavePix = chavePix;
    }

    public void setCartaoCredito(CartaoDigital cartaoCredito) {
        this.cartaoCredito = cartaoCredito;
    }

    public CartaoDigital getCartaoCredito() {
        return cartaoCredito;
    }

    public boolean isPossuiCredito() {
        return possuiCredito;
    }

    public void setPossuiCredito(boolean possuiCredito) {
        this.possuiCredito = possuiCredito;
    }
}
