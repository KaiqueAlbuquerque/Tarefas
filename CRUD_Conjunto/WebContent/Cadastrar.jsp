<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="CSS/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="CSS/estilo.css">
<meta name="viewport" content="width=device-width initial-scale=1">
<title>Início</title>
</head>
<body>

	<c:import url="Menu.jsp" />
		<div class="conteudo">
			<h3>Cadastrar Conjunto</h3>
				<form action="Cadastrar.do" method="post">
				 	<div class="form-group">			 
				 		<label for="tamanho">Tamanho m²:</label>
	    				<input type="text" class="form-control" name="tamanho" id="tamanho" placeholder="Tamanho m²">
	  				</div>
	  				<div class="form-group">			 
				 		<label for="salas">Salas:</label>
	    				<input type="text" class="form-control" name="salas" id="salas" placeholder="Salas">
	  				</div>
	  				<div class="form-group">			 
				 		<label for="valor">Valor:</label>
	    				<input type="text" class="form-control" name="valor" id="valor" placeholder="Valor">
	  				</div>
					<div class="form-group">			 
				 		<label for="descricao">Descrição:</label>
	    				<textarea rows="5" class="form-control" name="descricao" id="descricao" placeholder="Descrição"></textarea>
	  				</div>				
					<div class="radio">
					<b>Situação:</b>
					  	<label>
					  	  <input type="radio" name="situacao" value="Ativo" checked>
					  	  	Ativo
					 	</label>
					 	<label>
					  	  <input type="radio" name="situacao" value="Desabilitado">
					  	  	Inativo
					 	</label>
					</div>
					<button type="submit" class="btn btn-default">Enviar</button>						
				</form>
			</div>
	<c:import url="Pos_Menu.jsp" />
</body>
</html>