package clinca.dao;

import java.util.List;

import clinica.model.Esame;
import clinica.model.Paziente;

public interface EsameDao {

	public void insertEsame(Esame esame);	
	public List<Esame> findAll();
	public void deleteEsame(long esameId);
	public List<Esame> findEsamiDelPaziente(Paziente p);
	public Esame findEsame(long id);
}
