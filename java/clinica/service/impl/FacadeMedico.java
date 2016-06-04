package clinica.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import clinica.dao.impl.MedicoDao;
import clinica.model.Medico;
@Service
public class FacadeMedico {
	@Autowired
	private MedicoDao medicoDao;
	
	public void addMedico(Medico m){
		medicoDao.insertMedico(m);
	}
	public List<Medico> findAllMedici(){
		return this.medicoDao.listaMedico();
	}
}
