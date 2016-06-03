package clinica.service.impl;

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
}
