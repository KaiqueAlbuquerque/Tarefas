import java.util.ArrayList;

public class Disciplina 
{
	private ArrayList<NotaEscola> notaEscola;
	private String nomeDisciplina;
	
	public Disciplina(ArrayList<NotaEscola> notaEscola, String nomeDisciplina)
	{
		this.notaEscola = notaEscola;
		this.nomeDisciplina = nomeDisciplina;
	}
	
	public String resultado()
	{
		double media = 0;
		double soma = 0;
		double quantidade = 0;
		
		double menor = notaEscola.get(0).getNota();
		double maior = notaEscola.get(0).getNota();
		String nomeMenor = notaEscola.get(0).getNome();
		String nomeMaior = notaEscola.get(0).getNome();
		String raMenor = notaEscola.get(0).getRa();
		String raMaior = notaEscola.get(0).getRa();
		
		for(NotaEscola ne: notaEscola)
		{
			soma += ne.getNota();
			quantidade++;
			if(ne.getNota() < menor)
			{
				nomeMenor = ne.getNome();
				raMenor = ne.getRa();
			}
			if(ne.getNota() > maior)
			{
				nomeMaior = ne.getNome();
				raMaior = ne.getRa();
			}
		}
		
		media = soma / quantidade;
		
		return "----------Resultado Final----------\n" + "A média das Notas é: " + media + "\n" + nomeMaior + " é o aluno com a Maior nota e seu RA é: " + raMaior + "\n" + nomeMenor + " é o aluno com a Menor nota e seu RA é: " + raMenor;
	}
}
