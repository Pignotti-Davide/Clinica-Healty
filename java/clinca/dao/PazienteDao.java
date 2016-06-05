package clinca.dao;

import java.util.List;

import clinica.model.Paziente;

public interface PazienteDao {
	
	public void insertPaziente(Paziente u);
	public List<Paziente> findAll();
	public void deletePaziente(long id);
	public Paziente findPaziente(long id);

}
