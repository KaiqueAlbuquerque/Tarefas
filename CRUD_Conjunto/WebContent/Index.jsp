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
		<div style="POSITION: absolute; width: calc(100% - 250px); color: #555; text-align: center; bottom: 32%; font-family: serif;">
			<img class="" src="Image/logo.png" alt="Logotipo Empresa">

			<h2>
				Bem-Vindo ao NeoTower<br>Sistema de Controle Predial
			</h2>
		</div>
	<c:import url="Pos_Menu.jsp" />
</body>
</html>