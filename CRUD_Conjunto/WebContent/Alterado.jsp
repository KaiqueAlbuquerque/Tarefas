<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="model.Conjunto" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Conjunto Alterado</title>
	</head>
	<body>
	<a href="/CRUD_Conjunto/Index.html">Home</a> <a href="/CRUD_Conjunto/Alterar.html">Voltar</a>
		<h2>Conjunto Alterado com Sucesso</h2>
		<%Conjunto conjunto = (Conjunto)request.getAttribute("conjunto"); %>
		Andar: <%=conjunto.getAndar() %><br>
		Tamanho: <%=conjunto.getTamanho() %><br>
		Salas: <%=conjunto.getSalas() %><br>
		Valor: <%=conjunto.getValor() %><br>
		Observação: <%=conjunto.getObservacao() %><br>
		<%
			if(conjunto.getSituacao() == 0)
			{
				out.println("Situação: Desabilitado");
			}
			else
			{
				out.println("Situação: Ativo");
			}
		;%>			
	</body>
</html>