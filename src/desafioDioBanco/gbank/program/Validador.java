package desafioDioBanco.gbank.program;

import desafioDioBanco.gbank.entities.ContaBancaria;

import java.util.List;

public class Validador {

    public static boolean isPossivelCadastrarConta (ContaBancaria conta) {
        if(!validaDados(conta)){
            System.out.println("Não foi possível cadastrar a conta!");
            System.out.println("Por favor, refaça a operação.");
            return false;
        }
        return true;
    }
    public static boolean validaDados(ContaBancaria conta) {
        if(conta == null){
            System.out.println("Conta não foi preenchida");

            return false;
        }
        if (conta.getPessoa().getNome().isEmpty()) {
            System.out.println("Nome não foi preenchido.");

            return false;
        }
        if (conta.getPessoa().getCpf().isEmpty()){
            System.out.println("Cpf não foi informado.");
            return false;
        }
        if (conta.getPessoa().getDataDeNascimento() == null) {
            System.out.println("Data de nascimento não foi preenchido.");
            return false;
        }
        if (conta.getNumConta().isEmpty()){
            System.out.println("Número da conta não foi preenchido.");
            return false;
        }
        return true;
    }

    public static boolean isPossivelDepositar (double valor) {
        if(valor > 0) {
            return true;
        }
        else {
            System.out.println("Não foi possível realizar o depósito, verifique o valor informado!");
            return false;
        }
    }

    public static boolean isPossivelRealizarOperacoes (ContaBancaria conta, double valor) {
        if(valor <= conta.getSaldo()){
            return true;
        }
        else {
            System.out.println("Não foi possível realizar a operação, por favor, verifique o valor informado.");
            return false;
        }
    }

    public static boolean isPossivelSolicitarCartao (ContaBancaria conta) {
        if (conta.getSaldo() > 50){
            return true;
        }
        else {
            System.out.println("Não é possível solicitar um cartão! Verifique o seu tempo de conta.");
            return false;
        }
    }

    public static boolean isContaExistente (List<ContaBancaria> conta, String cpf){
        for (ContaBancaria c : conta){
            if (c.getPessoa().getCpf().equals(cpf)){
                return true;
                }
            }
        if(conta.isEmpty()){
            return false;
        }

        System.out.println("O Cpf informado não pertence a nenhuma conta!");
        return false;
    }

    public static boolean isPossivelGerarPix(ContaBancaria conta){
        try {
            if(!conta.getChavePix().isEmpty()){
                return false;
            }
        } catch (NullPointerException e) {
            //System.out.println("Chave pix já cadastrada, a sua chave é: "+ conta.getChavePix());
        }
        return true;
    }

}
