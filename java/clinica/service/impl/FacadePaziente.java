package clinica.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import clinica.dao.impl.PazienteDaoImpl;
import clinica.model.Paziente;
@Service
public class FacadePaziente {

	@Autowired
	private PazienteDaoImpl pazienteDaoImpl;
	public void addPaziente(Paziente p){
		pazienteDaoImpl.insertPaziente(p);
	}
	public List<Paziente> findAllPazienti(){
		return this.pazienteDaoImpl.findAll();
	}
	public Paziente retrievePaziente(long id){
		return this.pazienteDaoImpl.findPaziente(id);
	}
}
