package clinca.dao;

import clinica.model.Utente;

public interface UtenteDao {
	public void insertUtente(Utente utente);
	public Utente findUtente(String nickname) ;
}
