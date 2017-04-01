<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="model.Conjunto" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Alterar Conjunto</title>
	</head>
	<body>
	<a href="/CRUD_Conjunto/Index.html">Home</a> <a href="/CRUD_Conjunto/Alterar.html">Voltar</a>
		<h2>Altere os dados do conjunto</h2>
		
		<%Conjunto conjunto = (Conjunto)request.getAttribute("conjunto"); %>
		
		<form action="Alterado.do" method="post">
			<input type="text" name="andar" value = "<%=conjunto.getAndar() %>" style="display:none;">
			Tamanho: <input type="text" name="tamanho" value = "<%=conjunto.getTamanho() %>"><br>
			Salas: <input type="text" name="salas" value = "<%=conjunto.getSalas() %>"><br>
			Valor: <input type="text" name="valor" value = "<%=conjunto.getValor() %>"><br>
			Descrição: <textarea rows="5" name="descricao"><%=conjunto.getObservacao() %></textarea><br>
			Situação: <input type="radio" name="situacao" value="Ativo" <%= (conjunto.getSituacao() == 1 ? "checked" : "") %> > Ativo
					  <input type="radio" name="situacao" value="Desabilitado" <%= (conjunto.getSituacao() == 0 ? "checked" : "") %>> Desabilitado<br>
						<input type="submit"> <button type="submit">enviar</button>
		</form>		
	</body>
</html>