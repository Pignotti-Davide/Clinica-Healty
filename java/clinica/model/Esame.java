package clinica.model;

import java.util.Date;
import java.util.Map;

import javax.persistence.*;

import org.hibernate.annotations.Cascade;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Esame {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idEsame;
	@ManyToOne
	private Medico medico;
	@ManyToOne
	private Paziente paziente;
	@ManyToOne(fetch=FetchType.EAGER)
	private TipologiaEsame tipologia;
	@Column(nullable=false)
	@Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern="dd/MM/yyyy HH:mm")
	private Date prenotazione;
	@Column(nullable=false)
	 @DateTimeFormat(pattern="dd/MM/yyyy")
	private Date esecuzioneEsame;
	@ElementCollection
	private Map<String,String> risultati;
	public Long getIdEsame() {
		return idEsame;
	}
	public void setIdEsame(Long idEsame) {
		this.idEsame = idEsame;
	}
	public Medico getMedico() {
		return medico;
	}
	public void setMedico(Medico medico) {
		this.medico = medico;
	}
	public Paziente getPaziente() {
		return paziente;
	}
	public void setPaziente(Paziente paziente) {
		this.paziente = paziente;
	}
	
	public TipologiaEsame getTipologia() {
		return tipologia;
	}
	public void setTipologia(TipologiaEsame tipologia) {
		this.tipologia = tipologia;
	}
	public Date getPrenotazione() {
		return prenotazione;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((esecuzioneEsame == null) ? 0 : esecuzioneEsame.hashCode());
		result = prime * result + ((idEsame == null) ? 0 : idEsame.hashCode());
		result = prime * result + ((medico == null) ? 0 : medico.hashCode());
		result = prime * result + ((paziente == null) ? 0 : paziente.hashCode());
		result = prime * result + ((prenotazione == null) ? 0 : prenotazione.hashCode());
		result = prime * result + ((risultati == null) ? 0 : risultati.hashCode());
		result = prime * result + ((tipologia == null) ? 0 : tipologia.hashCode());
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
		Esame other = (Esame) obj;
		if (esecuzioneEsame == null) {
			if (other.esecuzioneEsame != null)
				return false;
		} else if (!esecuzioneEsame.equals(other.esecuzioneEsame))
			return false;
		if (idEsame == null) {
			if (other.idEsame != null)
				return false;
		} else if (!idEsame.equals(other.idEsame))
			return false;
		if (medico == null) {
			if (other.medico != null)
				return false;
		} else if (!medico.equals(other.medico))
			return false;
		if (paziente == null) {
			if (other.paziente != null)
				return false;
		} else if (!paziente.equals(other.paziente))
			return false;
		if (prenotazione == null) {
			if (other.prenotazione != null)
				return false;
		} else if (!prenotazione.equals(other.prenotazione))
			return false;
		if (risultati == null) {
			if (other.risultati != null)
				return false;
		} else if (!risultati.equals(other.risultati))
			return false;
		if (tipologia == null) {
			if (other.tipologia != null)
				return false;
		} else if (!tipologia.equals(other.tipologia))
			return false;
		return true;
	}
	public void setPrenotazione(Date prenotazione) {
		this.prenotazione = prenotazione;
	}
	public Date getEsecuzioneEsame() {
		return esecuzioneEsame;
	}
	public void setEsecuzioneEsame(Date esecuzioneEsame) {
		this.esecuzioneEsame = esecuzioneEsame;
	}
	public Map<String, String> getRisultati() {
		return risultati;
	}
	public void setRisultati(Map<String, String> risultati) {
		this.risultati = risultati;
	}
	@Override
	public String toString() {
		return "Esame [idEsame=" + idEsame + ", medico=" + medico + ", paziente=" + paziente + ", tipologia="
				+ tipologia + ", prenotazione=" + prenotazione + ", esecuzioneEsame=" + esecuzioneEsame + ", risultati="
				+ risultati + "]";
	}
	
	
}

