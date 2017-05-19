<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="CSS/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="CSS/estilo.css">
<meta name="viewport" content="width=device-width initial-scale=1">
<title>Conjunto</title>
</head>
<body>
	<!-- Modal -->
	<div class="modal fade" id="delete-modal" tabindex="-1" role="dialog" aria-labelledby="modalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Fechar">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="modalLabel">Excluir Conjunto</h4>
				</div>
				<div class="modal-body">Deseja realmente excluir este conjunto?</div>
				<div class="modal-footer">
					<form action="Conjunto" method="get">
						<input type="hidden" name="andar" id="andar_excluir" />
						<button type="submit" class="btn btn-primary" name="action" value="excluir">Sim</button>
						<button type="button" class="btn btn-default" data-dismiss="modal">N&atilde;o</button>
					</form>
				</div>
			</div>
		</div>
	</div>
	<!-- /.modal -->

	<c:import url="Menu.jsp" />
	<div class="conteudo">
		<div id="top" class="row">
        	<div class="col-md-3">
        		<h2>Conjuntos</h2>
        	</div>  
        	<div class="col-md-3 col-md-offset-6">
        		<a href="CadastrarConjunto.jsp" class="btn btn-primary pull-right h2">Novo Conjunto</a>
        	</div>
     </div>
	<c:if test="${not empty conjuntos}">
		<div id="list" class="row">
				<div class="table-responsive col-md-12">
					<table class="table table-striped" cellspacing="0" cellpadding="0">
						<thead>
							<tr>
								<th>Andar</th>
								<th>Salas</th>
								<th>Tamanho</th>
								<th>Situação</th>
								<th>Valor</th>
								<th class="actions">Ações</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="conjunto" items="${conjuntos}">
								<tr>
									<td>${conjunto.andar }</td>
									<td>${conjunto.salas }</td>
									<td>${conjunto.tamanho }</td>
									<td>
										<c:if test="${conjunto.situacao == 0}"> 
											Inativo
										</c:if>
										<c:if test="${conjunto.situacao == 1}"> 
											Ativo
										</c:if>
									</td>
									<td>R$ ${conjunto.valor }</td>
									<td class="actions">
										<a class="btn btn-success btn-xs" href="Conjunto?action=visualizar&andar=${conjunto.andar }">Visualizar</a>
										<a class="btn btn-warning btn-xs" href="Conjunto?action=editar&andar=${conjunto.andar }">Editar</a>
										<a class="btn btn-warning btn-xs" onclick="deletar(${conjunto.andar });">Excluir</a>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
			<!-- /#list -->
		</c:if>
	</div>
		<c:import url="Pos_Menu.jsp" />
<script src="JS/jquery.js"></script>
<script src="JS/bootstrap.min.js"></script>
<script>
function deletar(andar)
{
	  $("#andar_excluir").val(andar);
	  $("#delete-modal").modal();	
}
</script>
</body>
</html>