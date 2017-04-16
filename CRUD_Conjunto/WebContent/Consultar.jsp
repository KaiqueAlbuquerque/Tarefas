<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="model.Conjunto" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="CSS/bootstrap.min.css">
		<meta name= "viewport" content= "width=device-width initial-scale=1">
		<title>Consulta Conjunto</title>
	</head>
	<body>
		<div class = "container col-xs-12 col-sm-7 col-md-6 col-lg-5">	
			<h2>Dados do Conjunto</h2>		
			<%Conjunto conjunto = (Conjunto)request.getAttribute("conjunto"); %>
			<div class="panel panel-default">
  				<div class="panel-body">
					<b>Andar:</b> <%=conjunto.getAndar() %><br>
					<b>Tamanho:</b> <%=conjunto.getTamanho() %><br>
					<b>Salas:</b> <%=conjunto.getSalas() %><br>
					<b>Valor:</b> <%=conjunto.getValor() %><br>
					<b>Observação:</b> <%=conjunto.getObservacao() %><br>
					<b>Situação:</b>
					<%
						if(conjunto.getSituacao() == 0)
						{
							out.println("Desabilitado");
						}
						else
						{
							out.println("Ativo");
						}
					;%>			
				</div>
			</div>	
			<a class="btn btn-default" href="/CRUD_Conjunto/Index.html" role="button">Home</a>
			<a class="btn btn-default" href="/CRUD_Conjunto/Consultar.html" role="button">Voltar</a>
		</div>
	</body>
</html>