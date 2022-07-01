package teste;

import desafioDioBanco.gbank.entities.Cliente;
import desafioDioBanco.gbank.entities.ContaBancaria;
import desafioDioBanco.gbank.program.Validador;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidadorTest {

    /* ========== Montagem do cenário ========== */

    // criando cliente
    Cliente cliente1 = new Cliente("test", new Date(), "123.123.123-00");
    // criando uma conta bancária
    ContaBancaria conta = new ContaBancaria("0000-0", true, 0.0, cliente1 );

    @Test
    public void criarContaTest(){
        assertTrue(Validador.isPossivelCadastrarConta(conta));
    }

    @Test
    public void DepositoTest(){
        assertTrue(Validador.isPossivelDepositar(10.00));
    }

    @Test
    public void transferirTest(){
        conta.setSaldo(50.0);
        assertTrue(Validador.isPossivelRealizarOperacoes(conta, 10));
    }

    @Test
    public void testNaoExisteConta() {
        List<ContaBancaria> contas = new ArrayList<>();

        assertFalse(Validador.isContaExistente(contas, "111-111-111-11"));
    }



}
