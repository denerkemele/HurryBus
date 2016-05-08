package hurrybus.model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *	Classe que define o modelo de Usuario
 * 
 * @author            Arthur Silveira
 * @author            Dener Kemele
 * 
 */
public class Usuario {

    private String name;
    private String email;
    private String senha;
    private int id = -1;

    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	/**
     * @return Retorna a vari�vel nome
     */
    public String getName() {
        return name;
    }

    /**
     * @param name inicializa a vari�vel nome
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return retorna a vari�vel email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email inicializa a vari�vel email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return retorna a vari�vel senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha inicializa a vari�vel senha
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }
    
	@Override
	public String toString() {
		return "Usuario [name=" + name + ", email=" + email + ", senha=" + senha + ",  id=" + id
				+ "]";
	}

}
