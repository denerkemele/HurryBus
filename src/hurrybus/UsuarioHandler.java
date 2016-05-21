package hurrybus;

import java.util.ArrayList;
import java.util.Collection;

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
 *	Classe que recebe as requisi��es das p�ginas Web
 * 
 * @author            Arthur Silveira
 * @author            Dener Kemele
 * 
 */

@Path("/usuarios")
public class UsuarioHandler {
	
   /**
    * Insere um novo Usu�rio na tabela Usuarios
    * 
    * @param StringJSON  	String com os dados do usu�io
    * @return    			Retorna um Response para p�gina jsp
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
	
	
   /**
	* Busca todos os usu�rio cadastrados na tabela Usuarios
 	* 
    * @return    			Retorna um Response com JSONArray para p�gina jsp com todos os usu�rios
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
    * Atualiza um Usu�rio na tabela Usuarios
    * 
    * @param StringJSON  	String com os dados do usu�io
    * @return    			Retorna um Response para p�gina jsp
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
    * Remove um Usu�rio da tabela Usuarios
    * 
    * @param id		  	Um inteiro com o id do usuario a ser deletado
    * @return    		Retorna um Response para p�gina jsp com o nomo do usuario deletado
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
    * Busca um Usu�rio na tabela Usuarios
    * 
    * @param id		  	Um inteiro com o id do usuario a ser buscado
    * @return    		Retorna um Response para p�gina jsp com uma StringJSON do usu�rio
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