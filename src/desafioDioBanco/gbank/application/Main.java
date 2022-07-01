package desafioDioBanco.gbank.application;

import desafioDioBanco.gbank.entities.ContaBancaria;
import desafioDioBanco.gbank.entities.GerenciadorContas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {

    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
        GerenciadorContas gerenciador = new GerenciadorContas();

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

                        gerenciador.criarConta(c1);

                        break;
                    case "2":
                        System.out.println("-> LISTAR CONTAS");

                        gerenciador.listarContas();

                        break;
                    case "3":
                        System.out.println("-> DADOS BANCÁRIOS");

                        System.out.print("Informe o CPF da pessoa: ");
                        String cpfDados = sc.nextLine();

                        gerenciador.dadosBancariosPeloCpf(cpfDados);

                        break;
                    case "4":
                        System.out.println("-> SALDO");

                        System.out.print("Informe o CPF da pessoa: ");
                        String cpfSaldo = sc.nextLine();

                        gerenciador.informarSaldo(cpfSaldo);
                        break;
                    case "5":
                        System.out.println("-> SOLICITAR CARTÃO");

                        System.out.print("Informe o CPF da pessoa: ");
                        String cpfCartao = sc.nextLine();

                        gerenciador.solicitarCartao(cpfCartao);

                        break;
                    case "6":
                        System.out.println("-> SAQUE");

                        System.out.print("Informe o CPF da pessoa: ");
                        String cpfSacar = sc.nextLine();

                        System.out.print("Informe o valor do saque: ");
                        Double valor = sc.nextDouble();

                        gerenciador.sacarPeloCpf(cpfSacar, valor);

                        break;
                    case "7":
                        System.out.println("-> DEPÓSITO");

                        System.out.print("Informe o CPF da pessoa: ");
                        String cpfDeposito = sc.nextLine();

                        System.out.print("Informe o valor do depósito: ");
                        Double valorDeposito = sc.nextDouble();

                        gerenciador.depositarPeloCpf(cpfDeposito, valorDeposito);

                        break;
                    case "8":
                        System.out.println("-> TRANSFERÊNCIA");

                        System.out.println();
                        System.out.println("Realizar depósito via CPF ou PIX? (c/p) :");
                        char ch = sc.next().charAt(0);
                        if(ch == 'c') {
                            System.out.print("Informe o CPF do depositante: ");
                            String cpfDepositante = sc.nextLine();
                            System.out.print("Informe o CPF do recebedor: ");
                            //sc.nextLine();
                            String cpfRecebedor = sc.nextLine();

                            System.out.print("Informe o valor do depósito: ");
                            Double valorT = sc.nextDouble();

                            gerenciador.transferirPeloCpf(cpfDepositante, cpfRecebedor, valorT);
                        }
                        else {
                            System.out.print("Informe o CPF do depositante: ");
                            String cpfDepositante = sc.nextLine();

                            System.out.print("Informe a ChavePix do recebedor: ");
                            String pixRecebedor = sc.nextLine();

                            System.out.print("Informe o valor do depósito: ");
                            Double valorpix = sc.nextDouble();

                            gerenciador.tranferirPeloPix(cpfDepositante, pixRecebedor, valorpix);
                        }

                        break;

                    case "9":
                        System.out.println("-> GERAR CHAVE ALEATÓRIA");
                        System.out.print("Informe o CPF da pessoa: ");
                        String cpfPix = sc.nextLine();

                        gerenciador.gerarChavePix(cpfPix);

                        break;
                    default:
                        break;
                }
            } while (!sair);
        }

    }
}
