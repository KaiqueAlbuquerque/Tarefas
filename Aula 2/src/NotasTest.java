import static org.junit.Assert.*;

import org.junit.Test;

public class NotasTest {

	@Test
	public void test() {
		Notas grade = new Notas();
		String a = "A Maior nota é: " + 10.0 + "\nA Menor nota é: " + 5.0 + "\nA Média das notas é: " + 15.0/2.0;
		
		assertEquals("Entrada 5,10", grade.MostraNotas(), a);
	
	}

}
