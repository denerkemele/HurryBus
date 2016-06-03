package hurrybus;


import java.util.ArrayList;
import java.util.Collection;

//import javax.servlet.RequestDispatcher;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONArray;
import org.json.JSONObject;




import hurrybus.model.Usuario;
import hurrybus.dao.UsuarioDao;


/**
 *	Classe que recebe as requisições das páginas Web
 * 
 * @author            Arthur Silveira
 * @author            Dener Kemele
 * 
 */

@Path("/usuarios")
public class UsuarioHandler {
	
   /**
    * Insere um novo Usuário na tabela Usuarios
    * 
    * @param StringJSON  	String com os dados do usuáio
    * @return    			Retorna um Response para página jsp
    * @see UsuarioDao
    */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response insereUsuario(String StringJSON){
		// TODO renomear StringJson para usuarioJson
		
		
		
		UsuarioDao dao = new UsuarioDao();
		Usuario user = dao.fromJson(StringJSON);
		dao.insereUsuario(user);
		return Response.ok().build();
	}
	
	
	@POST
	@Path("/login")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response verificaUsuario(String StringJSON)  {
		
		/*String usuario = request.getParameter("email");
		String senha  = request.getParameter("password") ; 
//		String status = "";8*/
		
	/*	Usuario usuarios = new Usuario();
		
		usuarios.setName(usuario);
		usuarios.setSenha(senha);
		//RequestDispatcher rd = null;
		
		UsuarioDao usuarioDao = new UsuarioDao();*/
		
	
		// System.out.println(user.toString() );
		 
		 
		 //System.out.println("ok" );
		 //return Response.ok().build();
		//dao.verificaUsuario(user);
		 /*Serializable uri = new URI("/login/success");
	      
		 Serializable uri2= new URI("http://localhost:9090/NewWebServiceproject/new/login/failure");*/
	
		////////////////////////////////////inicio
		UsuarioDao dao = new UsuarioDao();
		Usuario user = dao.loginJson(StringJSON);
		if (dao.verificaUsuario(user)){
			
			
		
			
		    	System.out.println("okww" );
		    	return Response.status(200).build();
		    	//return Response.ok(200).build();
		    	 //return Response.status(200).entity(StringJSON).build();
		    	
		//	return Response.temporaryRedirect((java.net.URI) uri).build();
			
			
		} else {
		
			System.out.println("error" );
		    	return Response.status(404).build();
			
			//return Response.temporaryRedirect((java.net.URI) uri2).build();
		
		}
		/////////////////////////////////////////fim
	
		
		// TODO renomear StringJson para usuarioJson
		
		
		//RequestDispatcher rd = null;
		
		
		/*UsuarioDao dao = new UsuarioDao();
		Usuario user = dao.fromJson(StringJSON);
		
		user.setName("nome");
    	user.setSenha("senha");
    	
    	dao.verificaUsuario(user);*/
		/*
		 System.out.println("ok" );
    	return Response.ok(200).build();*/
    	//return  Response.ok().entity(StringJSON).build();
    	
    	//return Response.ok("ok").build();
   	/*
    	if (dao.verificaUsuario(user)){
		 //			status = "usuario valido";
			rd  = request.getRequestDispatcher("/CRUD/index.jsp");
			rd.forward(request,response);
	
		} else {
		//			status = "Não valido";
			request.setAttribute("mensagem","<br>usuario ou senha invalido"	);
			rd  = request.getRequestDispatcher("/CRUD/login.jsp");
			rd.forward(request,response);	
		}*/
		
		//dao.insereUsuario(user);
		/*UsuarioDao dao = new UsuarioDao();
		Usuario user = dao.fromJson(StringJSON);*/
		
		
	/*	if(dao.verificaUsuario(user)== true )
		{
			System.out.println("ok");
			return Response.ok("ok").build();
		}
		else{
			return Response.ok("not").build();
		}
		*/
		
		
		
	}
	
	
	
	
   /**
	* Busca todos os usuário cadastrados na tabela Usuarios
 	* 
    * @return    			Retorna um Response com JSONArray para página jsp com todos os usuários
    * @see UsuarioDao
    */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUsuarios() {
		UsuarioDao dao = new UsuarioDao();
		
		// TODO variaveis locais comecam com letra minuscula
		Collection<Usuario> ListaUsers = new ArrayList<Usuario>();
		ListaUsers=dao.buscarTodosUsuarios();
		
		JSONArray ListaJson = new JSONArray();
		ListaJson.put(ListaUsers);
		JSONObject obj = new JSONObject();
		obj.put("usuarios", ListaJson);

		return Response.ok().entity(obj.toString()).build();
	}
	
   /**
    * Atualiza um Usuário na tabela Usuarios
    * 
    * @param StringJSON  	String com os dados do usuáio
    * @return    			Retorna um Response para página jsp
    * @see UsuarioDao
    */
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response atualizaUsuario(String StringJSON){
		UsuarioDao dao = new UsuarioDao();
		Usuario user = dao.fromJson(StringJSON);
		dao.atualizaUsuario(user);
		return Response.ok().build();	
	}
	
   /**
    * Remove um Usuário da tabela Usuarios
    * 
    * @param id		  	Um inteiro com o id do usuario a ser deletado
    * @return    		Retorna um Response para página jsp com o nomo do usuario deletado
    * @see UsuarioDao
    */
	@DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
    public Response excluiUsuario(@PathParam("id") Integer id) {
		UsuarioDao dao = new UsuarioDao();
		Usuario user = new Usuario();
		// TODO nao criar duas isntancias de Usuario
		user = dao.buscaUsuarioPorId(id);
		dao.excluiUsuario(user);
		return Response.ok().build();	
	}
	
   /**
    * Busca um Usuário na tabela Usuarios
    * 
    * @param id		  	Um inteiro com o id do usuario a ser buscado
    * @return    		Retorna um Response para página jsp com uma StringJSON do usuário
    * @see UsuarioDao
    */
	@GET
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	 public Response buscaUsuarioId(@PathParam("id") Integer id) {
		UsuarioDao dao = new UsuarioDao();
		Usuario user = new Usuario();
		
		user=dao.buscaUsuarioPorId(id);
		String StringJSON = dao.toJson(user);
		return Response.ok().entity(StringJSON).build();
	}

}