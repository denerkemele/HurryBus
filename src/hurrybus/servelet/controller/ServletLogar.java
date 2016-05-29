package hurrybus.servelet.controller;

import java.io.IOException;
//import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hurrybus.dao.UsuarioDao;
import hurrybus.model.Usuario;

/**
 * Servlet implementation class ServletLogar
 */
@WebServlet(value = "/CRUD/ServletLogar")
public class ServletLogar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletLogar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String usuario = request.getParameter("email");
		String senha  = request.getParameter("password") ; 
//		String status = "";
		
		Usuario usuarios = new Usuario();
		usuarios.setName(usuario);
		usuarios.setSenha(senha);
		RequestDispatcher rd = null;
		
		UsuarioDao usuarioDao = new UsuarioDao();
		
		if (usuarioDao.verificaUsuario(usuarios)== true){
		 //			status = "usuario valido";
			rd  = request.getRequestDispatcher("/CRUD/index.jsp");
			rd.forward(request,response);
	
		} else {
		//			status = "Não valido";
			request.setAttribute("mensagem","<br>usuario ou senha invalido"	);
			rd  = request.getRequestDispatcher("/CRUD/login.jsp");
			rd.forward(request,response);	
		}
		
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	/*	try (PrintWriter out  = response.getWriter()){
			
			out.println("usuario = " +usuario);
			out.println("senha = " +senha);
			out.println("Situação = " +status);
		}	*/
	
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	
	
	

}
