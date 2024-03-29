package exercicio_bancario.testes;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import exercicio_bancario.ContaBancaria;

public class ContaBancariaTest {

    @Test
    public void testDeposito() {
        ContaBancaria conta = new ContaBancaria(123, 100.0);
        conta.deposito(50.0);
        assertEquals(150.0, conta.getSaldo(), 0.0);
    }

    @Test
    public void testSaque() {
        ContaBancaria conta = new ContaBancaria(123, 100.0);
        assertTrue(conta.saque(50.0));
        assertEquals(50.0, conta.getSaldo(), 0.0);
        assertFalse(conta.saque(200.0));
    }

    @Test
    public void testTransferencia() {
        ContaBancaria contaOrigem = new ContaBancaria(123, 200.0);
        ContaBancaria contaDestino = new ContaBancaria(456, 100.0);
        assertTrue(contaOrigem.transferencia(contaDestino, 50.0));
        assertEquals(150.0, contaOrigem.getSaldo(), 0.0);
        assertEquals(150.0, contaDestino.getSaldo(), 0.0);
        assertFalse(contaOrigem.transferencia(contaDestino, 300.0));
    }

    @Test
    public void testToString() {
        ContaBancaria conta = new ContaBancaria(123, 100.0);
        assertEquals("123 - 100.0", conta.toString());
    }
}
