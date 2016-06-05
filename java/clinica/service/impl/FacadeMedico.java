package clinica.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import clinica.dao.impl.MedicoDaoImpl;
import clinica.model.Medico;
@Service
public class FacadeMedico {
	@Autowired
	private MedicoDaoImpl medicoDaoImpl;
	
	public void addMedico(Medico m){
		medicoDaoImpl.insertMedico(m);
	}
	public List<Medico> findAllMedici(){
		return this.medicoDaoImpl.findAll();
	}
	public Medico retrieveMedico(long id){
		return medicoDaoImpl.findMedico(id);
	}
}
