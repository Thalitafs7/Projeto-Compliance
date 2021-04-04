<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
 	<%@ include file= "WEB-INF/snippets/imports/libs-head2.jsp" %>
 	<link rel="stylesheet" href="css/analista.css">
 	<link rel="stylesheet" href="css/equipes.css">
	<title>B2W - Analista ${analista.nome}</title>
</head>
<body>

	<c:if test="${empty id}">
		<jsp:forward page="loginAnalista.jsp"></jsp:forward>
	</c:if>
	
	<!-- Header -->
	<%@ include file ="WEB-INF/snippets/analista/header.html" %>
	
	<!-- Plano de Fundo -->
	<%@ include file ="WEB-INF/snippets/fundo.html" %>
	
	<!-- Container -->
	<div class="container">
		<!-- Titulo -->
		<section class="section-titulo">
            <h1 class="titulo">Olá, ${analista.nome}</h1>
            <p class="texto">Verifique se você possui alguma avaliação para hoje..</p>
        </section>
		
		<!-- Informações -->
		<section class="info">
            <div class="box-img"> 
                <div class="img-profile">
                    <img src="./img/profile-img2.png" alt="Foto de perfil do usuário">
                </div>
            </div>

            <div class="dados">
                <div class="dados-1">
                    <p class="em">Nome:</p>
                    <p class="nome tds">${analista.nome}</p>
                    <p class="em">ID:</p>
                    <p class="id tds">${analista.id}</p>
                    <p class="em email-aux">Gestor:</p>
                    <p class="email tds">${analista.getLider().nome}</p>
                </div>
                <div class="dados-2">
                    <p class="em">Cargo:</p>
                    <p class="cargo tds-2">${analista.cargo}</p>
                    <p class="em">Skills:</p>
                    <p class="skills tds-2">
                        ...
                    </p>
                </div>
            </div>
        </section>
		
		<!-- Caixas -->
		<%@ include file ="WEB-INF/snippets/analista/caixas.html" %>
	
		<hr>
		
		<!-- Container Middle -->
		<div class="container-middle">
			<!-- Pendências -->
			<%@ include file ="WEB-INF/snippets/analista/pendencias.html" %>
			
			<!-- Chatbot -->
			<%@ include file ="WEB-INF/snippets/chatbot.html" %>
								
		</div>
		
		<p class="equipe"><a href="analistaConfiguracoes?id_analista=${analista.id}">Configurações</a></p>
		
		<!-- Footer -->
		<%@ include file ="WEB-INF/snippets/rodape-padrao.html" %>
	</div>
	
	<!-- imports -->
	<%@ include file= "WEB-INF/snippets/imports/libs-footer.jsp" %>
</body>
</html>