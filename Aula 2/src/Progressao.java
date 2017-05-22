public class Progressao
{
	public String prograssaoAritmetica(int n, int r)
	{
		String texto = "Progress�o Aritm�tica (" + n + ", " + r + ") = 1";
		int total=1;
		for(int i = 1; i < n; i++)
		{
			total += r;
			texto += ", " + total;
		}
		
		return texto;
	}
	
	public String prograssaoGeometrica(int n, int r)
	{
		String texto = "Progress�o Geometrica (" + n + ", " + r + ") = 1";
		int total=1;
		for(int i = 1; i < n; i++)
		{
			total *= r;
			texto += ", " + total;
		}
		
		return texto;
	}
}
