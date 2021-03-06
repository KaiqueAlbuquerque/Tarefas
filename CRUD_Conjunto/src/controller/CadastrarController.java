package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Conjunto;
import service.ConjuntoService;

@WebServlet("/Cadastrar.do")
public class CadastrarController extends HttpServlet 
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
		double pTamanho = Double.parseDouble(request.getParameter("tamanho"));
   		int pSalas = Integer.parseInt(request.getParameter("salas"));
   		double pValor = Double.parseDouble(request.getParameter("valor"));
   		String pObservacao = request.getParameter("descricao");
   		int pSituacao;
   		if(request.getParameter("situacao").equals("Desabilitado"))
   		{
   			pSituacao = 0;
   		}
   		else
   		{
   			pSituacao = 1;
   		}
   		
		//instanciar o javabean
		Conjunto conjunto = new Conjunto();
		conjunto.setTamanho(pTamanho);
		conjunto.setSalas(pSalas);
		conjunto.setValor(pValor);
		conjunto.setObservacao(pObservacao);
		conjunto.setSituacao(pSituacao);

		//instanciar o service
		ConjuntoService cs = new ConjuntoService();
		cs.cadastraConjunto(conjunto);
		conjunto = cs.consultarConjunto(conjunto.getAndar());
		
		//enviar para o jsp
		request.setAttribute("conjunto", conjunto);
		
		RequestDispatcher view =
		request.getRequestDispatcher("Cadastrado.jsp");
		view.forward(request, response);
	}
}