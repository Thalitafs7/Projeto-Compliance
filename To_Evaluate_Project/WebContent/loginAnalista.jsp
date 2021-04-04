<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<%@ include file ="WEB-INF/snippets/imports/libs-head2.jsp" %>
	<link rel="stylesheet" href="./css/loginAnalista.css">
	<title>Entre na sua conta</title>
</head>
<body>
	<!-- Container Start -->
	<div class="container-start">
		<%@ include file ="WEB-INF/snippets/login/analista/container-start.html" %>
		
		<!-- ChatBot -->
		<%@ include file ="WEB-INF/snippets/chatbot.html" %>
	</div>
	
	
	<!-- Container End -->
	<div class="container-end">
		<!-- Superior -->
		<%@ include file="WEB-INF/snippets/login/analista/container-endSuperior.html" %>
		
		<div class="boxLogin">
			<form class="" action="loginAnalista" method="post"> <!-- Formulário -->
				<div class="aux">
					<!-- Email -->
					<div class="email">
					  <p>Email</p>
					  <input type="text" name="emailAnalista" value="" placeholder="analista@b2w.com.br" required="required">
					</div>
					<!-- Senha -->
					<div class="senha">
					  <p>Senha</p>
					  <input type="password" name="senhaAnalista" value="" placeholder="***************" required="required">
					</div>
				</div>
                   
				<!-- Parte Inferior -->
				<%@ include file ="WEB-INF/snippets/login/analista/container-endInferior.html" %> 
                  
        	</form>
        </div>
       	<div class="cadastrar"> <!-- Cadastre-se -->
			<p>Ainda não possui uma conta?<a href="cadastrar.jsp">Cadastre-se</a></p>
		</div>	
	</div>
	
</body>
</html>