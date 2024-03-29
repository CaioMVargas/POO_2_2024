package exercicio_bancario.testes;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.Test;

import exercicio_bancario.Banco;
import exercicio_bancario.ContaBancaria;

public class BancoTest {

    @Test
    public void testAdicionarConta() {
        Banco banco = new Banco();
        ContaBancaria conta1 = new ContaBancaria(123, 100.0);
        ContaBancaria conta2 = new ContaBancaria(456, 200.0);

        banco.adicionarConta(conta1);
        banco.adicionarConta(conta2);

        List<ContaBancaria> contas = banco.getContas();

        assertEquals(2, contas.size());
        assertTrue(contas.contains(conta1));
        assertTrue(contas.contains(conta2));
    }

    @Test
    public void testGetContas() {
        Banco banco = new Banco();
        ContaBancaria conta1 = new ContaBancaria(123, 100.0);
        ContaBancaria conta2 = new ContaBancaria(456, 200.0);

        banco.adicionarConta(conta1);
        banco.adicionarConta(conta2);

        List<ContaBancaria> contas = banco.getContas();

        assertNotNull(contas);
        assertEquals(2, contas.size());
    }
}
