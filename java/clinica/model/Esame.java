package clinica.model;

import java.util.Date;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
public class Esame {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idEsame;
	@OneToOne
	private Medico medico;
	@ManyToOne
	private Paziente paziente;
	@OneToOne
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

