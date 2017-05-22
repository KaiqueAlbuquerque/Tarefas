import static org.junit.Assert.*;

import javax.swing.JOptionPane;

import org.junit.Test;

public class NotaEscolaTest {

	@Test
	public void test() {
		NotaEscola ne = new NotaEscola();
		int desejaAdicionar = Integer.parseInt(JOptionPane.showInputDialog("Deseja Adicionar?"+ "\n1) Sim"+"\n-1) Não"));
		String ra;
		String nome;
		double nota;
		while(desejaAdicionar != -1)
		{
			ra = JOptionPane.showInputDialog("Digite o RA");
			nome = JOptionPane.showInputDialog("Digite o Nome");
			nota = Double.parseDouble(JOptionPane.showInputDialog("Digite a Nota"));
			
			ne.adicionaNotas(ra,nome,nota);
			desejaAdicionar = Integer.parseInt(JOptionPane.showInputDialog("Deseja Adicionar?"+ "\n1) Sim"+"\n-1) Não"));
		}
		String res = "----------Resultado Final----------\n" + "A média das Notas é: " + 5.0 + "\n" + 5.0 + " é o aluno com a Maior nota e seu RA é: " + 201500984+ "\n" + 5.0 + " é o aluno com a Menor nota e seu RA é: " + 201500984	;
		Disciplina d = new Disciplina(ne.mostraNotas(),JOptionPane.showInputDialog("Informe o nome da Disciplina para oter o Resultado"));
		
		assertEquals("Entrada 3, 2, 1", d.resultado(), res);
		
	}

}
