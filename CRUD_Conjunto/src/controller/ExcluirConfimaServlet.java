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

@WebServlet("/ExcluirConfima.do")
public class ExcluirConfimaServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	public ExcluirConfimaServlet()
	{
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException
	{
		int pAndar = Integer.parseInt(request.getParameter("andar"));

		Conjunto conjunto = new Conjunto();

		// instanciar o service
		ConjuntoService cs = new ConjuntoService();
		conjunto = cs.consultarConjunto(pAndar);
	
		// enviar para o jsp
		if(conjunto.getAndar() == 0)
		{
			request.setAttribute("conjunto", null);
		}
		else
		{
			request.setAttribute("conjunto", conjunto);
		}

		RequestDispatcher view = request.getRequestDispatcher("DeletadoConfirma.jsp");
		view.forward(request, response);
	}

}
