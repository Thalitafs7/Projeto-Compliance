package br.com.toevaluate.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.toevaluate.Exception.Excecao;
import br.com.toevaluate.beans.Analista;
import br.com.toevaluate.beans.Lider;
import br.com.toevaluate.beans.Login;
import br.com.toevaluate.beans.Rh;
import br.com.toevaluate.beans.Telefone;
import br.com.toevaluate.beans.Usuario;
import br.com.toevaluate.bo.AnalistaBO;
import br.com.toevaluate.bo.LiderBO;
import br.com.toevaluate.bo.LoginBO;
import br.com.toevaluate.bo.RhBO;
import br.com.toevaluate.bo.TelefoneBO;
import br.com.toevaluate.bo.UsuarioBO;

/**
 * Servlet implementation class LoginController
 */
@WebServlet({ "/LoginController", "/loginAnalista", "/loginGestor", "/loginRh", "/analistaConfiguracoes", 
	"/analista", "/gestorConfiguracoes", "/atualizaGestor"})
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Login login = new Login();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		switch (request.getRequestURI()) {
		case "/To_Evaluate_Project/loginAnalista": 
			loginAnalista(request, response);
			break;
		
		case "/To_Evaluate_Project/loginGestor": 
			loginGestor(request, response);
			break;
			
		case "/To_Evaluate_Project/loginRh": 
			loginRh(request, response);
			break;
			
		case "/To_Evaluate_Project/analistaConfiguracoes":
			analistaConfiguracoes(request, response, Integer.parseInt(request.getParameter("id_analista")));
			break;
		
		case "/To_Evaluate_Project/analista":
			analista(request, response, Integer.parseInt(request.getParameter("id")));
			break;
		case "/To_Evaluate_Project/gestorConfiguracoes":
			gestorConfiguracoes(request, response, Integer.parseInt(request.getParameter("id")));
			break;
		case "/To_Evaluate_Project/atualizaGestor":
			atualizaGestor(request, response, Integer.parseInt(request.getParameter("id")));
			break;		
			
		default:
			throw new IllegalArgumentException("Unexpected value: " + request.getRequestURI());
		}		

	}
	
	protected void gestorConfiguracoes(HttpServletRequest request, HttpServletResponse response, int id) throws ServletException, IOException {
		try {
			System.out.println("Entrei nas configurações do gestor");
			Lider lider = new Lider();
			Lider gestor = LiderBO.psqLider(id);
			System.out.println(gestor.getNome());
			System.out.println(gestor.getCargo());
			Telefone resp2 = TelefoneBO.lerDado(id);
			Login resp3 = LoginBO.consultar(id);
			
			request.setAttribute("tel", resp2);
			request.setAttribute("login", resp3);
			request.setAttribute("gestor", gestor);
			request.getRequestDispatcher("gestorConfiguracoes.jsp").forward(request, response);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	protected void atualizaGestor(HttpServletRequest request, HttpServletResponse response, int id) throws ServletException, IOException {
		try {
			Lider l = new Lider();
			l.setId(id);
			l.setNome(request.getParameter("nome"));
			LocalDate d = LocalDate.parse(request.getParameter("dtNascimento") ,DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			l.setDt_nasc(d);
			l.setCargo(request.getParameter("cargo"));
			l.setStatus("SIM");
			String telefone = request.getParameter("telefone");
			Telefone tel = new Telefone();
			tel.setDdd(Integer.parseInt(telefone.substring(0, 2)));
			tel.setNumero(Integer.parseInt(telefone.substring(2, 11)));
			Login login = new Login();
			login.setEmail(request.getParameter("email"));
			login.setSenha(request.getParameter("senha"));
			l.setStatus(request.getParameter("nome"));
			String resp = LiderBO.atualizar(login, tel, l);
			System.out.println(resp);
			if (resp.endsWith("atualizado!")) {
				System.out.println("if");
				response.sendRedirect("gestorConfiguracoes.jsp?msg=ok&msgStatus=Dados atualizados!");
			} else {
				response.sendRedirect("gestorConfiguracoes.jsp?msg=err&msgStatus=Houve algum imprevisto!");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	protected void analista(HttpServletRequest request, HttpServletResponse response, int id) throws ServletException, IOException {
		try {
			Analista resp = AnalistaBO.consulta(id);
			
			request.setAttribute("analista", resp);
			
			request.getRequestDispatcher("analista.jsp").forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
			Excecao.tratarExcecoes(e);
		}
	}
	
	protected void analistaConfiguracoes(HttpServletRequest request, HttpServletResponse response, int id) throws ServletException, IOException {
		try {
			Analista analista = new Analista();
			Analista resp = AnalistaBO.consulta(id);
			Telefone resp2 = TelefoneBO.lerDado(id);
			Login resp3 = LoginBO.consultar(id);
			Lider resp4 = LiderBO.psqLider(resp.getLider().getId());
			request.setAttribute("user", resp);
			request.setAttribute("tel", resp2);
			request.setAttribute("login", resp3);
			request.setAttribute("lider", resp4);
			request.getRequestDispatcher("analistaConfiguracoes.jsp").forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
			Excecao.tratarExcecoes(e);
		}
	
	}	
	
	
	protected void loginAnalista(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {			
			System.out.println("Entrei loginAnalista");
			login.setEmail(request.getParameter("emailAnalista"));
			login.setSenha(request.getParameter("senhaAnalista"));
			System.out.println(LoginBO.login(login));
			List<Usuario> lista = new UsuarioBO().listar();

			for (int i = 0; i < lista.size(); i++) {				
				Usuario u = lista.get(i);

				if (u.getStatus().equals("GESTOR") && u.getId() == login.getId()) {
					loginGestor(request, response);					
					
				} else if (u.getStatus().equals("ANALISTA") && u.getId() == login.getId()) {	
					System.out.println("Entrei analista");
					Analista resultadoAnalista = AnalistaBO.consulta(u.getId());
					System.out.println(resultadoAnalista.getNome());
					System.out.println(resultadoAnalista.getCargo());
					System.out.println(resultadoAnalista.getDepartamento());
					System.out.println(resultadoAnalista.getId());
					request.setAttribute("analista", resultadoAnalista);
					
					HttpSession session = request.getSession();
					session.setMaxInactiveInterval(10);
					session.setAttribute("id", session.getId());
					System.out.println(session.getId());
					request.getRequestDispatcher("analista.jsp").forward(request, response);
					
				} else if (u.getStatus().equals("RH") && u.getId() == login.getId()) {
					loginRh(request, response);					
				}

			}
			
		} catch(Exception e) {
			e.printStackTrace();
			Excecao.tratarExcecoes(e);
		}
	}
	
	protected void loginGestor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			System.out.println("entrei metodo");
			login.setEmail(request.getParameter("emailGestor"));
			login.setSenha(request.getParameter("senhaGestor"));
			System.out.println(LoginBO.login(login));
			
			List<Usuario> lista = new UsuarioBO().listar();
			for (int i = 0; i < lista.size(); i++) {
				Usuario u = lista.get(i);
				
				if (u.getStatus().equals("GESTOR") && u.getId() == login.getId()) {	
					Lider resultado = LiderBO.psqLider(u.getId());
					System.out.println(resultado.getNome());
					System.out.println(resultado.getCargo());
					System.out.println(resultado.getDepartamento());
					System.out.println(resultado.getDt_nasc());
					request.setAttribute("gestor", resultado);
					
					HttpSession session = request.getSession();
					session.setMaxInactiveInterval(10);
					session.setAttribute("id", session.getId());
					
					request.getRequestDispatcher("gestor.jsp").forward(request, response);
					
				} else if (u.getStatus().equals("ANALISTA") && u.getId() == login.getId()) {	
					System.out.println("entrei if analista");
					loginAnalista(request, response);										
					
				} else if (u.getStatus().equals("RH") && u.getId() == login.getId()) {
					System.out.println("entrei if analista");
					loginRh(request, response);
				}

			}
			
		} catch(Exception e) {
			e.printStackTrace();
			Excecao.tratarExcecoes(e);
		}
	}
	
	protected void loginRh(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			login.setEmail(request.getParameter("emailRh"));
			login.setSenha(request.getParameter("senhaRh"));
			System.out.println(LoginBO.login(login));
			
			List<Usuario> lista = new UsuarioBO().listar();
			for (int i = 0; i < lista.size(); i++) {
				Usuario u = lista.get(i);
				if (u.getStatus().equals("GESTOR") && u.getId() == login.getId()) {															
					loginGestor(request, response);
					
				} else if (u.getStatus().equals("ANALISTA") && u.getId() == login.getId()) {					
					loginAnalista(request, response);										
					
				} else if (u.getStatus().equals("RH") && u.getId() == login.getId()) {
					Rh resultadoRh = RhBO.consulta(u.getId());
					System.out.println(resultadoRh.getNome());
					System.out.println(resultadoRh.getCargo());
					System.out.println(resultadoRh.getDepartamento());
					System.out.println(resultadoRh.getDt_nasc());
					request.setAttribute("rh", resultadoRh);
					
					HttpSession session = request.getSession();
					session.setMaxInactiveInterval(600);
					session.setAttribute("id", session.getId());
					
					request.getRequestDispatcher("rhIndex.jsp").forward(request, response);
				}

			}
			
		} catch(Exception e) {
			e.printStackTrace();
			Excecao.tratarExcecoes(e);
		}
	}
	
	public void efetuarLogin(Login login) throws Exception {
		
	}
		
}
