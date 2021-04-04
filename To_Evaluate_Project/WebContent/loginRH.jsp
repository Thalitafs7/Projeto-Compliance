<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<%@ include file= "WEB-INF/snippets/imports/libs-head2.jsp" %>
	<link rel="stylesheet" href="css/login.css">
	<title>Entre na sua conta</title>
</head>
<body>

	<div class="container">
		<div class="box">
           <div class="textos">
               <h1 class="logo-title">TO EVALUATE</h1>
               <h3 class="logo-subtitle">Acesse a sua Conta</h3>
               <p class="subtitle-text">Por favor, insira credenciais válidas</p>    
           </div>

           <!--Formulário-->
           <form action="loginRh" class="form-login" method="post">
               <!--Email-->
               <div class="form-email">
                   <i class="fas fa-user mail"></i>
                   <input type="text" id="emailId" name="emailRh" placeholder="Email.." class="input-div" required>
                   <div class="borda-login"></div>
               </div>
               <!--Senha-->
               <div class="form-senha">
                   <i class="fas fa-lock mail"></i>
                   <input type="password" id="senhaId" name="senhaRh" placeholder="Senha.." class="input-div" required>
                   <div class="borda-login"></div>
               </div>
               
               <div class="mantenha-conectado">
                   <input type="checkbox" id="checbokLoginId">
                   <p>Mantenha-me conectado</p>
               </div>
               <div class="btn-login">
                   
                   <div class="box-1">
                       <button type="submit" class="btn-acessar btn">ACESSAR</button>
                   </div>
                   <div class="box-2">
                       <a href="cadastrar.jsp" class="btn-cadastrar btn">CADASTRAR</a>
                   </div>
               </div>
           </form>
           
           <div class="esqueceu">
               <a href="#" class="recuperar">Recuperar a senha</a>
               <a href="niveisLogin.jsp" class="sair">Sair</a>
           </div>
       </div>
	</div>
	
	<!-- ChatBot -->
	<%@ include file ="WEB-INF/snippets/chatbot.html" %>
	
	<!-- Waves -->
	<%@ include file ="WEB-INF/snippets/waves.html" %>
</body>
</html>