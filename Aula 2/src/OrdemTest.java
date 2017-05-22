

import static org.junit.Assert.*;

import org.junit.Test;

public class OrdemTest {

	@Test
	public void test() {
		
		Ordem teste = new Ordem();
		
		String res = "123";

		assertEquals("Entrada 3, 2, 1", teste.crescente(3,2,1), res);
		assertEquals("Entrada 1, 3, 2", teste.crescente(1,3,2), res);
		assertEquals("Entrada 2, 1, 3", teste.crescente(2,1,3), res);
		assertEquals("Entrada 2, 3, 1", teste.crescente(2,3,1), res);
		assertEquals("Entrada 3, 1, 2", teste.crescente(3,1,2), res);
		assertEquals("Entrada 3, 2, 1", teste.crescente(3,2,1), res);
	}

}
