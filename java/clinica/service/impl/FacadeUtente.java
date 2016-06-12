package clinica.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import clinica.dao.impl.PazienteDaoImpl;
import clinica.dao.impl.UtenteDaoImpl;
import clinica.model.Paziente;
import clinica.model.Utente;
@Service
public class FacadeUtente {
	@Autowired
	private UtenteDaoImpl utenteDaoImpl;
	public void addUtente(Utente utente) {
		utenteDaoImpl.insertUtente(utente);
		
	}
	public Utente retrieveUtente(String nickname){
		return this.utenteDaoImpl.findUtente(nickname);
	}
}
