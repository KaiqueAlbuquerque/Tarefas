package controller;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Conjunto;
import service.ConjuntoService;

@WebServlet("/Conjunto")
public class ConjuntoServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	public ConjuntoServlet()
	{
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		ConjuntoService service = new ConjuntoService();
		HttpSession session = request.getSession();
		String action = request.getParameter("action");

		switch (action) 
		{
		case "listar": 
		{		
			if(session.getAttribute("conjuntos") == null)
			{							
				List<Conjunto> conjuntos = service.consultarTodosConjuntos();
				session.setAttribute("conjuntos", conjuntos);		
			}			
		}
			break;
		case "excluir":
		{			
			int pAndar = Integer.parseInt(request.getParameter("andar"));
			service.deletarConjunto(pAndar);
			
			@SuppressWarnings("unchecked")
			ArrayList<Conjunto> lista = (ArrayList<Conjunto>)session.getAttribute("conjuntos");
			int pos = busca(pAndar, lista);
			lista.remove(pos);
			session.setAttribute("conjuntos", lista);				
		}
			break;		
		case "visualizar":
		{
			int pAndar = Integer.parseInt(request.getParameter("andar"));
			Conjunto conjunto = service.consultarConjunto(pAndar);
			request.setAttribute("conjunto", conjunto);
			
			RequestDispatcher view = request.getRequestDispatcher("VisualizarConjunto.jsp");
			view.forward(request, response);
		}
			break;
		case "editar":
		{
			int pAndar = Integer.parseInt(request.getParameter("andar"));
			Conjunto conjunto = service.consultarConjunto(pAndar);
			request.setAttribute("conjunto", conjunto);
			
			RequestDispatcher view = request.getRequestDispatcher("AlterarConjunto.jsp");
			view.forward(request, response);
		}
			break;
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("ListarConjunto.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException 
	{
		String action = request.getParameter("action");
		HttpSession session = request.getSession();		
		@SuppressWarnings("unchecked")
		ArrayList<Conjunto> lista = (ArrayList<Conjunto>)session.getAttribute("conjuntos");
		
		int pAndar = -1;
		
		try
		{
			pAndar = Integer.parseInt(request.getParameter("andar"));
		}
		catch(Exception e)
		{			
		}		
		
		double pTamanho = Double.parseDouble(request.getParameter("tamanho"));
   		int pSalas = Integer.parseInt(request.getParameter("salas"));
   		double pValor = Double.parseDouble(request.getParameter("valor"));
   		String pObservacao = request.getParameter("descricao");
   		int pSituacao = Integer.parseInt(request.getParameter("situacao"));
   		
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
		
		if(action.equals("cadastrar"))
		{	
			cs.cadastraConjunto(conjunto);
			lista.add(conjunto);			
		}
		else
		{
			cs.alterarConjunto(conjunto);	
			int pos = busca(conjunto.getAndar(), lista);
			lista.remove(pos);
			lista.add(pos, conjunto);	   			
		}			
		
		session.setAttribute("conjuntos", lista);
		RequestDispatcher dispatcher = request.getRequestDispatcher("ListarConjunto.jsp");
		dispatcher.forward(request, response);		
	}
	
	public int busca(int andar, ArrayList<Conjunto> lista)
	{
		Conjunto to;
		for(int i = 0; i < lista.size(); i++)
		{
			to = lista.get(i);
			if(to.getAndar() == andar)
			{
				return i;
			}
		}
		return -1;
	}
}
