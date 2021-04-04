<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<%@ include file ="WEB-INF/snippets/imports/libs-head2.jsp" %>
	<link rel="stylesheet" href="css/loginGestor.css">
	<title>Entre na sua conta</title>
</head>
<body>
	<!-- Container Start -->
	<div class="container-start">
		<!-- Logo Linc Tech -->
		<%@ include file ="WEB-INF/snippets/logo.html" %>  
		
		<!-- Waves -->
		<%@ include file ="WEB-INF/snippets/waves.html" %>
		
		<!-- ChatBot -->
		<%@ include file ="WEB-INF/snippets/chatbot.html" %>
	</div>
	
	<div class="btnVoltar"> <!-- Btn Voltar -->
		<a href="niveisLogin.jsp">
			<i class="fas fa-arrow-right btn-cadastrar"></i>
		</a>
	</div>
	<!-- Container End -->
	<div class="container-end">
		<div class="titulo"> <!-- Títulos do login -->
			<h1>TO EVALUATE</h1>
			<h3>Acesse a sua conta</h3>
		</div>
		<div class="boxLogin">
			<form action="loginGestor" method="post"> <!-- Formulário -->
				<div class="aux">
					<!-- Email -->
	                <div class="email">
	                  <p>Email</p>
	                  <input type="text" name="emailGestor" value="" placeholder="gestor@b2w.com.br" required="required">
	                </div>
	                <!-- Senha -->
	                <div class="senha">
	                  <p>Senha</p>
	                  <input type="password" name="senhaGestor" value="" placeholder="***************" required="required">
	                </div>
				</div>
                  
                <!-- Parte Inferior -->
				<%@ include file ="WEB-INF/snippets/login/analista/container-endInferior.html" %> <!-- Estou reutilizando do Analista -->
        	</form>
		</div>
		<div class="cadastrar"> <!-- Cadastre-se -->
			<p>Ainda não possui uma conta?<a href="cadastrar.jsp">Cadastre-se</a></p>
		</div>
	</div>
	
</body>
</html>