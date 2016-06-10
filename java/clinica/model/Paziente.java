package clinica.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Paziente {


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idPaziente;
	@Column(nullable=false)
	private String nome;
	@Column(nullable=false)
	private String cognome;

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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cognome == null) ? 0 : cognome.hashCode());
		result = prime * result + ((idPaziente == null) ? 0 : idPaziente.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Paziente other = (Paziente) obj;
		if (cognome == null) {
			if (other.cognome != null)
				return false;
		} else if (!cognome.equals(other.cognome))
			return false;
		if (idPaziente == null) {
			if (other.idPaziente != null)
				return false;
		} else if (!idPaziente.equals(other.idPaziente))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Paziente [idPaziente=" + idPaziente + ", nome=" + nome + ", cognome=" + cognome + "]";
	}
	public Paziente(){}
}
