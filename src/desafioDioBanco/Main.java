package desafioDioBanco;

public class Main {

    public static void main(String[] args) {

        Cliente gabson = new Cliente();
        gabson.setNome("Gabson Roger");
        gabson.setCpf("600.000.000");
        gabson.setDataDeNascimento();

        Conta cc = new ContaCorrente(gabson);
        Conta poupanca = new ContaPoupanca(gabson);

        cc.depositar(150);
        cc.transferir(100, poupanca);

        cc.imprimirExtrato();
        poupanca.imprimirExtrato();
    }
}