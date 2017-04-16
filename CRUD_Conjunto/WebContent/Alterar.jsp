<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="model.Conjunto" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="CSS/bootstrap.min.css">
		<meta name= "viewport" content= "width=device-width initial-scale=1">
		<title>Alterar Conjunto</title>
	</head>
	<body>	
		<div class="container col-xs-12 col-sm-7 col-md-6 col-lg-5">
			<h2>Altere os dados do conjunto</h2>
			
			<%Conjunto conjunto = (Conjunto)request.getAttribute("conjunto"); %>
			
			<form action="Alterado.do" method="post">	
				<input type="text" name="andar" value = "<%=conjunto.getAndar() %>" style="display:none;">
				<div class="form-group">
					<label for="tamanho">Tamanho m²:</label>
					<input type="text" class="form-control" name="tamanho" placeholder="Tamanho m²" value = "<%=conjunto.getTamanho() %>">
				</div>
				<div class="form-group">
					<label for="salas">Salas:</label>
					<input type="text" class="form-control" name="salas" value = "<%=conjunto.getSalas() %>">
				</div>
				<div class="form-group">
					<label for="valor">Valor:</label>
					<input type="text" class="form-control" name="valor" value = "<%=conjunto.getValor() %>">
				</div>
				<div class="form-group">
					<label for="descricao">Descrição:</label>
					<textarea rows="5" class="form-control" name="descricao"><%=conjunto.getObservacao() %></textarea>
				</div>
				<div class="radio">
					<b>Situação:</b>
					<label>
						<input type="radio" name="situacao" value="Ativo" <%= (conjunto.getSituacao() == 1 ? "checked" : "") %> > Ativo
					</label>
					<label>
						<input type="radio" name="situacao" value="Desabilitado" <%= (conjunto.getSituacao() == 0 ? "checked" : "") %>> Desabilitado<br>
					</label>
				</div>
			<a class="btn btn-default" href="/CRUD_Conjunto/Alterar.html" role="button">Voltar</a>
			<button type="submit" class="btn btn-default">Enviar</button>	
			</form>					
		</div>
	</body>
</html>