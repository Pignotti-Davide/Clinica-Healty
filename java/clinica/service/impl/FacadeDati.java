package clinica.service.impl;

import java.util.List;

import clinica.dao.impl.EsameDaoJPA;
import clinica.dao.impl.MedicoDaoJPA;
import clinica.dao.impl.PazienteDaoJPA;
import clinica.dao.impl.TipologiaEsameDaoJPA;
import clinica.model.Esame;
import clinica.model.Medico;
import clinica.model.Paziente;
import clinica.model.TipologiaEsame;

public class FacadeDati {
	
	public void salvaMedico(Medico m){
		new MedicoDaoJPA().create(m);
	}
	
	public void salvaEsame(Esame e){
	new EsameDaoJPA().create(e);}
	
	public void salvaPaziente(Paziente p){
		new PazienteDaoJPA().create(p);
		
	}
	
	public void salvaTipologiaEsame(TipologiaEsame t){
		new TipologiaEsameDaoJPA().create(t);
	}
	
	public TipologiaEsame trovaTipologiaEsame(long id){
		return new TipologiaEsameDaoJPA().retrieve(id);
	}

	public Paziente trovaPaziente(long id) {
		return new PazienteDaoJPA().retrieve(id);
	}

	public Medico trovaMedico(long id) {
		return new MedicoDaoJPA().retrieve(id);
	}
	public List<TipologiaEsame> findAllTipologieEsami(){
		return new TipologiaEsameDaoJPA().findAll();
	}
	public List<Medico> findAllMedici(){
		return new MedicoDaoJPA().findAll();
	}
	public List<Paziente> findAllPazienti(){
		return new PazienteDaoJPA().findAll();
	}
	
}
