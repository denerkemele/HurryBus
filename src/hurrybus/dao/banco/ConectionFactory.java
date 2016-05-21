package hurrybus.dao.banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *	Esta classe � respons�vel por estabelecer uma conex�o com o banco de dados PostgreSQL
 * 
 * @author            Arthur Silveira
 * @author            Dener Kemele
 * 
 */
public class ConectionFactory {
    
    String driver = "org.postgresql.Driver";
    private final String url = "jdbc:postgresql://localhost:5432/HurryBus";
    private final String usuario = "postgres";
    private final String senha = "123";

    
    /**
     * Estabelece a conex�o com o banco de dados
     * 
     * @return	Retorna um objeto do tipo Connection
     */
    public Connection getConnetion(){
        try {
            Class.forName(driver);
            return DriverManager.getConnection(url, usuario, senha);
        	}catch (SQLException | ClassNotFoundException erro) {
        		System.out.println("Erro ao tenta conectar!");
        		throw new RuntimeException(erro);
        		}
    	}
}
