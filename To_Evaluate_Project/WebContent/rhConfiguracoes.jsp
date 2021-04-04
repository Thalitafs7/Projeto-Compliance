<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<%@include file="WEB-INF/snippets/imports/libs-head.jsp"%>
	<link rel="stylesheet" href="css/indexRh.css">
	<link rel="stylesheet" href="css/padraoRh.css">
	<title>B2W - RH</title>
</head>
<body>
	

	<div class="body-container">
		<section id="menu-section">
			<div class="logo">
				<a href="rhIndex?id_rh=${rh.id}">
					<img alt="Logo Linc Tech" src="img/logo3.png">
				</a>
			</div>
			<%@ include file ="WEB-INF/snippets/rh/menu.html" %>
		</section> <!-- End Menu -->
	
		<!-- Container End -->
		<section id="container-end">
			<div id="parteSuperior">
				<div class="link-voltar">
					<a href="rhIndex?id_rh=${rh.id}">Voltar</a>
				</div>
				<h3>Configurações</h3>
			</div>
			<h3 class="titulo-atualizar">Informações</h3>
			<c:choose>
				<c:when test="${param.msg eq 'ok'}">	
					<div>
						<h2 class="alert alert-success" role="alert">${param.msgStatus}</h2>
					</div>
				</c:when>
				<c:when test="${param.status eq 'err'}">	
					<div>
						<h2 class="alert alert-danger" role="alert">${param.msgStatus}</h2>
					</div>
				</c:when>
			</c:choose>
			<div id="conteudo">
				<form action="updateRh?id_rh=${rh.id}" method="post">
					<div class="formBox-1">
						<div class="form-group">
						    <label for="exampleInputEmail1">Nome</label>
						    <input type="text" name="nome" class="form-control input-form" id="exampleInputEmail1" aria-describedby="emailHelp" value="${rh.nome}">				    
					  	</div>
					  	<div class="form-group">
						    <label for="exampleInputEmail1">Data de nascimento</label>
						    <input type="date" name="dtNascimento" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" value="${rh.dt_nasc}">				    
					  	</div>
					</div>
					<div class="formBox-2">				
					  	<div class="form-group">
						    <label for="exampleInputEmail1">Telefone</label>
						    <input type="text" name="telefone" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" value="${telefone.ddd}${telefone.numero}">				    
					  	</div>
					  	<div class="form-group">
						    <label for="exampleInputEmail1">Email</label>
						    <input type="email" name="email" class="form-control input-form" id="exampleInputEmail1" aria-describedby="emailHelp" value="${login.email}">				    
					  	</div>
					  	<div class="form-group">
						    <label for="exampleInputEmail1">Senha</label>
						    <input type="text" name="senha" class="form-control input-form" id="exampleInputEmail1" aria-describedby="emailHelp" value="${login.senha}">				    
					  	</div>
					</div>
					<button type="submit" class="btn btn-primary">Atualizar</button>
					
					<!-- Button trigger modal -->
					<button type="button" class="btn btn-danger" data-toggle="modal" data-target="#exampleModal">
					  Deletar Conta
					</button>
				</form>
				
				
				<!-- Modal -->
				<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
				  <div class="modal-dialog">
				    <div class="modal-content">
				      <div class="modal-header">
				        <h5 class="modal-title" id="exampleModalLabel">Deletando usuário</h5>
				        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
				          <span aria-hidden="true">&times;</span>
				        </button>
				      </div>
				      <div class="modal-body">
				        Você tem certeza que deseja deletar sua conta?
				      </div>
				      <div class="modal-footer">				       
				        <a href="#">
				        	<button type="button" class="btn btn-danger">Deletar</button>	
				        </a>				    
				         <button type="button" class="btn btn-primary" data-dismiss="modal">Não</button>    
				      </div>
				    </div>
				  </div>
				</div>
				
			</div>
		</section>
	</div>
	
<%@ include file = "WEB-INF/snippets/imports/libs-footer.jsp" %>
</body>
</html>