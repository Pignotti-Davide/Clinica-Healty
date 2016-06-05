package clinica.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import clinica.dao.impl.MedicoDaoImpl;
import clinica.model.Esame;
import clinica.model.Medico;
@Service
public class FacadeMedico {
	@Autowired
	private MedicoDaoImpl medicoDaoImpl;
	
	public void addMedico(Medico m){
		medicoDaoImpl.insertMedico(m);
	}
	public List<Medico> findAll(){
		return this.medicoDaoImpl.findAll();
	}
	public Medico retrieveMedico(long id){
		return medicoDaoImpl.findMedico(id);
	}
	public void deleteMedico(long esameId) {
		this.medicoDaoImpl.deleteMedico(esameId);
	}
	public List<Esame> listaEsami(long id) {
		return this.medicoDaoImpl.findListaEsame(id);
	}
}
