<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<%@ include file ="WEB-INF/snippets/imports/libs-head2.jsp" %>	
	<link rel="stylesheet" href="css/notificacao.css">

	<title>RH - Notificação</title>
</head>
<body>
	<!-- Header -->
	<%@ include file ="WEB-INF/snippets/analista/header.html" %>
	
	<!-- Plano de Fundo -->
	<%@ include file ="WEB-INF/snippets/fundo.html" %>
	
	<!-- Container -->
	<div class="container">
		<h1 class="notificacao">Notificação</h1>
	    <section class="skills">
	        <div class="div-funcionario">
	            <div class="box-img"> 
	                <div class="img-profile">
	                    <img src="./img/profile-img2.png" alt="Foto de perfil do usuário">
	                </div>
	        </div>        
	            <h2>Juninho</h2>
	        <p>Gestor: Hélio</p>
	        <p>Skills: Java, Bootstrap, Javascript, Git</p>
	        <p>Ultima avaliação: 23/08/2020</p>
	        <button>Notificar</button>
	         </div>
	
	         <div class="div-funcionario">
	            <div class="box-img"> 
	                <div class="img-profile">
	                    <img src="./img/profile-img2.png" alt="Foto de perfil do usuário">
	                </div>
	        </div>  
	            <h2>Mateus Ramos</h2>
	        
	        <p>Gestor: Alexandre</p>
	        <p>Skills: Java, Bootstrap, Javascript, SQL</p>
	        <p>Ultima avaliação: 23/09/2020</p>
	        <button>Notificar</button>
	         </div>
	
	
	         <div class="div-funcionario">
	            <div class="box-img"> 
	                <div class="img-profile">
	                    <img src="./img/profile-img2.png" alt="Foto de perfil do usuário">
	                </div>
	        </div>  
	            <h2>Mateus Ramos</h2>
	        
	        <p>Gestor: Alexandre</p>
	        <p>Skills: Java, Bootstrap, Javascript, SQL</p>
	        <p>Ultima avaliação: 23/09/2020</p>
	        <button>Notificar</button>
	         </div>
	
	         <div class="div-funcionario">
	            <div class="box-img"> 
	                <div class="img-profile">
	                    <img src="./img/profile-img2.png" alt="Foto de perfil do usuário">
	                </div>
	        </div>  
	            <h2>Larissa</h2>
	            <p>Gestor: Bruna</p>
	            <p>Skills: SQL, Bootstrap, Javascript</p>
	            <p>Ultima avaliação: 05/08/2020</p>
	            <button>Notificar</button>
	         </div>
	
	         <div class="div-funcionario">
	            <div class="box-img"> 
	                <div class="img-profile">
	                    <img src="./img/profile-img2.png" alt="Foto de perfil do usuário">
	                </div>
	        </div>  
	            <h2>Gabriel Carvalho</h2>
	            <p>Gestor: João</p>
	            <p>Skills: Java, Flutter, Javascript</p>
	            <p>Ultima avaliação: 23/08/2020</p>
	            <button>Notificar</button>
	         </div>
	
	         <div class="div-funcionario">
	            <div class="box-img"> 
	                <div class="img-profile">
	                    <img src="./img/profile-img2.png" alt="Foto de perfil do usuário">
	                </div>
	        </div>  
	            <h2>Gabriel Lucas</h2>
	            <p>Gestor: Alexandre</p>
	            <p>Skills: HTML, Bootstrap, Javascript</p>
	            <p>Ultima avaliação: 23/09/2020</p>
	            <button>Notificar</button>
	         </div>
	
	         <div class="div-funcionario">
	            <div class="box-img"> 
	                <div class="img-profile">
	                    <img src="./img/profile-img2.png" alt="Foto de perfil do usuário">
	                </div>
	        </div>  
	            <h2>Emily Vasconcelos</h2>
	            <p>Gestor: Andrey</p>
	            <p>Skills: Java, SQL, CSS, HTML</p>
	            <p>Ultima avaliação: 11/10/2020</p>
	            <button>Notificar</button>
	         </div>
	
	         <div class="div-funcionario">
	            <div class="box-img"> 
	                <div class="img-profile">
	                    <img src="./img/profile-img2.png" alt="Foto de perfil do usuário">
	                </div>
	        	</div>  
	            <h2>Thalita Feitosa</h2>
	            <p>Gestor: Humberto</p>
	            <p>Skills: Python, CSS, HTML</p>
	            <p>Ultima avaliação: 02/05/2020</p>
	            <button>Notificar</button>
         	</div>
         	
         	<!-- Chatbot -->
         	<%@ include file ="WEB-INF/snippets/chatbot.html" %>
         	
		</section>
	</div>
	<!-- Footer -->
	<%@ include file ="WEB-INF/snippets/rodape-padrao.html" %>	
</body>
</html>