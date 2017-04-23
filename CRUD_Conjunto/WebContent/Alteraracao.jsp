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
<title>Alterar Conjunto</title>
</head>
<body>
	<c:import url="Menu.jsp" />
	<div class="conteudo">
		<h2>Altere os dados do conjunto</h2>
		<c:if test="${conjunto == null}">
			<div class="panel panel-default">
				<div class="panel-body">
					<b>Conjunto não encontrado!</b>
				</div>
			</div>
			<a class="btn btn-default" href="/CRUD_Conjunto/Alterar.jsp"
				role="button">Voltar</a>
		</c:if>
		<c:if test="${conjunto != null}">
			<form action="Alterado.do" method="post">
				<input type="text" name="andar" value="${conjunto.andar}"
					style="display: none;">
				<div class="form-group">
					<label for="tamanho">Tamanho m²:</label> <input type="text"
						class="form-control" name="tamanho" placeholder="Tamanho m²"
						value="${conjunto.tamanho}">
				</div>
				<div class="form-group">
					<label for="salas">Salas:</label> <input type="text"
						class="form-control" name="salas" value="${conjunto.salas}">
				</div>
				<div class="form-group">
					<label for="valor">Valor:</label> <input type="text"
						class="form-control" name="valor" value="${conjunto.valor}">
				</div>
				<div class="form-group">
					<label for="descricao">Descrição:</label>
					<textarea rows="5" class="form-control" name="descricao">${conjunto.observacao}</textarea>
				</div>
				<div class="radio">
					<b>Situação:</b> <label> <input type="radio"
						name="situacao" value="Ativo"
						<c:if test="${conjunto.situacao == 1}">checked</c:if>>
						Ativo
					</label> <label> <input type="radio" name="situacao"
						value="Desabilitado"
						<c:if test="${conjunto.situacao == 0}">checked</c:if>>
						Desabilitado<br>
					</label>
				</div>
				<a class="btn btn-default" href="/CRUD_Conjunto/Alterar.jsp"
					role="button">Voltar</a>
				<button type="submit" class="btn btn-default">Enviar</button>
			</form>
		</c:if>
	</div>
	<c:import url="Pos_Menu.jsp" />
</body>
</html>