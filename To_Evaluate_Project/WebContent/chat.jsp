<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<%@ include file ="WEB-INF/snippets/imports/libs-head.jsp" %>
	<link rel="stylesheet" href="css/main.css">
	<title>Chatbot To Evaluate</title>
</head>
<body>
	<div class="principal">
		<h2>Converse aqui:</h2>
		<div class="conversa">
			<span>Digitando ...</span>
		</div>
		<input
			type="text"
			id="pergunta"
			name="pergunta"
			class="campo"
			placeholder="Digite sua pergunta"
		/>
		<button id="enviar" onclick="carregarDados()">Enviar</button>
	</div>
	
	<script type="text/javascript" src="./js/main.js"></script>
</body>
</html>