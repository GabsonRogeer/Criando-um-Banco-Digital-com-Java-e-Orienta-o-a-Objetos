package desafioDioBanco.gbank.main;

import desafioDioBanco.gbank.entities.ContaBancaria;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.TimeZone;

public class Main {

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        Scanner scan = new Scanner(System.in);

        ContaBancaria c1 = new ContaBancaria();
        System.out.print("Informe o nome da pessoa: ");
        c1.getPessoa().setNome(scan.nextLine());

        System.out.print("Informe o CPF da pessoa: ");
        c1.getPessoa().setCpf(scan.nextLine());

        System.out.print("Informe a data de nascimento da pessoa: ");
        String dataNascimento = scan.nextLine();

        if(!dataNascimento.isEmpty()) {
            c1.getPessoa().setDataDeNascimento(simpleDateFormat.parse(dataNascimento));
        }

            System.out.println("Conta criada com sucesso!");

        System.out.println(c1.getPessoa());
        }
    }
