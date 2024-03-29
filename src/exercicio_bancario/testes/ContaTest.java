package exercicio_bancario.testes;

import static org.junit.Assert.*;
import org.junit.Test;

import exercicio_bancario.*;

public class ContaTest {

    @Test
    public void testTransferenciaContaCorrente() {
        ContaCorrente contaOrigem = new ContaCorrente(123, 200.0);
        ContaCorrente contaDestino = new ContaCorrente(456, 100.0);
        assertTrue(contaOrigem.transferencia(contaDestino, 50.0));
        assertEquals(150.0, contaOrigem.getSaldo(), 0.0);
        assertEquals(150.0, contaDestino.getSaldo(), 0.0);
        assertFalse(contaOrigem.transferencia(contaDestino, 300.0));
    }

    @Test
    public void testSaqueContaEspecial() {
        ContaEspecial conta = new ContaEspecial(123, 200.0, 100.0);
        assertTrue(conta.saque(250.0));
        assertEquals(-50.0, conta.getSaldo(), 0.0);
    }

    @Test
    public void testTransferenciaContaEspecial() {
        ContaEspecial contaOrigem = new ContaEspecial(123, 200.0, 100.0);
        ContaEspecial contaDestino = new ContaEspecial(456, 100.0, 100.0);
        assertTrue(contaOrigem.transferencia(contaDestino, 300.0));
        assertEquals(-100.0, contaOrigem.getSaldo(), 0.0);
        assertEquals(400.0, contaDestino.getSaldo(), 0.0);
    }

    @Test
    public void testSaqueContaPoupanca() {
        ContaPoupanca conta = new ContaPoupanca(123, 200.0);
        assertTrue(conta.saque(50.0));
        assertEquals(150.0, conta.getSaldo(), 0.0);
    }

    @Test
    public void testTransferenciaContaPoupanca() {
        ContaPoupanca contaOrigem = new ContaPoupanca(123, 200.0);
        ContaPoupanca contaDestino = new ContaPoupanca(456, 100.0);
        assertTrue(contaOrigem.transferencia(contaDestino, 50.0));
        assertEquals(150.0, contaOrigem.getSaldo(), 0.0);
        assertEquals(150.0, contaDestino.getSaldo(), 0.0);
    }

    @Test
    public void testToStringContaCorrente() {
        ContaCorrente conta = new ContaCorrente(123, 100.0);
        assertEquals("123 - 100.0", conta.toString());
    }


}
