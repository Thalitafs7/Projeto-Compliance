<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<%@ include file ="WEB-INF/snippets/imports/libs-head.jsp" %>
	<link rel="stylesheet" href="css/analista.css">
	<link rel="stylesheet" href="css/equipes.css">	
	<title>B2W - Gestor ${nmGestor}</title>
</head>
<body>
	<!-- Header -->
	<%@ include file ="WEB-INF/snippets/analista/header.html" %> <!-- ESTOU USANDO DO ANALISTA -->
	
	<!-- Plano de fundo -->
	<%@ include file ="WEB-INF/snippets/fundo.html" %>
	
	<!-- Container -->
	<div class="body-container">
		<!-- Título -->
		<section class="section-titulo">
	        <h1 class="titulo">Larissa Soares</h1>
	        <p class="texto">Você está prestes a alterar as skills da Larissa..</p>	     
        </section>
		<div class="atualizarSkill">
			<div id="skill">
				<form action="atualizacoesGestor.jsp" method="POST">
					<div id="form-group">
						<div class="form-skill">
				    		<label for="exampleInputEmail1"></label>
				    		<input type="text" name="nmSkill" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" value="Python">
			    		</div>
			    		<!-- Button trigger modal -->
						<button type="button" class="btn btn-danger" data-toggle="modal" data-target="#deletar">
						 Deletar
						</button>
			  		</div>
				  		
					<div id="form-group">
						<div class="form-skill">
				    		<label for="exampleInputEmail1"></label>
				    		<input type="text" name="nmSkill" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" value="Java">
			    		</div>
			    		<!-- Button trigger modal -->
						<button type="button" class="btn btn-danger" data-toggle="modal" data-target="#deletar">
						 Deletar
						</button>
			  		</div>
					
					<div id="form-group">
						<div class="form-skill">
				    		<label for="exampleInputEmail1"></label>
				    		<input type="text" name="nmSkill" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" value="HTML5">
			    		</div>
			    		<!-- Button trigger modal -->
						<button type="button" class="btn btn-danger" data-toggle="modal" data-target="#deletar">
						 Deletar
						</button>
			  		</div>
			  		
			  		<div id="form-group">
						<div class="form-skill">
				    		<label for="exampleInputEmail1"></label>
				    		<input type="text" name="nmSkill" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" value="CSS3">
			    		</div>
			    		<!-- Button trigger modal -->
						<button type="button" class="btn btn-danger" data-toggle="modal" data-target="#deletar">
						 Deletar
						</button>
			  		</div>
			  		
			    	<button type="submit" class="btn btn-primary" id="btn-atualizar" >Atualizar</button>
			    	
			    	
			    	<!-- Modal -->
					<div class="modal fade" id="deletar" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
					  <div class="modal-dialog">
					    <div class="modal-content">
					      <div class="modal-header">
					        <h5 class="modal-title" id="exampleModalLabel"></h5>
					        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
					          <span aria-hidden="true">&times;</span>
					        </button>
					      </div>
					      <div class="modal-body">
					        Você tem certeza que deseja deletar essa skill?
					      </div>
					      <div class="modal-footer">					     
					        <button type="submit" class="btn btn-danger">SIM</button>
					        <button type="button" class="btn btn-secondary" data-dismiss="modal">NÃO</button>
					      </div>
					    </div>
					  </div>
					</div>
			    	
				</form>
				
			</div>			
		</div>

		
		<!-- Chatbot -->
		<%@ include file ="WEB-INF/snippets/chatbot.html" %>


		<!-- Footer -->
		<%@ include file ="WEB-INF/snippets/rodape-padrao.html" %>
	</div>


	<!-- imports -->
	<%@ include file ="WEB-INF/snippets/imports/libs-footer.jsp" %>
	
</body>
</html>