<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<%@include file="WEB-INF/snippets/imports/libs-head.jsp"%>
	<link rel="stylesheet" href="css/padraoRh.css">
	<title>B2W - RH</title>
	
	<style>
		th {color: #34c4cc;}
		.depto-th {width: 9rem;}
		.cargo-th {width: 22rem;}
		.btnLista button {background: #cf1b1b;}		
		.btnLista button:hover {
		    background: none;
		    color: #1b1b1b;
			border: 1px solid;
		}
	
	</style>
</head>
<body>
	<div class="body-container">
		
		<!-- Menu -->
		<section id="menu-section">
			<div class="logo">
				<a href="rhIndex?id_rh=${rh.id}">
					<img alt="Logo Linc Tech" src="img/logo3.png">
				</a>
			</div>			
			<div class="opcoes">
				<div class="opc1 icon"> <!-- verificar desempenho -->
					<a href="verificarDesempenhoListaAnalista?id_rh=${rh.id}">
						<i class="fas fa-chart-bar grafico"></i>
					</a>
					
				</div>
				<div class="opc2 icon"> <!-- conceder acesso -->
					<a href="concederAcesso?id_rh=${rh.id}">
						<i class="fas fa-thumbs-up acesso"></i>
					</a>
					
				</div>
				<div class="opc3 icon"> <!-- verificar avaliação -->
					<a href="verificarAvaliacao?id_rh=${rh.id}">
						<i class="fas fa-copy avaliacao"></i>
					</a>
					
				</div>
				<div class="opc4 icon"> <!-- notificar avaliação -->
					<a href="notificarAvaliacao?id_rh=${rh.id}">
						<i class="fas fa-calendar-alt notificar"></i>
					</a>
					
				</div>
				<div class="opc5 icon"> <!-- checar funcionário -->
					<a href="checarFuncionario?id_rh=${rh.id}">
						<i class="fas fa-user-friends funcionario"></i>
					</a>
					
				</div>
			</div>
		</section> <!-- End Menu -->
		<!-- Container End -->
		<section id="container-end">
			<div class="parteSuperior">
				<div class="titulo">
					<p>Conferir Existência do Funcionário</p>
				</div>
				<div class="btnSair">
					<form action="index.jsp">
						<button type="submit">Sair</button>
					</form>
				</div>
			</div> <!-- End parteSuperior -->
			<div class="conteudo">
				<!-- Lista de Analistas -->
		      	<section class="listaAnalista">
		      		<div class="title">
		        		<h4>Lista de Associados</h4>
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
	        						<th class="depto-th thLista">NÍVEL</th>
	        						<th class="cargo-th thLista">CARGO</th>
	        						<th class="status-th thStatus">STATUS</th>
	        					</tr>
	        				<c:forEach var="u" items="${usuarios}">     					        				
	        					<tr class="elemLista">
	        						<td class="nome-th tdLista">${u.nome}</td>
	        						<td class="id-th tdLista">${u.id}</td>
	        						<td class="depto-th tdLista">${u.status}</td>
	        						<td class="cargo-th tdLista">${u.cargo}</td>
	        						<td class="status-th thStatus">${u.situacao}</td>
	        						<td class="btnLista">
	        							<a href="/deleteUsuario">
	        								<button type="submit">Deletar</button>
	        							</a>	        							
	        						</td>
	        					</tr>
	        				</c:forEach>	        						        					
	        							        	
	        				</tbody>
        				</table>
        			</div>
        		</div>
			</div>
		</section>
	</div>
	
</body>
</html>