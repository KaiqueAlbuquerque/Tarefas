<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="CSS/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="CSS/estilo.css">
<meta name="viewport" content="width=device-width initial-scale=1">
<title>Excluir Conjuto</title>
</head>
<body>
	<c:import url="Menu.jsp" />
	<div class="conteudo">
		<h3>Excluir Conjuto</h3>
		<form action="ExcluirConfima.do" method="post">
			<div class="form-group">
				<label for="andar">Informe o Andar que deseja excluir:</label> <input
					type="text" class="form-control" name="andar" id="andar"
					placeholder="Andar">
			</div>
			<button type="submit" class="btn btn-default">Enviar</button>
		</form>
	</div>
	<c:import url="Pos_Menu.jsp" />
</body>
</html>