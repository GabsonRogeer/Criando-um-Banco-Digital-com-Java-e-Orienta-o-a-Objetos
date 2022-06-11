package desafioDioBanco.gbank.program;

import desafioDioBanco.gbank.entities.CartaoDigital;
import desafioDioBanco.gbank.entities.ContaBancaria;
import desafioDioBanco.gbank.interfaces.Operacoes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

public class Transacoes implements Operacoes {

    @Override
    public void sacar(ContaBancaria conta, double valor) {
        if (Validador.isPossivelRealizarOperacoes(conta, valor)) {
            double novoSaldo = conta.getSaldo() - valor;
            conta.setSaldo(novoSaldo);
            System.out.println("Você sacou: R$ " + valor);
        }
    }

    @Override
    public void depositar(ContaBancaria conta, double valor) {
        if(Validador.isPossivelDepositar(valor)){
            double novoSaldo = conta.getSaldo() + valor;
            conta.setSaldo(novoSaldo);

            System.out.println("Você depositou: R$ " + valor);
        }

    }

    @Override
    public void transferir(ContaBancaria conta, double valor, ContaBancaria contaDestino) {
        if(Validador.isPossivelRealizarOperacoes(conta, valor)){
            sacar(conta, valor);
            depositar(contaDestino, valor);

            System.out.println("Transferencia realizada no valor de: R$"
                    + valor + " Para: "
                    + contaDestino.getPessoa().getNome() );
            System.out.println("O Saldo atual de sua conta é: R$"+ conta.getSaldo());
        }
    }

    @Override
    public void solicitarCartao(ContaBancaria conta) throws ParseException {
        if (Validador.isPossivelSolicitarCartao(conta)){
            CartaoDigital cartaoDigital = new CartaoDigital();
            conta.setCartaoCredito(cartaoDigital);

            System.out.println("Cartão Digital solicitado com sucesso!");
        }
    }

    @Override
    public void exibirDadosBancarios(ContaBancaria conta) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        System.out.println("Nome: " + conta.getPessoa().getNome());
        System.out.println("CPF: " + conta.getPessoa().getCpf());
        System.out.println("Data de Nascimento: " + sdf.format(conta.getPessoa().getDataDeNascimento()));
        System.out.println("Banco: " + conta.getNome());
        System.out.println("Agência: " + conta.getCodigo());
        System.out.println("Nº da Conta: " + conta.getNumConta());
        if(conta.getChavePix() == null){
            System.out.println("Chave pix: Chave ainda não cadastrada");
        }
        else {
            System.out.println("Chave pix: " + conta.getChavePix());
        }
    }

    @Override
    public void gerarChavePix(ContaBancaria conta, Integer n) {
        /*int lowerLimit = 97;
        int upperLimit = 122;
        n = 12;
        Random random = new Random();
        StringBuffer r = new StringBuffer(n);
        for (int i = 0; i < n; i++) {
            int nextRandomChar = lowerLimit
                    + (int)(random.nextFloat()
                    * (upperLimit - lowerLimit + 1));
            r.append((char)nextRandomChar);
        }
        conta.setChavePix(r.toString());*/

        if (Validador.isPossivelGerarPix(conta)) {
            String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                    + "0123456789"
                    + "abcdefghijklmnopqrstuvxyz";
            StringBuilder sb = new StringBuilder(n);

            for (int i = 0; i < n; i++) {
                int index = (int) (AlphaNumericString.length()
                        * Math.random());
                sb.append(AlphaNumericString
                        .charAt(index));
            }
            conta.setChavePix(sb.toString());

            System.out.println("Sua nova chave é: " + conta.getChavePix());
        }
        else {
            System.out.println("Chave pix já cadastrada, a sua chave é: " + conta.getChavePix());
        }
    }
}
