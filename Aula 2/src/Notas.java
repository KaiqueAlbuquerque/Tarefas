import javax.swing.JOptionPane;

public class Notas 
{	
	private double maior;
	private double menor;
	private double qtd; 
	private double soma;
	
	public String MostraNotas()
	{			
		double nota = Double.parseDouble(JOptionPane.showInputDialog("Digite a nota do Aluno"));
		maior = nota;
		menor = nota;
				
		while(nota != -1)
		{	
			if(nota > maior)
			{
				maior = nota;
			}
			if(nota < menor)
			{
				menor = nota;
			}			
			soma += nota;
			qtd++;
			
			nota = Double.parseDouble(JOptionPane.showInputDialog("Digite a nota do Aluno"));
		}
		return "A Maior nota é: " + maior + "\nA Menor nota é: " + menor + "\nA Média das notas é: " + soma/qtd;
	}
}
