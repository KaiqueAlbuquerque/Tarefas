<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="CSS/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="CSS/estilo.css">
<meta name="viewport" content="width=device-width initial-scale=1">
<title>Deletar Conjunto</title>
</head>
<body>
	<c:import url="Menu.jsp" />
	<div class="conteudo">
		<form action="Deletar.do" method="post">
			<h2>Dados do Conjunto que será Excluído</h2>
			<div class="panel panel-default">
				<div class="panel-body">
					<c:if test="${conjunto == null}">
						<b>Conjunto não encontrado!</b>
					</c:if>
					<c:if test="${conjunto != null}">
						<b>Andar:</b> ${conjunto.andar} <br>
						<b>Tamanho:</b> ${conjunto.tamanho}<br>
						<b>Salas:</b> ${conjunto.salas}<br>
						<b>Valor:</b> R$ ${conjunto.valor}<br>
						<b>Observação:</b> ${conjunto.observacao}<br>
						<b>Situação:</b>

						<c:if test="${conjunto.situacao == 0}"> 
						Inativo
					</c:if>
						<c:if test="${conjunto.situacao == 1}"> 
						Ativo
					</c:if>
					</c:if>
				</div>
			</div>
			<a class="btn btn-default" href="/CRUD_Conjunto/Deletar.jsp"
				role="button">Voltar</a>
			<c:if test="${conjunto != null}">

				<input type="text" name="andar" value="${conjunto.andar}"
					style="display: none;">
				<button type="submit" class="btn btn-default">Confirmar</button>
			</c:if>
		</form>
		<c:import url="Pos_Menu.jsp" />
	</div>
</body>
</html>