import java.util.ArrayList;

public class NotaEscola 
{
	private String ra;
	private String nome;
	private double nota;
	ArrayList<NotaEscola> ne = new ArrayList<NotaEscola>();
	
	public NotaEscola(String ra, String nome, double nota)
	{
		this.ra = ra;
		this.nome = nome;
		this.nota = nota;
	}
	
	public String getRa() 
	{
		return ra;
	}

	public void setRa(String ra) 
	{
		this.ra = ra;
	}

	public String getNome()
	{
		return nome;
	}

	public void setNome(String nome) 
	{
		this.nome = nome;
	}

	public double getNota() 
	{
		return nota;
	}

	public void setNota(double nota)
	{
		this.nota = nota;
	}

	public NotaEscola()
	{
		this.ra = "";
		this.nome = "";
		this.nota = 0.0;
	}
	
	public void adicionaNotas(String ra, String nome, double nota)
	{		
		ne.add(new NotaEscola(ra,nome,nota));
	}
	
	public ArrayList<NotaEscola> mostraNotas()
	{
		return ne;
	}
}
