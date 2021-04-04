<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<%@ include file ="WEB-INF/snippets/imports/libs-head.jsp" %>
	<link rel="stylesheet" href="css/analista.css">
	<link rel="stylesheet" href="css/equipes.css">	
	<title>B2W - Analista</title>
</head>
<body>
	<!-- Header -->
	<%@ include file ="WEB-INF/snippets/analista/header.html" %> <!-- ESTOU USANDO DO ANALISTA -->
	
	<!-- Plano de fundo -->
	<%@ include file ="WEB-INF/snippets/fundo.html" %>
	
	<!-- Container -->
	<div class="body-container">
		<p class="voltar"><a href="analista?id=${user.id}">Voltar</a></p>
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
         	<form action="rhIndex.jsp">
				<div class="formBox-1">
					<div class="form-group">
					    <label for="exampleInputEmail1">Nome</label>
					    <input type="text" name="nome" class="form-control input-form" id="exampleInputEmail1" aria-describedby="emailHelp" value="${user.nome}">				    
				  	</div>
				  	<div class="form-group">
					    <label for="exampleInputEmail1">Data de nascimento</label>
					    <input type="date" name="dtNascimento" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" value="${user.dt_nasc}">				    
				  	</div>
				</div>
				<div class="formBox-2">				
				  	<div class="form-group">
					    <label for="exampleInputEmail1">Telefone</label>
					    <input type="text" name="telefone" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" value="${tel.numero}">				    
				  	</div>
				  	<div class="form-group">
					    <label for="exampleInputEmail1">Departamento</label>
					    <input type="text" name="departamento" class="form-control input-form" id="exampleInputEmail1" aria-describedby="emailHelp" value="${user.departamento}">				    
				  	</div>
				  	<div class="form-group">
					    <label for="exampleInputEmail1">Cargo</label>
					    <input type="text" name="cargo" class="form-control input-form" id="exampleInputEmail1" aria-describedby="emailHelp" value="${user.cargo}">				    
				  	</div>
				</div>
				<div class="formBox-3">
					<div class="form-group">
					    <label for="exampleInputEmail1">ID do Gestor</label>
					    <input type="text" name="idGestor" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" value="${lider.id}">				    
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
				<div class="formBox-3">
					<div class="form-group">
					    <label for="exampleInputEmail1">Situação</label>
					    <input type="text" name="situacao" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" value="${user.situacao}">				    
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