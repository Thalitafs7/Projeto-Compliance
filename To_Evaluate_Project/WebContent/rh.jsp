<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<%@ include file= "WEB-INF/snippets/imports/libs-head.jsp" %>
	<link rel="stylesheet" href="css/padraoRh.css">
 	<link rel="stylesheet" href="css/verificarDesempenho.css">
	<title>B2W - RH</title>
</head>
<body>
	<!-- Body Container -->
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
			<div class="parteSuperior" id="infoAux">
				<div class="titulo">
					<p> Desempenho dos Analistas</p>
				</div>
				<div class="btnSair">
					<form action="index.jsp">
						<button type="submit">Sair</button>
					</form>
				</div>
			</div> <!-- End parteSuperior -->
			
			<div class="conteudo">
				<div class="infoAux">
					<!-- Informações -->
					<section class="info">
					<c:choose>
						<c:when test="${not empty btnSelecionar}">						
				            <div class="child1">			            
				            	<div class="boxSuperior-child1">
				            		<div class="perfil-img">
				            			<div class="imgBox">
				            				<img alt="Foto de perfil ilustrativa" src="img/narcir.png">
				            			</div>			         
				            		</div>
				            				            						            		
					            		<div class="info-boxSuperior">
					            			<h3 class="h3-func">${btnSelecionar.nome}</h3>
					            			<p class="p-func">${btnSelecionar.cargo}</p>
					            		</div>
				            		</div>
					            	<div class="boxInferior-child1">
					            		<div id="depto">
					            			<h3 class="h3-func">Departamento</h3>
					            			<p class="p-func">${btnSelecionar.departamento}</p>
					            		</div>
					            		
					            		<div id="idade">
					            			<h3 class="h3-func">Idade</h3>
					            			<p class="p-func">${btnSelecionar.dt_nasc}</p>
					            		</div>
					            		
					            		<div id="gestor">
					            			<h3 class="h3-func">Gestor</h3>
					            			<p class="p-func">${btnSelecionar.getLider().getNome()}</p>
					            		</div>
					            		
					            		<div id="status">
					            			<h3 class="h3-func">Status</h3>
					            			<p class="p-func">${btnSelecionar.situacao}</p>
					            		</div>
				            		
				            		</div>		
				            			            	
				            	</div>		
							</c:when>
							<c:otherwise>
								<div class="child1">			            
				            	<div class="boxSuperior-child1">
				            		<div class="perfil-img">
				            			<div class="imgBox">
				            				<img alt="Foto de perfil ilustrativa" src="img/narcir.png">
				            			</div>			         
				            		</div>
				            				            						            		
					            		<div class="info-boxSuperior">
					            			<h3 class="h3-func">Nome</h3>
					            			<p class="p-func"></p>
					            		</div>
				            		</div>
					            	<div class="boxInferior-child1">
					            		<div id="depto">
					            			<h3 class="h3-func">Departamento</h3>
					            			<p class="p-func"></p>
					            		</div>
					            		
					            		<div id="idade">
					            			<h3 class="h3-func">Idade</h3>
					            			<p class="p-func"></p>
					            		</div>
					            		
					            		<div id="gestor">
					            			<h3 class="h3-func">Gestor</h3>
					            			<p class="p-func"></p>
					            		</div>
					            		
					            		<div id="status">
					            			<h3 class="h3-func">Status</h3>
					            			<p class="p-func"></p>
					            		</div>
				            		
				            		</div>		
				            			            	
				            	</div>		
							</c:otherwise>
						</c:choose>
						
						<!-- Child2 -->
			            <div class="child2">
				            <div class="auxChild2">
				            	<div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
								  <ol class="carousel-indicators">
								    <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
								    <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
								    <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
								  </ol>
								  <div class="carousel-inner">
								    <div class="carousel-item active">
							     		<div class="card">
								     		<div class="cardSuperior">
									     		<div class="card-icon">
									     			<i class="fas fa-calculator"></i>
									     		</div>
									     		<div class="card-title">
							            			<h4>Média Geral</h4>
							            		</div>
							            	</div>
						            		<div class="card-media">
									      		<div class="card-analista">
									      			<h3>Analista</h3>
									      			<p>80%</p>
									      		</div>
									      		<div class="card-gestor">
									      			<h3>Gestor</h3>
									      			<p>60%</p>
									      		</div>
									      	</div>						     								     
									    </div>
									 </div> 
									 
								    <div class="carousel-item">
								    	<div class="card">
								     		<div class="cardSuperior">
									     		<div class="card-icon">
									     			<i class="fas fa-clipboard"></i>
									     		</div>
									     		<div class="card-title">
							            			<h4>Notas das Skills</h4>
							            		</div>
							            	</div>
					            			<div class="card-notas">
							      				<table>
								      				<tbody>
								      					<tr>
									      					<th class="skill th">Skills</th>
									      					<th class="analista th">Analista</th>
									      					<th class="gestor th">Gestor</th>
									      				</tr>
									      				
									      				<tr>
									      					<td class="td">Java EE</td>
									      					<td class="analista center td">9</td>	
									      					<td class="gestor center td">10</td>
									      				</tr>
									      				<tr>
									      					<td class="td">Java SE</td>
									      					<td class="analista center td">9.5</td>
									      					<td class="gestor center td">10</td>
									      				</tr>
									      				<tr>
									      					<td class="td">Springboot</td>
									      					<td class="analista center td">10</td>
									      					<td class="gestor center td">10</td>
									      				</tr>
									      				<tr>
									      					<td class="td">Spring MVC</td>
									      					<td class="analista center td">9</td>
									      					<td class="gestor center td">9</td>
									      				</tr>
									      				<tr>
									      					<td class="td">Spring Framework</td>
									      					<td class="analista center td">9</td>
									      					<td class="gestor center td">9</td>
									      				</tr>
									      				<tr>
									      					<td class="td">Arquitetura MVC</td>
									      					<td class="analista center td">9</td>
									      					<td class="gestor center td">9</td>
									      				</tr>
									      				<tr>
									      					<td class="td">TomCat 9.0</td>
									      					<td class="analista center td">9.5</td>
									      					<td class="gestor center td">10</td>
									      				</tr>
									      				<tr>
									      					<td class="td">Metodologias Ágeis</td>
									      					<td class="analista center td">9</td>
									      					<td class="gestor center td">10</td>
									      				</tr>								      				
							      					</tbody>							      											      				
							      				</table>					     									     							     							     		
							    			</div>	<!-- End card-notas -->					    			
							    		</div> <!-- End card (2) -->
						    		</div>			    							    							    						
								    <div class="carousel-item">
								      <div class="card">
								     		<div class="cardSuperior">
									     		<div class="card-icon">
									     			<i class="fas fa-people-arrows"></i>
									     		</div>
									     		<div class="card-title">
							            			<h4>Analista vs Gestor</h4>
							            		</div>
							            	</div>
						            		<div class="card-notas">
												<table>
								      				<tbody>
								      					<tr>
								      						<th class="skill2 th">Skill</th>
								      						<th class="analista2 th">Analista</th>
								      						<th class="gestor2 th">Gestor</th>
								      						<th class="diferenca2 th">Diferença</th>
								      					</tr>
								      					
								      					<tr>
								      						<td class="skill-td">Java EE</td>
								      						<td class="analista-td">90%</td>
								      						<td class="gestor-td">100%</td>
								      						<td class="dif-td">-10%</td>
								      						
								      					</tr>
								      					
								      					<tr>
								      						<td class="skill-td">Java SE</td>
								      						<td class="analista-td">95%</td>
								      						<td class="gestor-td">100%</td>
								      						<td class="dif-td">-5%</td>
								      						
								      					</tr>
								      					
								      					<tr>
								      						<td class="skill-td">Springboot</td>
								      						<td class="analista-td">100%</td>
								      						<td class="gestor-td">100%</td>
								      						<td class="dif-td">0%</td>
								      						
								      					</tr>
								      					
								      					<tr>
								      						<td class="skill-td">Spring MVC</td>
								      						<td class="analista-td">90%</td>
								      						<td class="gestor-td">90%</td>
								      						<td class="dif-td">0%</td>
								      						
								      					</tr>
								      					
								      					<tr>
								      						<td class="skill-td">Spring Framework</td>
								      						<td class="analista-td">90%</td>
								      						<td class="gestor-td">90%</td>
								      						<td class="dif-td">0%</td>
								      						
								      					</tr>
								      					
								      					<tr>
								      						<td class="skill-td">Arquitetura MVC</td>
								      						<td class="analista-td">90%</td>
								      						<td class="gestor-td">90%</td>
								      						<td class="dif-td">0%</td>
								      						
								      					</tr>
								      					
								      					<tr>
								      						<td class="skill-td">TomCat 9</td>
								      						<td class="analista-td">95%</td>
								      						<td class="gestor-td">100%</td>
								      						<td class="dif-td">-5%</td>
								      						
								      					</tr>
								      					
								      					
								      					<tr>
								      						<td class="skill-td">Metodologias Ágeis</td>
								      						<td class="analista-td">90%</td>
								      						<td class="gestor-td">100%</td>
								      						<td class="dif-td">-10%</td>
								      					</tr>
								      				</tbody>
								      			</table>							      		
												<p class="card3-p"><span class="obs">Obs: </span>Na coluna "Diferença", estamos levando em 
												consideração a nota do analista em relação à nota do gestor.</p>
									      	</div>						     								     
									    </div>
		
		
								    </div>
								  </div>
								  <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
								    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
								    <span class="sr-only">Previous</span>
								  </a>
								  <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
								    <span class="carousel-control-next-icon" aria-hidden="true"></span>
								    <span class="sr-only">Next</span>
								  </a>
								</div>								      
				            
				            </div>
			            	     
		           		
			        	</div>
			        </section> <!-- End Info -->
		        
				</div>
				
		        <!-- Gráfico -->
		        <section id="grafico">
		        	<div class="title">
		        		<h4>Gráfico</h4>
		        		<hr>
		        	</div>		        	
		        	<div class="graphic">
		        		<div class="canvas">
		        			<canvas id="primeiroGrafico"></canvas>
		        		</div>		        			        	
		        	</div>		     		        	
		        </section> <!-- End grafico -->
		        
		      	<!-- Lista de Analistas -->
		      	<section class="listaAnalista">
		      		<div class="title">
		        		<h4>Lista de Analistas</h4>
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
		        	
		        	<div class="lista">
		        		<div class="listaContent">		        
		        			<table>
		        				<tbody>
		        					<tr>		        						
		        						<th class="nome-th thLista">NOME</th>
		        						<th class="id-th thLista">ID</th>
		        						<th class="depto-th thLista">DEPARTAMENTO</th>
		        						<th class="cargo-th thLista">CARGO</th>
		        					</tr>
		        					<c:forEach var="a" items="${lista}">
		        						<tr class="elemLista">
			        						<td class="nome-th tdLista">${a.nome}</td>
			        						<td class="id-th tdLista">${a.id}</td>
			        						<td class="depto-th tdLista">${a.departamento}</td>
			        						<td class="cargo-th tdLista">${a.cargo}</td>
			        						<td class="btnLista">
			        							
			        							<a href="verificarDesempenhoSelecionarAnalista?id_analista=${a.id}&id_rh=${rh.id}">
				        							<button type="submit">
				        								Selecionar
				        							</button>
			        							</a> 
			        						</td>
			        					</tr>
		        				    </c:forEach>				
		        					
	        	
		        				</tbody>
		        			</table>
		        		</div>
		        	</div>
		        		 
		      	
		      	</section> <!-- End listaAnalista -->		    
		      	
			
			</div> <!-- End conteudo -->		
		</section> <!-- End container-End -->
		
		
	</div> <!-- End body-container -->
	

<script src="https://cdn.jsdelivr.net/npm/chart.js@2.8.0"></script>
<script>
	let primeiroGrafico = document.getElementById('primeiroGrafico').getContext('2d');
	
	let chart = new Chart(primeiroGrafico, {
		type: "line",
		data: {
	        labels: ['Java EE', 'Java SE', 'Springboot', 'Spring MVC', 'Spring Framework', 'Arquitetura MVC', 'TomCat', 'Metodologias Ageis'],
	        datasets: [{
	            label: "Notas do Analista", 
	            data: [9, 9.5, 10, 9, 9, 9, 9.5, 9], 
	            backgroundColor: "rgba(0, 255, 255, 0.5)", 
	            borderColor: "#16697a"
	        } , {
	            label: "Notas do Gestor", 
	            data: [10, 10, 10, 9, 9, 9, 9, 10, 10], 
	            backgroundColor: "rgba(7, 165, 255, 0.5)", 
	            borderColor: "#28abb9"
	        
	        }]
	    }
	}); 
	
		

</script>

<%@ include file ="WEB-INF/snippets/imports/libs-footer.jsp" %>
</body>
</html>