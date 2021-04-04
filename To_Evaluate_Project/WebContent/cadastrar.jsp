<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<%@ include file ="WEB-INF/snippets/imports/libs-head2.jsp" %>
	<link rel="stylesheet" href="css/cadastrar.css">
	<title>Cadastre-se</title>
</head>
<body>

	<div class="container">
		<!-- Container Two -->
		<%@ include file ="WEB-INF/snippets/cadastrar/container-two.html" %>
		
		<!-- Container Login -->
		<div class="container-login">
           <div class="login">
               <div class="texto">
                   <h1>Seja um Evaluate</h1>
                   <p>Certifique-se que você está evoluindo e cadastre-se</p>
               </div>
               	
               <div class="formulario" id="formu">
               <c:choose>
               		<c:when test="${param.resp eq 'ok'}">
               			<p style="color:red;">${param.msg}</p>
               		</c:when>               		
               	</c:choose>
                   <form action="criar" method="post">
                   	   <!--Cargo-->
                       <div class="acesso">
                           <p>Acesso</p>
                           <select name="cargo" id="acessoId" class="input-div" required="required" onchange="jobType(this.id)">
                               <option value="analista">Analista</option>
                               <option value="gestor">Gestor</option>
                               <option value="rh">RH</option>
                           </select>
                       </div>
                        <!--Tipo Cargo-->
                       <div class="cargo">
                           <p>Cargo</p>
                           <input type="text" name="tipoCargo" id="cargoId" class="input-div" placeholder="Software Engineer" required="required">
                       </div>
                       <!--Nome-->
                       <div class="nome">
                           <p>Nome</p>
                           <input type="text" name="nome" id="nomeId" class="input-div" placeholder="Mateus" required="required">
                       </div>
                       <!--Sobrenome-->
                       <div class="sobrenome">
                           <p>Sobrenome</p>
                           <input type="text" name="sobrenome" id="sobrenomeId" class="input-div" placeholder="Carvalho" required="required">
                       </div>
                       <!--Nascimento-->
                       <div class="dtnasc">
                           <p>Nascimento</p>
                           <input type="date" name="dtNasc" id="dtNascId" class="input-div" placeholder="   /   /" required="required">
                       </div>
                       <!--Telefone-->
                       <div class="telefone">
                           <p>Telefone</p>
                           <input type="tel" required="required" id="telefoneId" class="input-div" placeholder="Número"  maxlength="11" name="telefone" pattern="\([0-9]{​​2}​​\) [0-9]{​​4,6}​​-[0-9]{​​3,4}​​$">
                       </div>
                       <!-- ID -->
						<div class="idGestor">
						    <p>ID</p>
						    <input type="text" name="idGestor" id="idGestor" class="input-div" placeholder="ID do seu gestor" required="required">
						</div>
						<!-- depto -->
						<div class="id-depto">
						    <p>Departamento</p>
						    <input type="text" name="departamento" id="deptoId" class="input-div" placeholder="Tecnologia" required="required">
						</div>
                       <!--Email-->
                       <div class="email">
                           <p>Email</p>
                           <input type="text" name="email" id="emailId" class="input-div" placeholder="mateuscarvalho@b2w.com" required="required">
                       </div>
                       <!--Senha-->
                       <div class="senha">
                           <p>Senha</p>
                           <input type="password" name="senha" id="senhaId" class="input-div" placeholder="************" required="required">
                       </div>
                       <!--Botões-->
	                   <div class="botoes">
	                   		<button type="submit" class="btn">
	                   		 	<i class="fas fa-arrow-right btn-cadastrar"></i>
	                   		</button>
	                   </div>
                   
                   </form>
               </div>
           </div>
       </div>
	</div>
	
	<!-- Footer -->
	<%@ include file ="WEB-INF/snippets/cadastrar/footer.html" %>
	<script type="text/javascript" charset="UTF-8" src="js/cadastrar.js"></script>
</body>
</html>