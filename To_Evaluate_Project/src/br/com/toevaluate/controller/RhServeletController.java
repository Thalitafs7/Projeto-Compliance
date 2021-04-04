package br.com.toevaluate.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.toevaluate.Exception.Excecao;
import br.com.toevaluate.beans.Analista;
import br.com.toevaluate.beans.Login;
import br.com.toevaluate.beans.Rh;
import br.com.toevaluate.beans.Telefone;
import br.com.toevaluate.beans.Usuario;
import br.com.toevaluate.bo.AnalistaBO;
import br.com.toevaluate.bo.LoginBO;
import br.com.toevaluate.bo.RhBO;
import br.com.toevaluate.bo.TelefoneBO;
import br.com.toevaluate.bo.UsuarioBO;
import br.com.toevaluate.dao.LoginDAO;
import br.com.toevaluate.dao.RhDAO;

/**
 * Servlet implementation class RhServeletController
 */
@WebServlet({ "/RhServeletController", "/verificarDesempenhoListaAnalista", "/updateRh", "/deleteUsuario", "/verificarDesempenhoSelecionarAnalista", 
	"/checarFuncionario", "/notificarAvaliacao", "/concederAcesso", "/verificarAvaliacao", "/rhConfiguracoes", "/rhIndex"})
public class RhServeletController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RhServeletController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		switch (request.getRequestURI()) {
			case "/To_Evaluate_Project/verificarDesempenhoListaAnalista": 
				verificarDesempenhoListaAnalista(request, response, Integer.parseInt(request.getParameter("id_rh")));
				break;
				
				
			case "/To_Evaluate_Project/verificarDesempenhoSelecionarAnalista":
				verificarDesempenhoSelecionarAnalista(request, response, Integer.parseInt(request.getParameter("id_analista")), Integer.parseInt(request.getParameter("id_rh")));
				break;
			
			case "/To_Evaluate_Project/deleteUsuario":
				deleteUsuario(request, response, Integer.parseInt(request.getParameter("id")), Integer.parseInt(request.getParameter("id_rh")));
				break;
				
			case "/To_Evaluate_Project/checarFuncionario":
				checarFuncionario(request, response, Integer.parseInt(request.getParameter("id_rh")));
				break;
				
			case "/To_Evaluate_Project/notificarAvaliacao":
				notificarAvaliacao(request, response, Integer.parseInt(request.getParameter("id_rh")));
				break;
			
			case "/To_Evaluate_Project/verificarAvaliacao":
				verificarAvaliacao(request, response, Integer.parseInt(request.getParameter("id_rh")));
				break;
				
			case "/To_Evaluate_Project/concederAcesso":
				concederAcesso(request, response, Integer.parseInt(request.getParameter("id_rh")));
				break;
			
			case "/To_Evaluate_Project/rhConfiguracoes":
				rhConfiguracoes(request, response, Integer.parseInt(request.getParameter("id_rh")));
				break;
			case "/To_Evaluate_Project/rhIndex":
				rhIndex(request, response, Integer.parseInt(request.getParameter("id_rh")));
				break;
				
