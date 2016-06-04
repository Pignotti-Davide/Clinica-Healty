package clinica.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import clinica.dao.impl.PazienteDao;
import clinica.model.Paziente;
@Service
public class FacadePaziente {

	@Autowired
	private PazienteDao pazienteDao;
	public void addPaziente(Paziente p){
		pazienteDao.insertPaziente(p);
	}
	public List<Paziente> findAllPazienti(){
		return this.pazienteDao.listaPaziente();
	}
	public Paziente retrievePaziente(long id){
		return this.pazienteDao.findPaziente(id);
	}
}
