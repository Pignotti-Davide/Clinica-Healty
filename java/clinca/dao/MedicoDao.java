package clinca.dao;

import java.util.List;

import clinica.model.Medico;

public interface MedicoDao {
	public void insertMedico(Medico m);
	public List<Medico> findAll();
	public void deleteMedico(long id);
	public Medico findMedico(long id);
}
