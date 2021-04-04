package br.com.toevaluate.bo;

import java.util.List;

import br.com.toevaluate.beans.Login;
import br.com.toevaluate.beans.Usuario;
import br.com.toevaluate.dao.UsuarioDAO;

public class UsuarioBO {

	public Usuario logar(Login login) throws Exception{
		return null;
	}
	
	public String delete(int idFunc)throws Exception{
        UsuarioDAO dao = new UsuarioDAO();
        dao.deleteFunci(idFunc);
        dao.fecharBanco();
        return "Usuario apagado";
    }
	
	public List<Usuario> listar() throws Exception {
		UsuarioDAO dao = new UsuarioDAO();
		List<Usuario> resp = new UsuarioDAO().listar();

		for (Usuario u : resp) {
			if (u.getStatus().toUpperCase().equals("SIM")) {
				u.setStatus("GESTOR");
			} else if (u.getDepartamento().toUpperCase().equalsIgnoreCase("RH")
					|| u.getDepartamento().toUpperCase().equalsIgnoreCase("RECURSOS HUMANOS")) {
				u.setStatus("RH");
			} else {
				u.setStatus("ANALISTA");
			}

		}
		dao.fecharBanco();
		return resp;
	}
	
}
