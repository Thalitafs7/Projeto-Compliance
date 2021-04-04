<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<%@include file="WEB-INF/snippets/imports/libs-head.jsp"%>
	<link rel="stylesheet" href="css/indexRh.css">
	<link rel="stylesheet" href="css/padraoRh.css">
	<title>B2W - RH ${rh.nome}</title>
</head>
<body>
	<c:if test="${empty id}">
		<jsp:forward page="loginRH.jsp"></jsp:forward>
	</c:if>

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
			<div class="auxDivSuperior">			
				<div class="parteSuperior">
					<div class="titulo">
						<p>Seja bem-vindo à plataforma!</p>
					</div>
					<div class="btnSair">
						<form action="index.jsp">
							<button type="submit">Sair</button>
						</form>
					</div>
				</div> <!-- End parteSuperior -->
				<div class="configuracao">
					<a href="rhConfiguracoes?id_rh=${rh.id}">
						<i class="fas fa-cog"></i>
					</a>					
				</div>
			</div>
			<div class="conteudo">
				<div class="titulo-index">
					<h3>Olá, ${rh.nome}...</h3>
					<p>Estamos aqui para te auxiliar a visualizar melhor como está sendo a Emplyoee Experience dos
					seus colaboradores</p>
				</div>
				
				<div class="botoes">
				   <div class="button">
				       <a href="verificarDesempenhoListaAnalista?id_rh=${rh.id}">
				       <span></span>
				       <span></span>
				       <span></span>
				       <span></span>
				       VERIFIFICAR DESEMPENHOS    
				       </a>
				   </div>
				   <div class="button">
				       <a href="concederAcesso?id_rh=${rh.id}">
				       <span></span>
				       <span></span>
				       <span></span>
				       <span></span>
				       CONCEDOR ACESSO       
				       </a>
				   </div>
				   <div class="button">
				       <a href="verificarAvaliacao?id_rh=${rh.id}">
				       <span></span>
				       <span></span>
				       <span></span>
				       <span></span>
				       VERIFICAR AVALIAÇÕES
				       </a>
				   </div>
				   <div class="button">
				       <a href="notificarAvaliacao?id_rh=${rh.id}">
				       <span></span>
				       <span></span>
				       <span></span>
				       <span></span>
				       NOTIFICAR AVALIAÇÕES
				       </a>
				   </div>
				   <div class="button">
				       <a href="checarFuncionario?id_rh=${rh.id}">
				       <span></span>
				       <span></span>
				       <span></span>
				       <span></span>
				       CONFERIR COLABORADOR
				       </a>
				   </div>
				</div>

			</div>
		</section>
	</div>
	
</body>
</html>