package clinica.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Entity
public class Medico  {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idMedico;
	@Column(nullable=false)
	private String nome;
	@Column(nullable=false)
	private String cognome;
	@Column(nullable=false)
	private String specializzazione;


	public Medico(){}


	public Long getIdMedico() {
		return idMedico;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cognome == null) ? 0 : cognome.hashCode());
		result = prime * result + ((idMedico == null) ? 0 : idMedico.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((specializzazione == null) ? 0 : specializzazione.hashCode());
		return result;
	}

	public String getNomeCognome() {
		return this.nome + " " + this.cognome;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Medico other = (Medico) obj;
		if (cognome == null) {
			if (other.cognome != null)
				return false;
		} else if (!cognome.equals(other.cognome))
			return false;
		if (idMedico == null) {
			if (other.idMedico != null)
				return false;
		} else if (!idMedico.equals(other.idMedico))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (specializzazione == null) {
			if (other.specializzazione != null)
				return false;
		} else if (!specializzazione.equals(other.specializzazione))
			return false;
		return true;
	}


	public void setIdMedico(Long idMedico) {
		this.idMedico = idMedico;
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


	public String getSpecializzazione() {
		return specializzazione;
	}


	public void setSpecializzazione(String specializzazione) {
		this.specializzazione = specializzazione;
	}
	@Override
	public String toString(){
		return cognome+" "+nome;
	}


}


