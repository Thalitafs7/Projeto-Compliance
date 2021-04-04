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
import br.com.toevaluate.dao.LiderDAO;
import br.com.toevaluate.util.Magic;

/**
 * Servlet implementation class CadastroServeletController
 */
@WebServlet(urlPatterns = {"/cadastro", "/criar"})
public class CadastroServeletController extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastroServeletController() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */ 
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        switch (request.getRequestURI()) {
        case ("/To_Evaluate_Project/criar"): {
            criar(request, response);       
            break;
        }
        default:
            throw new IllegalArgumentException("Unexpected value: " + request.getRequestURI());
        }
    }
    
    protected void criar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        try {
         
         String cargo = request.getParameter("tipoCargo");
         String nome = request.getParameter("nome");
         String sobrenome = request.getParameter("sobrenome");
         
         String nascimento = request.getParameter("dtNasc");         
         DateTimeFormatter formatacao = DateTimeFormatter.ofPattern("yyyy-MM-dd");
         LocalDate data = LocalDate.parse(nascimento,formatacao);
         
         String telefone = request.getParameter("telefone");
         Telefone tel = new Telefone();
         
         tel.setDdd(Integer.parseInt(telefone.substring(0, 2)));
         tel.setNumero(Integer.parseInt(telefone.substring(2, 11)));
         
         String departamento = request.getParameter("departamento");
         String email = request.getParameter("email");
         String senha = request.getParameter("senha");
                     
        
         // Analista
         if (request.getParameter("cargo").equals("analista")) {
             Analista a = new Analista();
             a.setNome(nome + " " + sobrenome);
             a.setCargo(cargo);
             a.setDepartamento(departamento);
             a.setDt_nasc(data);             
             a.setLider(new LiderDAO().lerLider(Integer.parseInt(request.getParameter("idGestor"))));
             a.setTelefone(tel); 
             
             Login login = new Login();
             login.setEmail(email);
             login.setSenha(senha);
             String resp = AnalistaBO.addAnalista(a, login);
             System.out.println(resp);                                                          
             
             if (resp.startsWith("Data")) {
                 response.sendRedirect("cadastrar.jsp?resp=ok&msg=Data inválida");
             }
             
             if (resp.startsWith("Nome m")) {
                 response.sendRedirect("cadastrar.jsp?resp=ok&msg=Nome muito grande, ele não pode ser maior que 50 caracteres");
             }
             
             if (resp.startsWith("Nome do c")) {
                response.sendRedirect("cadastrar.jsp?resp=ok&msg=Cargo muito grande, ele não pode ser maior que 90 caracteres");
             }
             
             if (resp.startsWith("Nome do de")) {
                response.sendRedirect("cadastrar.jsp?resp=ok&msg=Depto muito grande, ele não pode ser maior que 30 caracteres");                
             }
             String r = TelefoneBO.inserirDado(tel);
             if (r.startsWith("DDD")) {
                 response.sendRedirect("cadastrar.jsp?resp=ok&msg=DDD invalido");
             }
             
             if (r.startsWith("Nú")) {
                 response.sendRedirect("cadastrar.jsp?resp=ok&msg=Número inválido");             
             }
             
             if (resp.startsWith("Email")) {
                response.sendRedirect("cadastrar.jsp?resp=ok&msg=Depto muito grande, ele não pode ser maior que 30 caracteres");                
             }
             
             if (resp.startsWith("Senha")) {
                response.sendRedirect("cadastrar.jsp?resp=ok&msg=Senha muito grande, ele não pode ser maior que 20 caracteres");                
             }                                  
             
             response.sendRedirect("loginAnalista.jsp");
             
         // Gestor
         } else if (request.getParameter("cargo").equals("gestor")) {                                           
              Lider lider = new Lider();
              lider.setNome(nome + " " + sobrenome);
              lider.setCargo(request.getParameter("cargo"));
              lider.setDepartamento(departamento);                          
              lider.setDt_nasc(data);
              lider.setTelefone(tel);
              Login login = new Login();
              login.setEmail(email);
              login.setSenha(senha);              
              String resp = LiderBO.addLider(lider, login);
              if (resp.startsWith("Data")) {
                  response.sendRedirect("cadastrar.jsp?resp=ok&msg=Data inválida");
              }
              
              if (resp.startsWith("Nome m")) {
                  response.sendRedirect("cadastrar.jsp?resp=ok&msg=Nome muito grande, ele não pode ser maior que 50 caracteres");
              }
              
              if (resp.startsWith("Nome do c")) {
                 response.sendRedirect("cadastrar.jsp?resp=ok&msg=Cargo muito grande, ele não pode ser maior que 90 caracteres");
              }
              
              if (resp.startsWith("Nome do de")) {
                 response.sendRedirect("cadastrar.jsp?resp=ok&msg=Depto muito grande, ele não pode ser maior que 30 caracteres");                
              }

              String r = TelefoneBO.inserirDado(tel);   
              if (r.startsWith("DDD")) {
                 response.sendRedirect("cadastrar.jsp?resp=ok&msg=DDD invalido");
              }
             
              if (r.startsWith("Nú")) {
                 response.sendRedirect("cadastrar.jsp?resp=ok&msg=Número inválido");             
              }
             
              if (resp.startsWith("Email")) {
                response.sendRedirect("cadastrar.jsp?resp=ok&msg=Depto muito grande, ele não pode ser maior que 30 caracteres");                
              }
             
              if (resp.startsWith("Senha")) {
                response.sendRedirect("cadastrar.jsp?resp=ok&msg=Senha muito grande, ele não pode ser maior que 20 caracteres");                
              }         
              response.sendRedirect("loginGestor.jsp");
             
         } else if (request.getParameter("cargo").equals("rh")) {
              Rh rh = new Rh();
              rh.setNome(nome + " " + sobrenome);
              rh.setDt_nasc(data);
              rh.setTelefone(tel);
              rh.setCargo(request.getParameter("cargo").toUpperCase());
              rh.setDepartamento(request.getParameter("cargo").toUpperCase());
              Login loginRH = new Login();
              loginRH.setEmail(email);
              loginRH.setSenha(senha);
              RhBO.addRh(rh, loginRH);
              TelefoneBO.inserirDado(tel);
              
              response.sendRedirect("loginRH.jsp");              
         }
         
        } catch (Exception e) {
            e.printStackTrace();
            Excecao.tratarExcecoes(e);
        }
                    
    }
    
    
    
}