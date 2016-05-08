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
	UsuarioDao dao = new UsuarioDao();
	Usuario user = new Usuario();
	
	
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
	public Response InsereUsuario(String StringJSON){
		//System.out.println(StringJSON);
		user = dao.fromJson(StringJSON);
		//System.out.println(user.toString());
		dao.insereUsuario(user);
		return Response.ok(200).entity(StringJSON).build();
	}
	
	
   /**
	* Busca todos os usu�rio cadastrados na tabela Usuarios
 	* 
    * @return    			Retorna um Response com JSONArray para p�gina jsp com todos os usu�rios
    * @see UsuarioDao
    */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUsuario() {
		Collection<Usuario> ListaUsers = new ArrayList<Usuario>();
		ListaUsers=dao.buscarTodosUsuarios();
		
		JSONArray ListaJson = new JSONArray();
		ListaJson.put(ListaUsers);
		
		System.out.println(ListaJson.toString());

		return Response.ok(200).entity(ListaJson.toString()).build();
	}
	
   /**
    * Atualiza um Usu�rio na tabela Usuarios
    * 
    * @param StringJSON  	String com os dados do usu�io
    * @return    			Retorna um Response para p�gina jsp com o nome do usuario atualizado
    * @see UsuarioDao
    */
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response UpdateUsuario(String StringJSON){
		user = dao.fromJson(StringJSON);
		
		//System.out.println(StringJSON);
		//System.out.println(user.toString());
		
		dao.atualizaUsuario(user);
		
		return Response.ok(200).entity("Usuario "+user.getName()+" atualizado").build();	
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
    public Response DeletaUsuario(@PathParam("id") Integer id) {
		user = dao.buscaUsuarioPorId(id);
		//System.out.println(user.toString());
		dao.excluiUsuario(user);
		return Response.ok(200).entity("Usuario "+user.getName()+" deletado").build();	
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
	 public Response BuscaUsuarioId(@PathParam("id") Integer id) {
		
		user=dao.buscaUsuarioPorId(id);
		String StringJSON = dao.toJson(user);
		System.out.println(StringJSON);
		return Response.ok(200).entity(StringJSON).build();
	}

}