<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<%@ include file ="WEB-INF/snippets/imports/libs-head.jsp" %>
	<link rel="stylesheet" href="css/analista.css">
	<title>B2W - Gestor ${nmGestor}</title>
</head>
<body>
<%-- 	<c:choose>
		<c:when test="${empty id}">
			<jsp:forward page="loginGestor.jsp" />
		</c:when>
	</c:choose> --%>
    <!-- Header -->
    <%@ include file ="WEB-INF/snippets/analista/header.html" %> <!-- ESTOU USANDO DO ANALISTA -->
    
    <!-- Plano de fundo -->
    <%@ include file ="WEB-INF/snippets/fundo.html" %>
    
    <!-- Container -->
    <div class="container">
        <!-- Título -->
        <section class="section-titulo">
            <h1 class="titulo">Olá, ${gestor.nome }</h1>
            <p class="texto">Verifique se você possui alguma avaliação para hoje..</p>
        </section>
        
        <!-- Informações -->
        <section class="info">
            <div class="box-img"> 
                <div class="img-profile-gestor">
                    <img src="./img/narcir.png" alt="Foto de perfil do usuário">
                </div>
            </div>
    
            <div class="dados">
                <div class="dados-1">
                    <p class="em">Nome:</p>
                    <p class="nome tds">${gestor.nome}</p>
                    <p class="em">ID:</p>
                    <p class="id tds">${gestor.id}</p>
                    <p class="em email-aux">Data de Nascimento:</br></p>
                    <p class="email tds">${gestor.dt_nasc}</p>
                </div>
                <div class="dados-2">
                    <p class="em">Cargo:</p>
                    <p class="cargo tds-2">${gestor.cargo}</p>
                    <p class="em">Time :</p>
                  <!--  <p class="skills tds-2">
                        Marília, Dolores, Carlos Cláudio, Anitta, 
                        Lexa, IZA e Jeferson
                    </p>-->  
                </div>
            </div>
        </section>
        
        <!-- Caixas -->
        <%@ include file ="WEB-INF/snippets/analista/caixas.html" %> <!-- ESTOU USANDO DO ANALISTA -->
        
        <hr>
        
        <!-- Container middle -->
        <div class="container-middle">
            <section class="avaliacoes">
                <div class="box-avaliacoes" data-toggle="modal" data-target="#lista">
                    <h4 class="title">Avaliação</h4>
                    <div class="id-avaliacao">
                        <h4 class="h4-avaliacao">ID:</h4>
                        <p class="p-avaliacao">3212</p> 
                    </div>
                    <div class="datas">
                        <div class="dtEmissao">
                            <h4 class="h4-avaliacao">Data Emissão</h4>
                            <p class="p-avaliacao">27/10/2020</p>
                        </div>
                        <div class="dtLimite">
                            <h4 class="h4-avaliacao">Data Limite</h4>
                            <p class="p-avaliacao">03/11/2020</p>
                        </div>
                    </div>
                    
                   
                </div>
            </section>          
            <!-- Modal -->
            <div class="modal fade" id="lista" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
              <div class="modal-dialog modal-lg">
                <div class="modal-content">
                  <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Avaliação</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                      <span aria-hidden="true">&times;</span>
                    </button>
                  </div>
                  <div class="modal-body">
                    <div class="lista">
                        <div class="listaContent">
                            <table>
                                <tbody>
                                    <tr>                                        
                                        <th class="nome-th thLista">NOME</th>
                                        <th class="cargo-th thLista">CARGO</th>
                                    </tr>                           
                                    <tr class="elemLista">
                                        <td class="nome-th tdLista">${gestor.nome}</td>
                                        <td class="cargo-th tdLista">${gestor.cargo}</td>
                                        <td class="btnLista">
                                            <button type="submit" data-toggle="modal" data-target="#staticBackdrop">Avaliar</button>
                                        </td>
                                    </tr>
                                    <tr class="elemLista">
                                        <td class="nome-th tdLista">Emily Cunha</td>
                                        <td class="cargo-th tdLista">Palhaça</td>
                                        <td class="btnLista">
                                            <button type="submit" data-toggle="modal" data-target="#staticBackdrop">Avaliar</button>
                                        </td>
                                    </tr>
                                    <tr class="elemLista">
                                        <td class="nome-th tdLista">Arthur Lucas</td>
                                        <td class="cargo-th tdLista">Analista de Mídia</td>
                                        <td class="btnLista">
                                            <button type="submit" data-toggle="modal" data-target="#staticBackdrop">Avaliar</button>
                                        </td>
                                    </tr>
                                    <tr class="elemLista">
                                        <td class="nome-th tdLista">Mateus Ramos</td>
                                        <td class="cargo-th tdLista">Nodejs Full-Stack Developer</td>
                                        <td class="btnLista">
                                            <button type="submit" data-toggle="modal" data-target="#staticBackdrop">Avaliar</button>
                                        </td>
                                    </tr>
                                    <tr class="elemLista">
                                        <td class="nome-th tdLista">Gabriel Carvalho</td>
                                        <td class="cargo-th tdLista">Senior Quality Assurance</td>
                                        <td class="btnLista">
                                            <button type="submit" data-toggle="modal" data-target="#staticBackdrop">Avaliar</button>
                                        </td>
                                    </tr>
                                    <tr class="elemLista">
                                        <td class="nome-th tdLista">Thalita Feitosa</td>
                                        <td class="cargo-th tdLista">Oracle Database Administrator</td>
                                        <td class="btnLista">
                                            <button type="submit" data-toggle="modal" data-target="#staticBackdrop">Avaliar</button>
                                        </td>
                                    </tr>
                                    <tr class="elemLista">
                                        <td class="nome-th tdLista">Thalita Feitosa</td>
                                        <td class="cargo-th tdLista">Oracle Database Administrator</td>
                                        <td class="btnLista">
                                            <button type="submit" data-toggle="modal" data-target="#staticBackdrop">Avaliar</button>
                                        </td>
                                    </tr>
                                    
                                    
                                                        
                                </tbody>
                            </table>
                                
                            <!-- Modal -->
                            <div class="modal fade" id="staticBackdrop" data-backdrop="static" data-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
                              <div class="modal-dialog modal-dialog-centered modal-dialog-scrollable">
                                <div class="modal-content">
                                  <div class="modal-header">
                                    <h5 class="modal-title" id="staticBackdropLabel">Avaliar Skill</h5>
                                    <button type="button" class="close"  aria-label="Close" onclick="modalClose()">
                                      <span aria-hidden="true">&times;</span>
                                    </button>
                                  </div>
                                  <div class="modal-body">
                                    <form action="#staticBackdrop" class="avaliandoSkill">
                                      <div class="form-group">
                                        <label for="exampleInputEmail1">Python</label>
                                        <input type="text" name="nmSkill" class="form-control" id="exampleInputEmail1" required="required">
                                      </div>
                                      <div class="form-group">
                                        <label for="exampleInputEmail1">Java</label>
                                        <input type="text" name="nmSkill" class="form-control" id="exampleInputEmail1" required="required">
                                      </div>
                                      <div class="form-group">
                                        <label for="exampleInputEmail1">Web</label>
                                        <input type="text" name="nmSkill" class="form-control" id="exampleInputEmail1" required="required">
                                      </div>
                                      
                                      <button type="submit" class="btn btn-primary">Enviar</button>
                                    </form>
                                    
                                    
                                  </div>
                                </div>
                              </div>
                            </div>

                      </div>
                    </div>
                  </div>
                  <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Fechar</button>
                  </div>
                </div>
              </div>
            </div>
            
            
            <!-- Chatbot -->
            <%@ include file ="WEB-INF/snippets/chatbot.html" %>
            
        </div>
        
        <p class="equipe"><a href="equipe.jsp">Acessar Equipe</a></p>
        <p class="equipe"><a href="gestorConfiguracoes?id=${gestor.id}">Configurações</a></p>
        
        <!-- Footer -->
        <%@ include file ="WEB-INF/snippets/rodape-padrao.html" %>
    </div>

    <!-- imports -->
    <%@ include file ="WEB-INF/snippets/imports/libs-footer.jsp" %>
    
    <script>
        function modalClose() {
            $('#staticBackdrop').modal('hide');
        }
        
    
    </script>
</body>
</html>