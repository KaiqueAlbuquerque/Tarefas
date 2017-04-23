<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="CSS/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="CSS/estilo.css">
<meta name="viewport" content="width=device-width initial-scale=1">
<title>Conjunto Deletado</title>
</head>
<body>
	<c:import url="Menu.jsp" />
	<div class="conteudo">
		<h2>Deletar Conjunto</h2>
		<div class="panel panel-default">
			<div class="panel-body">
				<b>Conjunto deletado com sucesso!</b>
			</div>
		</div>

		<a class="btn btn-default" href="/CRUD_Conjunto/Deletar.jsp"
			role="button">Voltar</a>
	</div>
	<c:import url="Pos_Menu.jsp" />
</body>
</html>