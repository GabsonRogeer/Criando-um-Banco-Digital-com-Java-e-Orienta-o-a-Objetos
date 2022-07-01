package desafioDioBanco.gbank.entities;

import desafioDioBanco.gbank.program.Transacoes;
import desafioDioBanco.gbank.program.Validador;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class GerenciadorContas {

    Transacoes transacoes = new Transacoes();
    List<ContaBancaria> contas = new ArrayList<>();

    public GerenciadorContas(List<ContaBancaria> contas) {
        this.contas = contas;
    }

    public GerenciadorContas(){
    }

    public void criarConta(ContaBancaria c1){
        if (Validador.isPossivelCadastrarConta(c1)) {
            contas.add(c1);

            System.out.println("Conta criada com sucesso!");
        }
    }
    /*
     * Retorna uma lista com todos os clientes do banco.
     * @return lista com todos os clientes do banco
     */
    public void listarContas () {
        if (!contas.isEmpty()) {
            for (ContaBancaria conta : contas) {
                System.out.println("Número:" + conta.getNumConta() + "Agência: " + conta.getCodigo());
            }
        }
    }

    public void dadosBancariosPeloCpf (String cpf){
        if (Validador.isContaExistente(contas, cpf)) {
            for (ContaBancaria conta : contas) {
                if (conta.getPessoa().getCpf().equals(cpf)) {
                    transacoes.exibirDadosBancarios(conta);
                }
            }
        }
    }

    public void informarSaldo (String cpf){
        if (Validador.isContaExistente(contas, cpf)) {
            for (ContaBancaria conta : contas) {
                if (conta.getPessoa().getCpf().equals(cpf)) {
                    System.out.println("O saldo é de: " + conta.getSaldo());
                }
            }
        }
    }

    public void solicitarCartao (String cpfCartao) throws ParseException {
        if (Validador.isContaExistente(contas, cpfCartao)) {
            for (ContaBancaria conta : contas) {
                if (conta.getPessoa().getCpf().equals(cpfCartao)) {
                    transacoes.solicitarCartao(conta);
                }
            }
        }
    }

    public void sacarPeloCpf (String cpfSacar, Double valor) {
        if (Validador.isContaExistente(contas, cpfSacar)) {

            for (ContaBancaria contaBancaria : contas) {
                if (contaBancaria.getPessoa().getCpf().equals(cpfSacar)) {
                    transacoes.sacar(contaBancaria, valor);
                }
            }
        }
    }

    public void depositarPeloCpf (String cpfDeposito, Double valor ) {
        if (Validador.isContaExistente(contas, cpfDeposito)) {
            try {
                for (ContaBancaria conta : contas) {
                    if (conta.getPessoa().getCpf().equals(cpfDeposito)) {
                        transacoes.depositar(conta, valor);
                    }
                }
            } catch (NumberFormatException e){
                System.out.println("Insira '.'(ponto) no lugar da ','(virgula)");
            }
        }
    }

    public void transferirPeloCpf (String cpfDepositante, String cpfRecebedor, Double valor){
        if (Validador.isContaExistente(contas, cpfDepositante)
                && Validador.isContaExistente(contas, cpfRecebedor)) {
            ContaBancaria contaDepositante = null, contaRecebedor = null;

            for (ContaBancaria conta : contas) {
                if (conta.getPessoa().getCpf().equals(cpfDepositante)) {
                    contaDepositante = conta;
                } else if (conta.getPessoa().getCpf().equals(cpfRecebedor)) {
                    contaRecebedor = conta;
                }
            }
            transacoes.transferir(contaDepositante, valor, contaRecebedor);
        }
    }

    public void tranferirPeloPix (String cpfDepositante, String pixRecebedor, Double valor) {

            /*System.out.print("Informe a ChavePix do recebedor: ");
            sc.nextLine();
            String pixRecebedor = sc.nextLine();*/

            /*String valor;

            System.out.print("Informe o valor do depósito: ");
            valor = sc.nextLine();*/

            if (Validador.isContaExistente(contas, cpfDepositante)
                    && Validador.isContaExistente(contas, pixRecebedor)) {
                ContaBancaria contaDepositante = null, contaRecebedor = null;


                for (ContaBancaria conta : contas) {
                    if (conta.getPessoa().getCpf().equals(cpfDepositante)) {
                        contaDepositante = conta;
                    } else if (conta.getChavePix().equals(pixRecebedor)) {
                        contaRecebedor = conta;
                    }
                }
                transacoes.transferir(contaDepositante, valor, contaRecebedor);
            }

    }

    public void gerarChavePix (String cpfPix){
        if (Validador.isContaExistente(contas, cpfPix)) {

            for (ContaBancaria conta : contas) {
                if (conta.getPessoa().getCpf().equals(cpfPix)) {
                    transacoes.gerarChavePix(conta, 12);
                }
            }
        }
    }
}

