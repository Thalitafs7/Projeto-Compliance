<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<%@ include file ="WEB-INF/snippets/imports/libs-head.jsp" %>
	<link rel="stylesheet" href="css/analista.css">
	<link rel="stylesheet" href="css/equipe.css">	
	<title>B2W - Gestor ${nmGestor}</title>
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
	        <h1 class="titulo">Equipe</h1>	
	        <p class="texto">Aqui você conseguirá adicionar e atualizar todas as skills da sua equipe</p>     
        </section>
		<!-- Lista de Analistas -->
      	<section class="listaAnalista">
      		<div class="title">
        		<h4>Associados da sua Equipe</h4>
        		<hr>
        	</div>	
        	
        	<div class="pesquisar">		    
        		<form action="POST">
	        		<div class="input-group mb-3">
					  <input type="text" class="form-control" placeholder="Pesquisar analista pelo Nome ou ID..." 
					   aria-describedby="button-addon2" required="required">
					  <div class="input-group-append">
					    <button class="btn btn-outline-secondary" type="button" id="button-addon2">Buscar</button>
					  </div>
					</div>	 
        		</form>
        		
        	</div>	
        </section>	  
		<div class="lista">
       		<div class="listaContent">
       			<table>
       				<tbody>
       					<tr>		        						
       						<th class="nome-th thLista">NOME</th>
       						<th class="id-th thLista">ID</th>
       						<th class="cargo-th thLista">CARGO</th>
       					</tr> 	        				
       					<tr class="elemLista">
       						<td class="nome-th tdLista">Larissa Soares</td>
       						<td class="id-th tdLista">B2W9810</td>
       						<td class="cargo-th tdLista">Java Software Engineer</td>
       						<td class="btnLista">
       							<button type="submit" data-toggle="modal" data-target="#staticBackdrop">Selecionar</button>
       						</td>
       					</tr>
       					<tr class="elemLista">
       						<td class="nome-th tdLista">Emily Cunha</td>
       						<td class="id-th tdLista">B2W4392</td>
       						<td class="cargo-th tdLista">Palhaça</td>
       						<td class="btnLista">
       							<button type="submit" data-toggle="modal" data-target="#staticBackdrop">Selecionar</button>
       						</td>
       					</tr>
       					<tr class="elemLista">
       						<td class="nome-th tdLista">Arthur Lucas</td>
       						<td class="id-th tdLista">B2W1029</td>
       						<td class="cargo-th tdLista">Analista de Mídia</td>
       						<td class="btnLista">
       							<button type="submit" data-toggle="modal" data-target="#staticBackdrop">Selecionar</button>
       						</td>
       					</tr>
       					<tr class="elemLista">
       						<td class="nome-th tdLista">Mateus Ramos</td>
       						<td class="id-th tdLista">B2W0439</td>
       						<td class="cargo-th tdLista">Nodejs Full-Stack Developer</td>
       						<td class="btnLista">
       							<button type="submit" data-toggle="modal" data-target="#staticBackdrop">Selecionar</button>
       						</td>
       					</tr>
       					<tr class="elemLista">
       						<td class="nome-th tdLista">Gabriel Carvalho</td>
       						<td class="id-th tdLista">B2W3827</td>
       						<td class="cargo-th tdLista">Senior Quality Assurance</td>
       						<td class="btnLista">
       							<button type="submit" data-toggle="modal" data-target="#staticBackdrop">Selecionar</button>
       						</td>
       					</tr>
       					<tr class="elemLista">
       						<td class="nome-th tdLista">Thalita Feitosa</td>
       						<td class="id-th tdLista">B2W6647</td>
       						<td class="cargo-th tdLista">Oracle Database Administrator</td>
       						<td class="btnLista">
       							<button type="submit" data-toggle="modal" data-target="#staticBackdrop">Selecionar</button>
       						</td>
       					</tr>
       					<tr class="elemLista">
       						<td class="nome-th tdLista">Thalita Feitosa</td>
       						<td class="id-th tdLista">B2W6647</td>
       						<td class="cargo-th tdLista">Oracle Database Administrator</td>
       						<td class="btnLista">
       							<button type="submit" data-toggle="modal" data-target="#staticBackdrop">Selecionar</button>
       						</td>
       					</tr>
       					
       							        	
       				</tbody>
   				</table>
      				
   				<!-- Modal -->
				<div class="modal fade" id="staticBackdrop" data-backdrop="static" data-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
				  <div class="modal-dialog">
				    <div class="modal-content">
				      <div class="modal-header">
				        <h5 class="modal-title" id="staticBackdropLabel">Cadastrar Skill</h5>
				        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
				          <span aria-hidden="true">&times;</span>
				        </button>
				      </div>
				      <div class="modal-body">
				        <form>
						  <div class="form-group">
						    <label for="exampleInputEmail1">Nome da Skill</label>
						    <input type="text" name="nmSkill" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" required="required">
						  </div>
						  <div class="form-group">
						    <label for="exampleInputEmail1">Descrição</label>
						    <textarea class="form-control" name="descricao" id="exampleFormControlTextarea1 emily" rows="3" required="required"></textarea>
						    <small id="emailHelp" class="form-text text-muted">Informe quais serão as habilidades apresentadas
						    por essa skill</small>
						    <small id="emailHelp" class="form-text text-muted" id="emily2"></small>
						  </div>

						 
						  <button type="submit" class="btn btn-primary">Cadastrar</button>
						</form>
				        
				        
				      </div>
				      <div class="modal-footer">
				        <button type="button" class="btn btn-secondary" data-dismiss="modal">Fechar</button>
				        <a href="atualizacoesGestor.jsp" target="_blank"><button type="button" class="btn btn-primary">Atualizações</button></a>
				      </div>
				    </div>
				  </div>
				</div>
				
				
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