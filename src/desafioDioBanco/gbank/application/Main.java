package desafioDioBanco.gbank.application;

import desafioDioBanco.gbank.entities.ContaBancaria;
import desafioDioBanco.gbank.program.Transacoes;
import desafioDioBanco.gbank.program.Validador;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
        Transacoes transacoes = new Transacoes();
        List<ContaBancaria> contas = new ArrayList<>();

        try (Scanner sc = new Scanner(System.in)) {
            String opcao = "";
            boolean sair = false;
            System.out.println("*------------------------------------------------------------*");
            System.out.println("|                    Bem vindo ao GBank!                     |");
            System.out.println("|Aqui é possível: criar conta, depositar, sacar e transferir.|");
            System.out.println("*------------------------------------------------------------*");
            do {
                System.out.println("*------------------------------------------------------------*");
                System.out.println("|0 - Sair                                                    |");
                System.out.println("|1 - Criar Conta                                             |");
                System.out.println("|2 - Listar Todas as Contas                                  |");
                System.out.println("|3 - Exibir Dados Bancários pelo CPF                         |");
                System.out.println("|4 - Visualizar Saldo Pelo CPF                               |");
                System.out.println("|5 - Solicitar Cartão de Crédito                             |");
                System.out.println("|6 - Sacar                                                   |");
                System.out.println("|7 - Depositar                                               |");
                System.out.println("|8 - Transferir                                              |");
                System.out.println("|9 - Gerar Chave Pix (Aleatória)                             |");
                System.out.println("*------------------------------------------------------------*");

                System.out.print("Informe a opção: ");
                opcao = sc.nextLine();

                switch (opcao) {
                    case "0":
                        System.out.println("*------------------------------------------------------------*");
                        System.out.println("|ENCERRADANDO APLICAÇÃO...                                   |");
                        System.out.println("|OBRIGADO!                                                   |");
                        System.out.println("*------------------------------------------------------------*");
                        sair = true;

                        break;
                    case "1":
                        System.out.println("-> CRIAR CONTA");

                        ContaBancaria c1 = new ContaBancaria();
                        System.out.print("Informe o nome da pessoa: ");
                        c1.getPessoa().setNome(sc.nextLine());

                        System.out.print("Informe o CPF da pessoa: ");
                        c1.getPessoa().setCpf(sc.nextLine());

                        System.out.print("Informe a data de nascimento da pessoa (dd/mm/yyyy): ");
                        String dataNascimento = sc.nextLine();

                        if (!dataNascimento.isEmpty()) {
                            c1.getPessoa().setDataDeNascimento(sdf.parse(dataNascimento));
                        }

                        if (Validador.isPossivelCadastrarConta(c1)) {
                            contas.add(c1);

                            System.out.println("Conta criada com sucesso!");
                        }

                        break;
                    case "2":
                        System.out.println("-> LISTAR CONTAS");

                        if (!contas.isEmpty()) {
                            for (ContaBancaria conta : contas) {
                                System.out.println("Número:" + conta.getNumConta() + "Agência: " + conta.getCodigo());
                            }
                        }

                        break;
                    case "3":
                        System.out.println("-> DADOS BANCÁRIOS");

                        System.out.print("Informe o CPF da pessoa: ");
                        String cpfDados = sc.nextLine();

                        if (Validador.isContaExistente(contas, cpfDados)) {
                            for (ContaBancaria conta : contas) {
                                if (conta.getPessoa().getCpf().equals(cpfDados)) {
                                    transacoes.exibirDadosBancarios(conta);
                                }
                            }
                        }

                        break;
                    case "4":
                        System.out.println("-> SALDO");

                        System.out.print("Informe o CPF da pessoa: ");
                        String cpfSaldo = sc.nextLine();

                        if (Validador.isContaExistente(contas, cpfSaldo)) {
                            for (ContaBancaria conta : contas) {
                                if (conta.getPessoa().getCpf().equals(cpfSaldo)) {
                                    System.out.println("O saldo é de: " + conta.getSaldo());
                                }
                            }
                        }
                        break;
                    case "5":
                        System.out.println("-> SOLICITAR CARTÃO");

                        System.out.print("Informe o CPF da pessoa: ");
                        String cpfCartao = sc.nextLine();

                        if (Validador.isContaExistente(contas, cpfCartao)) {
                            for (ContaBancaria conta : contas) {
                                if (conta.getPessoa().getCpf().equals(cpfCartao)) {
                                    transacoes.solicitarCartao(conta);
                                }
                            }
                        }

                        break;
                    case "6":
                        System.out.println("-> SAQUE");

                        System.out.print("Informe o CPF da pessoa: ");
                        String cpfSacar = sc.nextLine();

                        if (Validador.isContaExistente(contas, cpfSacar)) {
                            String valor;

                            System.out.print("Informe o valor do saque: ");
                            valor = sc.nextLine();

                            for (ContaBancaria conta : contas) {
                                if (conta.getPessoa().getCpf().equals(cpfSacar)) {
                                    transacoes.sacar(conta, Double.parseDouble(valor));
                                }
                            }
                        }

                        break;
                    case "7":
                        System.out.println("-> DEPÓSITO");

                        System.out.print("Informe o CPF da pessoa: ");
                        String cpfDeposito = sc.nextLine();

                        if (Validador.isContaExistente(contas, cpfDeposito)) {
                            String valor;

                            System.out.print("Informe o valor do depósito: ");
                            valor = sc.nextLine();

                            try {
                                for (ContaBancaria conta : contas) {
                                    if (conta.getPessoa().getCpf().equals(cpfDeposito)) {
                                        transacoes.depositar(conta, Double.parseDouble(valor));
                                    }
                                }
                            } catch (NumberFormatException e){
                                System.out.println("Insira '.'(ponto) no lugar da ','(virgula)");
                            }
                        }

                        break;
                    case "8":
                        System.out.println("-> TRANSFERÊNCIA");

                        System.out.print("Informe o CPF do depositante: ");
                        String cpfDepositante = sc.nextLine();

                        System.out.println("Realizar depósito via CPF ou PIX? (c/p) :");
                        char ch = sc.next().charAt(0);
                        if(ch == 'c') {
                            System.out.print("Informe o CPF do recebedor: ");
                            sc.nextLine();
                            String cpfRecebedor = sc.nextLine();

                            if (Validador.isContaExistente(contas, cpfDepositante)
                                    && Validador.isContaExistente(contas, cpfRecebedor)) {
                                ContaBancaria contaDepositante = null, contaRecebedor = null;
                                String valor;

                                System.out.print("Informe o valor do depósito: ");
                                valor = sc.nextLine();

                                for (ContaBancaria conta : contas) {
                                    if (conta.getPessoa().getCpf().equals(cpfDepositante)) {
                                        contaDepositante = conta;
                                    } else if (conta.getPessoa().getCpf().equals(cpfRecebedor)) {
                                        contaRecebedor = conta;
                                    }
                                }
                                transacoes.transferir(contaDepositante, Double.parseDouble(valor), contaRecebedor);
                            }
                        }
                        else {
                            System.out.print("Informe a ChavePix do recebedor: ");
                            sc.nextLine();
                            String pixRecebedor = sc.nextLine();

                            if (Validador.isContaExistente(contas, cpfDepositante)
                                    && Validador.isContaExistente(contas, pixRecebedor)) {
                                ContaBancaria contaDepositante = null, contaRecebedor = null;
                                String valor;

                                System.out.print("Informe o valor do depósito: ");
                                valor = sc.nextLine();

                                for (ContaBancaria conta : contas) {
                                    if (conta.getPessoa().getCpf().equals(cpfDepositante)) {
                                        contaDepositante = conta;
                                    } else if (conta.getChavePix().equals(pixRecebedor)) {
                                        contaRecebedor = conta;
                                    }
                                }
                                transacoes.transferir(contaDepositante, Double.parseDouble(valor), contaRecebedor);
                            }
                        }

                        break;

                    case "9":
                        System.out.println("-> GERAR CHAVE ALEATÓRIA");
                        System.out.print("Informe o CPF da pessoa: ");
                        String chavePix = sc.nextLine();

                        if (Validador.isContaExistente(contas, chavePix)) {

                            for (ContaBancaria conta : contas) {
                                if (conta.getPessoa().getCpf().equals(chavePix)) {
                                    transacoes.gerarChavePix(conta, 12);
                                }
                            }
                        }

                        break;
                    default:
                        break;
                }
            } while (!sair);

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

}
