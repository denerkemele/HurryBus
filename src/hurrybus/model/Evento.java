package hurrybus.model;

import java.sql.Timestamp;

/**
 *	Classe que define o modelo de evento
 * 
 * @author            Arthur Silveira
 * @author            Dener Kemele
 * 
 */
public class Evento {
	
	private int Id;
	private Usuario usuario;
	private Timestamp embarqueHora; 
	private Timestamp desembarqueHora;
	private double embarqueLatitude, embarqueLongitude; 
	private double desembarqueLatitude, desembarqueLongitude;
	private Integer nota; 
	// TODO renomar para minusculo
	private String TAG;

	
    /**
     * @return retorno da vari�vel usuario
     */
	public Usuario getUsuario() {
		return usuario;
	}
	
    /**
     * @param usuario inicializa a variavel usuario
     */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
    /**
     * @return retorno da vari�vel embarqueHora
     */
    public Timestamp getEmbarqueHora() {
        return embarqueHora;
    }

    /**
     * @param embarqueHora inicializa a variavel embarqueHora
     */
    public void setEmbarqueHora(Timestamp embarqueHora) {
        this.embarqueHora = embarqueHora;
    }

    /**
     * @return retorno da vari�vel desembarqueHora
     */
    public Timestamp getDesembarqueHora() {
        return desembarqueHora;
    }

    /**
     * @param desembarqueHora inicializa a variavel hora_desmbarque
     */
    public void setDesembarqueHora(Timestamp hora) {
        this.desembarqueHora = hora;
    }

    /**
     * @return retorno da vari�vel id
     */
    public int getId() {
		return Id;
	}

    /**
     * @param id inicializa a variavel id
     */
	public void setId(int id) {
		Id = id;
	}

	/**
     * @return retorno da vari�vel emb_lat
     */
	public double getEmbarqueLatitude() {
		return embarqueLatitude;
	}

    /**
     * @param emb_lat inicializa a variavel emb_lat
     */
	public void setEmbarqueLatitude(double emb_lat) {
		this.embarqueLatitude = emb_lat;
	}

	/**
     * @return retorno da vari�vel emb_lon
     */
	public double getEmbarqueLongitude() {
		return embarqueLongitude;
	}

    /**
     * @param emb_lon inicializa a variavel emb_lon
     */
	public void setEmbarqueLongitude(double emb_lon) {
		this.embarqueLongitude = emb_lon;
	}

	/**
     * @return retorno da vari�vel desembarqueLatitude
     */
	public double getDesembarqueLatitude() {
		return desembarqueLatitude;
	}

    /**
     * @param desembarqueLatitude inicializa a variavel desembarqueLatitude
     */
	public void setDesembarqueLatitude(double desembarqueLatitude) {
		this.desembarqueLatitude = desembarqueLatitude;
	}

	/**
     * @return retorno da vari�vel desembarqueLongitude
     */
	public double getDesembarqueLongitude() {
		return desembarqueLongitude;
	}
	
    /**
     * @param desembarqueLongitude inicializa a variavel desembarqueLongitude
     */
	public void setDesembarqueLongitude(double desembarqueLongitude) {
		this.desembarqueLongitude = desembarqueLongitude;
	}

	/**
     * @return retorno da vari�vel TAG
     */
	public String getTAG() {
		return TAG;
	}

    /**
     * @param TAG inicializa a variavel TAG
     */
	public void setTAG(String tAG) { // TODO tudo minusculo
		TAG = tAG;
	}

	/**
     * @return retorno da vari�vel nota
     */
    public Integer getNota() {
        return nota;
    }

    /**
     * @param nota inicializa a variavel nota
     */
    public void setNota(Integer nota) {
        this.nota = nota;
    }
    

	@Override
	public String toString() {
		return "Evento [Id=" + Id + ", idUser=" + usuario.getId() + ", embarqueHora=" + embarqueHora + ", desembarqueHora="
				+ desembarqueHora + ", embarqueLatitude=" + embarqueLatitude + ", embarqueLongitude=" + embarqueLongitude + ", desembarqueLatitude=" + desembarqueLatitude
				+ ", desembarqueLongitude=" + desembarqueLongitude + ", nota=" + nota + ", TAG=" + TAG + "]";
	}
    
}
