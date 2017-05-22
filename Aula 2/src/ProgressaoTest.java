import static org.junit.Assert.*;

import org.junit.Test;

public class ProgressaoTest {

	@Test
	public void test() {
		Progressao teste = new Progressao();
		
		String res = "Progressão Aritmética (3, 2) = 1, 3, 5";
		String res2 = "Progressão Geometrica (3, 2) = 1, 2, 4";
		assertEquals("Entrada 3, 2, 1", teste.prograssaoAritmetica(3,2), res);
		assertEquals("Entrada 3, 2, 1", teste.prograssaoGeometrica(3,2), res2);
	}

}
