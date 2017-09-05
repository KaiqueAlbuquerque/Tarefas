package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Conjunto;
import service.ConjuntoService;
import util.JSonFacade;

/**
 * Servlet implementation class CadastrarWebService
 */
@WebServlet("/ConjuntoWebService")
public class ConjuntoWebService extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/*
	 * configurar a request e a response para todos os métodos
	 */
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		super.service(request, response);
	}
	/*
	 * listar conjuntos
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ConjuntoService service = new ConjuntoService();
		ArrayList<Conjunto> conjuntos = service.consultarTodosConjuntos();
		PrintWriter out = response.getWriter();		
		out.println(JSonFacade.listToJSon(conjuntos));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StringBuilder sb = JSonFacade.montaJSon(request);
		PrintWriter out = response.getWriter();

		try {
			Conjunto conjunto = JSonFacade.jSonToConjunto(sb.toString());
			ConjuntoService cs = new ConjuntoService();
			cs.cadastraConjunto(conjunto);
			conjunto = cs.consultarConjunto(conjunto.getAndar());
			out.println(JSonFacade.ConjuntoToJSon(conjunto));
		} catch (Exception e) {
			e.printStackTrace();
			out.println(JSonFacade.errorToJSon(e));
		}
	}

}
