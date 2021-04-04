<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<%@ include file ="WEB-INF/snippets/imports/libs-head.jsp" %>
	<link rel="stylesheet" href="css/analista.css">
	<link rel="stylesheet" href="css/equipes.css">	
	<title>B2W - Gestor</title>
</head>
<body>
	<!-- Header -->
	<%@ include file ="WEB-INF/snippets/analista/header.html" %> <!-- ESTOU USANDO DO ANALISTA -->
	
	<!-- Plano de fundo -->
	<%@ include file ="WEB-INF/snippets/fundo.html" %>
	
	<!-- Container -->
	<div class="body-container">
		<p class="voltar"><a href="gestor.jsp">Voltar</a></p>
		<!-- Título -->
		<section class="section-titulo">
	        <h1 class="titulo">Configurações</h1>	
	        <p class="texto">Aqui você conseguirá alterar ou deletar os dados da sua conta</p>     
        </section>
		<!-- Lista de Analistas -->
      	<section class="alteracoes">
      		<div class="title">
        		<h4>Informações</h4>
        		<hr>
        	</div>	
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
         	<form action="atualizaGestor" method="post">
				<div class="formBox-1">
					<div class="form-group">
					    <label for="exampleInputEmail1">Nome</label>
					    <input type="text" name="nome" class="form-control input-form" id="exampleInputEmail1" aria-describedby="emailHelp" value="${gestor.nome}">				    
				  	</div>
				  	
				  	<div class="form-group">
					    <label for="exampleInputEmail1">Data de nascimento</label>
					    <input type="date" name="dtNascimento" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" value="${gestor.dt_nasc}">				    
				  	</div>
				</div>
				<div class="formBox-2">				
				  	<div class="form-group">
					    <label for="exampleInputEmail1">Telefone</label>
					    <input type="text" name="telefone" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" value="${tel.ddd}${tel.numero}">				    
				  	</div>
				  	<div class="form-group">
					    <label for="exampleInputEmail1">Departamento</label>
					    <input type="tel" name="departamento" class="form-control input-form" id="exampleInputEmail1" aria-describedby="emailHelp" value="${gestor.departamento}">				    
				  	</div>
				  	<div class="form-group">
					    <label for="exampleInputEmail1">Cargo</label>
					    <input type="text" name="cargo" class="form-control input-form" id="exampleInputEmail1" aria-describedby="emailHelp" value="${gestor.cargo}">				    
				  	</div>
				</div>
				<div class="formBox-3">										  
				  	<div class="form-group">
					    <label for="exampleInputEmail1">Email</label>
					    <input type="email" name="email" class="form-control input-form" id="exampleInputEmail1" aria-describedby="emailHelp" value="${login.email}">				    
				  	</div>
				  	<div class="form-group">
					    <label for="exampleInputEmail1">Senha</label>
					    <input type="text" name="senha" class="form-control input-form" id="exampleInputEmail1" aria-describedby="emailHelp" value="${login.senha}">				    
				  	</div>
				</div>
				<div class="formBox-3">	
				  	<div class="form-group">
					    <label for="exampleInputEmail1">Status Líder</label>
					    <input type="text" name="status" class="form-control input-form" id="exampleInputEmail1" aria-describedby="emailHelp" value="${gestor.status}">
					    <small id="emailHelp" class="form-text text-muted">Informe "não" quando deixar de ser líder</small>				    
				  	</div>						  					  	
				</div>
				<button type="submit" class="btn btn-primary">Atualizar</button>				
			</form>
			
   		</section>	 

		<!-- Chatbot -->
		<%@ include file ="WEB-INF/snippets/chatbot.html" %>
		
		<!-- Footer -->
		<%@ include file ="WEB-INF/snippets/rodape-padrao.html" %>
	</div>


	<!-- imports -->
	<%@ include file ="WEB-INF/snippets/imports/libs-footer.jsp" %>
	
</body>
</html>