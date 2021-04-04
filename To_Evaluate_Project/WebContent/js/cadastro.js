function jobType(id) {
	var cargo = document.getElementById(id);
	
	if (cargo.value == "analista") {
		console.log("If do analista");
		
		return document.getElementById("formu").innerHTML = `
		<form action="criar" method="post">
       	   <!--Cargo-->
           <div class="cargo">
               <p>Cargo</p>
               <select name="cargo" id="cargoId" class="input-div" required="required" onchange="jobType(this.id)">
                   <option value="analista">Analista</option>
                   <option value="gestor">Gestor</option>
                   <option value="rh">RH</option>
               </select>
           </div>
			
           <!--Nome-->
           <div class="nome">
               <p>Nome</p>
               <input type="text" name="nome" id="nomeId" class="input-div" placeholder="Thalita" required="required">
           </div>
           <!--Sobrenome-->
           <div class="sobrenome">
               <p>Sobrenome</p>
               <input type="text" name="sobrenome" id="sobrenomeId" class="input-div" placeholder="Feitosa" required="required">
           </div>
           <!--Nascimento-->
           <div class="dtnasc">
               <p>Nascimento</p>
               <input type="date" name="dtNasc" id="dtNascId" class="input-div" placeholder="   /   /" required="required">
           </div>
           <!--Telefone-->
           <div class="telefone">
               <p>Telefone</p>
               <input type="tel" name="telefone" id="telefoneId" class="input-div" placeholder="(11) 9999-9999" required="required">
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
               <input type="text" name="email" id="emailId" class="input-div" placeholder="thalitafeitosa@b2w.com" required="required">
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
		`;
		
	} 
	
	if (cargo.value == "gestor") {
		console.log("If do gestor");
		
		return document.getElementById("formu").innerHTML = `
		<form action="criar" method="post">
			<!--Cargo-->
			<div class="cargo">
			    <p>Cargo</p>
			    <select name="cargo" id="cargoId" class="input-div" required="required" onchange="jobType(this.id)">
					<option value="gestor">Gestor</option>		
					<option value="rh">RH</option>	        
					<option value="analista">Analista</option>
			    </select>
			</div>
			<!--Nome-->
			<div class="nome">
			    <p>Nome</p>
			    <input type="text" name="nome" id="nomeId" class="input-div" placeholder="Emily" required="required">
			</div>
			<!--Sobrenome-->
			<div class="sobrenome">
			    <p>Sobrenome</p>
			    <input type="text" name="sobrenome" id="sobrenomeId" class="input-div" placeholder="Cunha" required="required">
			</div>
			<!--Nascimento-->
			<div class="dtnasc">
			    <p>Nascimento</p>
			    <input type="date" name="dtNasc" id="dtNascId" class="input-div" placeholder="   /   /" required="required">
			</div>
			<!--Telefone-->
			<div class="telefone">
			    <p>Telefone</p>
			    <input type="text" name="telefone" id="telefoneId" class="input-div" placeholder="(13) 9999-9999" required="required">
			</div>
			<!-- depto -->
			<div class="id-depto">
			    <p>Departamento</p>
			    <input type="text" name="departamento" id="deptoId" class="input-div" placeholder="Tecnologia" required="required">
			</div>
			<!--Email-->
			<div class="email">
			    <p>Email</p>
			    <input type="text" name="email" id="emailId" class="input-div" placeholder="emilycunha@b2w.com" required="required">
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
		`;
		
	}
	
	if (cargo.value == "rh") {
		console.log("If do rh");
		
		return document.getElementById("formu").innerHTML = `
		<form action="criar" method="post">
       	   <!--Cargo-->
           <div class="cargo">
               <p>Cargo</p>
               <select name="cargo" id="cargoId" class="input-div" required="required" onchange="jobType(this.id)">
				   <option value="rh">RH</option>
                   <option value="analista">Analista</option>
                   <option value="gestor">Gestor</option>
               </select>
           </div>
           <!--Nome-->
           <div class="nome">
               <p>Nome</p>
               <input type="text" name="nome" id="nomeId" class="input-div" placeholder="Larissa" required="required">
           </div>
           <!--Sobrenome-->
           <div class="sobrenome">
               <p>Sobrenome</p>
               <input type="text" name="sobrenome" id="sobrenomeId" class="input-div" placeholder="Santos" required="required">
           </div>
           <!--Nascimento-->
           <div class="dtnasc">
               <p>Nascimento</p>
               <input type="date" name="dtNasc" id="dtNascId" class="input-div" placeholder="   /   /" required="required">
           </div>
           <!--Telefone-->
           <div class="telefone">
               <p>Telefone</p>
               <input type="tel" name="telefone" id="telefoneId" class="input-div" placeholder="(21) 9999-9999" required="required">
           </div>

           <!--Email-->
           <div class="email">
               <p>Email</p>
               <input type="text" name="email" id="emailId" class="input-div" placeholder="larisantos@b2w.com" required="required">
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
		`;
	}
	
	
}