<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<%@ include file = "WEB-INF/snippets/imports/libs-head.jsp" %>
	<link rel="stylesheet" href="css/index.css">
	<title>Linc Tech - To Evaluate</title>
</head>
<body>

	<!-- Header -->
	<%@ include file= "WEB-INF/snippets/index/header.html" %>
	
	<!-- Main -->
	<div class="main">
		<div class="container-nav">
			<%@ include file= "WEB-INF/snippets/index/main.html" %>
			<%@ include file= "WEB-INF/snippets/chatbot.html" %>
		</div>
	</div>
	
	<%@ include file= "WEB-INF/snippets/waves.html" %>
	
	
	<!-- imports -->
	<%@ include file="WEB-INF/snippets/imports/libs-footer.jsp" %>
</body>
</html>