			case "/To_Evaluate_Project/updateRh":
				updateRh(request, response, Integer.parseInt(request.getParameter("id_rh")));
				break;
			default:
				throw new IllegalArgumentException("Unexpected value: " + request.getRequestURI());
		}
		
		
	}
	
	protected void updateRh(HttpServletRequest request, HttpServletResponse response, int id) throws ServletException, IOException {		
		try {		
			
			Rh rh = new Rh();
			rh.setId(id);
			rh.setNome(request.getParameter("nome"));
			rh.setDt_nasc(LocalDate.parse(request.getParameter("dtNascimento")));
			String telefone = request.getParameter("telefone");
			Telefone tel = new Telefone();
			tel.setDdd(Integer.parseInt(telefone.substring(0, 2)));
			tel.setNumero(Integer.parseInt(telefone.substring(2, 11)));
			String email = request.getParameter("email");
			String senha = request.getParameter("senha");

		    rh.setTelefone(tel);
		    Login loginRH = new Login();
		    loginRH.setEmail(email);
		    loginRH.setSenha(senha);

		    String resp = RhBO.validarUpdate(tel, loginRH, rh);
		    System.out.println(resp);
		    if(resp == null) {
		    	System.out.println("entrei if");
		    	new RhDAO().updateRh(rh);
			    new LoginDAO().updateLogin(loginRH, id);
			    TelefoneBO.atualizarDado(tel, rh.getId());
			    System.out.println("Dados atualizados");
//			    Rh resultadoRh = RhBO.consulta(id);
//				System.out.println(resultadoRh.getNome());
//				System.out.println(resultadoRh.getCargo());
//				System.out.println(resultadoRh.getDepartamento());
//				System.out.println(resultadoRh.getDt_nasc());
//				request.setAttribute("rh", resultadoRh);
//				
//				request.getRequestDispatcher("rhConfiguracoes.jsp").forward(request, response);
				response.sendRedirect("rhConfiguracoes.jsp?msg=ok&msgStatus=Dados atualizados!");
				
			    
		    } else {
		    	response.sendRedirect("rhConfiguracoes.jsp?msg=err&msgStatus=Houve algum imprevisto!");
		    }
					
			
			
			
		}catch (Exception e) {
			e.printStackTrace();
			Excecao.tratarExcecoes(e);
		}
		
		
	}
	
	protected void rhIndex(HttpServletRequest request, HttpServletResponse response, int id) throws ServletException, IOException {
		try {		
			Rh resultadoRh = RhBO.consulta(id);
			System.out.println(resultadoRh.getNome());
			System.out.println(resultadoRh.getCargo());
			System.out.println(resultadoRh.getDepartamento());
			System.out.println(resultadoRh.getDt_nasc());
			request.setAttribute("rh", resultadoRh);
			
			request.getRequestDispatcher("rhIndex.jsp").forward(request, response);
			
		}catch (Exception e) {
			e.printStackTrace();
			Excecao.tratarExcecoes(e);
		}
	}
	
	
	protected void rhConfiguracoes(HttpServletRequest request, HttpServletResponse response, int id) throws ServletException, IOException {
		try {		
			Rh rh = RhBO.consulta(id);
			request.setAttribute("rh", rh);
			
			Telefone tel = TelefoneBO.lerDado(id);
			request.setAttribute("telefone", tel);
		
			Login login = LoginBO.consultar(id);
			request.setAttribute("login", login);
			
			request.getRequestDispatcher("rhConfiguracoes.jsp").forward(request, response);
			
		}catch (Exception e) {
			e.printStackTrace();
			Excecao.tratarExcecoes(e);
		}
		
	}	
	
	protected void concederAcesso(HttpServletRequest request, HttpServletResponse response, int id) throws ServletException, IOException {
		try {
			List<Usuario> lista = listarUsuarios();
			request.setAttribute("usuarios", lista);			

			Rh resultadoRh = RhBO.consulta(id);
			System.out.println(resultadoRh.getNome());
			System.out.println(resultadoRh.getCargo());
			System.out.println(resultadoRh.getDepartamento());
			System.out.println(resultadoRh.getDt_nasc());
			request.setAttribute("rh", resultadoRh);
			
			request.getRequestDispatcher("concederAcesso.jsp").forward(request, response);
			
		} catch(Exception e) {
			e.printStackTrace();
			Excecao.tratarExcecoes(e);
		}
	}	
	
	
	protected void verificarAvaliacao(HttpServletRequest request, HttpServletResponse response, int id) throws ServletException, IOException {
		try {
			List<Usuario> lista = listarUsuarios();
			request.setAttribute("usuarios", lista);

			Rh resultadoRh = RhBO.consulta(id);
			System.out.println(resultadoRh.getNome());
			System.out.println(resultadoRh.getCargo());
			System.out.println(resultadoRh.getDepartamento());
			System.out.println(resultadoRh.getDt_nasc());
			request.setAttribute("rh", resultadoRh);
			
			request.getRequestDispatcher("verificarAvaliacao.jsp").forward(request, response);
			
		} catch(Exception e) {
			e.printStackTrace();
			Excecao.tratarExcecoes(e);
		}
	}	
	
	protected void notificarAvaliacao(HttpServletRequest request, HttpServletResponse response, int id) throws ServletException, IOException {
		try {
			List<Usuario> lista = listarUsuarios();
			request.setAttribute("usuarios", lista);

			Rh resultadoRh = RhBO.consulta(id);
			System.out.println(resultadoRh.getNome());
			System.out.println(resultadoRh.getCargo());
			System.out.println(resultadoRh.getDepartamento());
			System.out.println(resultadoRh.getDt_nasc());
			request.setAttribute("rh", resultadoRh);
			
			request.getRequestDispatcher("notificarAvaliacao.jsp").forward(request, response);
			
		} catch(Exception e) {
			e.printStackTrace();
			Excecao.tratarExcecoes(e);
		}
	}
	
	protected void verificarDesempenhoListaAnalista(HttpServletRequest request, HttpServletResponse response, int id) throws ServletException, IOException {
		List<Usuario> resp;
		try {
			
			resp = new AnalistaBO().listar();			
			request.setAttribute("lista", resp);			
			
			
			Rh resultadoRh = RhBO.consulta(id);
			System.out.println(resultadoRh.getNome());
			System.out.println(resultadoRh.getCargo());
			System.out.println(resultadoRh.getDepartamento());
			System.out.println(resultadoRh.getDt_nasc());
			request.setAttribute("rh", resultadoRh);
			
			
			request.getRequestDispatcher("rh.jsp").forward(request, response);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Excecao.tratarExcecoes(e);
		}				 		
	}
	
	protected void verificarDesempenhoSelecionarAnalista(HttpServletRequest request, HttpServletResponse response, int id, int idRh) throws ServletException, IOException {		
		try {
			Analista resp = AnalistaBO.consulta(id);										
			request.setAttribute("btnSelecionar", resp);
			
			verificarDesempenhoListaAnalista(request, response, idRh);
			
		} catch (Exception e) {
			e.printStackTrace();
			Excecao.tratarExcecoes(e);
		}
			
	}
	
	protected void deleteUsuario(HttpServletRequest request, HttpServletResponse response, int id, int idRh) throws ServletException, IOException {
        try {
            UsuarioBO bo = new UsuarioBO();
            bo.delete(id);              
            
			Rh resultadoRh = RhBO.consulta(idRh);
			System.out.println(resultadoRh.getNome());
			System.out.println(resultadoRh.getCargo());
			System.out.println(resultadoRh.getDepartamento());
			System.out.println(resultadoRh.getDt_nasc());
			request.setAttribute("rh", resultadoRh);
            
            request.getRequestDispatcher("checarFuncionario.jsp").forward(request, response);;
        }catch(Exception e) {
            e.printStackTrace();
            Excecao.tratarExcecoes(e);
        }
    }

	protected void checarFuncionario(HttpServletRequest request, HttpServletResponse response, int idRh) throws ServletException, IOException { 
		try {
			List<Usuario> lista = listarUsuarios();
			request.setAttribute("usuarios", lista);

			Rh resultadoRh = RhBO.consulta(idRh);
			System.out.println(resultadoRh.getNome());
			System.out.println(resultadoRh.getCargo());
			System.out.println(resultadoRh.getDepartamento());
			System.out.println(resultadoRh.getDt_nasc());
			request.setAttribute("rh", resultadoRh);
			
			request.getRequestDispatcher("checarFuncionario.jsp").forward(request, response);			
			
		} catch(Exception e) {
			e.printStackTrace();
			Excecao.tratarExcecoes(e);
		}
		
	}
	
	public List<Usuario> listarUsuarios() throws Exception {		
		List<Usuario> resp = new UsuarioBO().listar();
		
		for (Usuario u: resp) {
			if (u.getStatus().toUpperCase().equals("SIM")) {
				u.setStatus("GESTOR");
			} else if (u.getDepartamento().toUpperCase().equalsIgnoreCase("RH") || u.getDepartamento().toUpperCase().equalsIgnoreCase("RECURSOS HUMANOS")) {
				u.setStatus("RH");					
			} else {
				u.setStatus("ANALISTA");
			}			
			
		}						
		return resp;
	}
	

}
