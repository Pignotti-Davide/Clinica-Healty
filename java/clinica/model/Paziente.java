package clinica.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Paziente {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idPaziente;
	@Column(nullable=false)
	private String nome;
	@Column(nullable=false)
	private String cognome;
	@OneToMany(mappedBy="paziente",cascade={CascadeType.MERGE, CascadeType.REMOVE})
	
	
	
	
	public Long getIdPaziente() {
		return idPaziente;
	}



	public void setIdPaziente(Long idPaziente) {
		this.idPaziente = idPaziente;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCognome() {
		return cognome;
	}


	public void setCognome(String cognome) {
		this.cognome = cognome;
	}


	public Paziente(){}
}
