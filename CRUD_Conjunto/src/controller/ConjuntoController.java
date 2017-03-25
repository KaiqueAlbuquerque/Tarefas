package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Conjunto;
import service.ConjuntoService;

@WebServlet("/Conjunto.do")
public class ConjuntoController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException 
	{
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException 
	{		
		int pAndar = Integer.parseInt(request.getParameter("andar"));
   		double pTamanho = Double.parseDouble(request.getParameter("tamanho"));
   		int pSalas = Integer.parseInt(request.getParameter("salas"));
   		double pValor = Double.parseDouble(request.getParameter("valor"));
   		String pObservacao = request.getParameter("observacao");
   		int pSituacao = 1;
   		if(request.getParameter("situacao").equals("Desabilitado"))
   		{
   			pSituacao = 0;
   		}
   		
		//instanciar o javabean
		Conjunto conjunto = new Conjunto();
		conjunto.setAndar(pAndar);
		conjunto.setTamanho(pTamanho);
		conjunto.setSalas(pSalas);
		conjunto.setValor(pValor);
		conjunto.setObservacao(pObservacao);
		conjunto.setSituacao(pSituacao);

		//instanciar o service
		ConjuntoService cs = new ConjuntoService();
		cs.cadastraConjunto(conjunto);
		
		conjunto = cs.consultarConjunto(conjunto.getAndar());
		
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>Conjunto Cadastrado</title></head><body>");
		out.println( "Andar: "+conjunto.getAndar()+"<br>");
		out.println( "Tamanho: "+conjunto.getTamanho()+"<br>");
		out.println( "Salas: "+conjunto.getSalas()+"<br>");
		out.println( "Valor: "+conjunto.getValor()+"<br>");
		out.println( "Observação: "+conjunto.getObservacao()+"<br>");
		if(conjunto.getSituacao() == 1)
		{
			out.println( "Situação: Ativo " +"<br>");
		}
		else
		{
			out.println( "Situação: Desabilitado " +"<br>");
		}
		
		out.println("</body></html>");
	}
}