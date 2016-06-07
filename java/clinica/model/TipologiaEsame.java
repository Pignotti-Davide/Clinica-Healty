package clinica.model;

import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TipologiaEsame {
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descrizione == null) ? 0 : descrizione.hashCode());
		result = prime * result + ((idTipologiaEsame == null) ? 0 : idTipologiaEsame.hashCode());
		result = prime * result + ((indicatoriRisultati == null) ? 0 : indicatoriRisultati.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((requisiti == null) ? 0 : requisiti.hashCode());
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
		TipologiaEsame other = (TipologiaEsame) obj;
		if (descrizione == null) {
			if (other.descrizione != null)
				return false;
		} else if (!descrizione.equals(other.descrizione))
			return false;
		if (idTipologiaEsame == null) {
			if (other.idTipologiaEsame != null)
				return false;
		} else if (!idTipologiaEsame.equals(other.idTipologiaEsame))
			return false;
		if (indicatoriRisultati == null) {
			if (other.indicatoriRisultati != null)
				return false;
		} else if (!indicatoriRisultati.equals(other.indicatoriRisultati))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (requisiti == null) {
			if (other.requisiti != null)
				return false;
		} else if (!requisiti.equals(other.requisiti))
			return false;
		return true;
	}

	@Column(name="TIPOLOGIA_ID")
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idTipologiaEsame;
	@Column(nullable=false)
	private String nome;
	@Column(nullable=false)
	private String descrizione;
	@ElementCollection(fetch=FetchType.EAGER)
	private Map<String,String>requisiti;
	@ElementCollection(fetch=FetchType.EAGER)
	private List<String> indicatoriRisultati;
	public TipologiaEsame(){}

	public Long getIdTipologiaEsame() {
		return idTipologiaEsame;
	}

	public void setIdTipologiaEsame(Long idTipologiaEsame) {
		this.idTipologiaEsame = idTipologiaEsame;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public Map<String, String> getRequisiti() {
		return requisiti;
	}

	public void setRequisiti(Map<String, String> requisiti) {
		this.requisiti = requisiti;
	}

	@Override
	public String toString() {
		return nome;
	}

	public List<String> getIndicatoriRisultati() {
		return indicatoriRisultati;
	}

	public void setIndicatoriRisultati(List<String> indicatoriRisultati) {
		this.indicatoriRisultati = indicatoriRisultati;
	}
	

}
