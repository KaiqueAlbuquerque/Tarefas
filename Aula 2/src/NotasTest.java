import static org.junit.Assert.*;

import org.junit.Test;

public class NotasTest {

	@Test
	public void test() {
		Notas grade = new Notas();
		String a = "A Maior nota �: " + 10.0 + "\nA Menor nota �: " + 5.0 + "\nA M�dia das notas �: " + 15.0/2.0;
		
		assertEquals("Entrada 5,10", grade.MostraNotas(), a);
	
	}

}
