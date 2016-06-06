package clinica.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import clinica.dao.impl.EsameDaoImpl;
import clinica.model.Esame;

@Service
public class FacadeEsame {

	@Autowired
	private EsameDaoImpl esameDaoImpl;

	public List<Esame> findAll() {
		return this.esameDaoImpl.findAll();
	}

	public void addEsame(Esame Esame) {
		this.esameDaoImpl.insertEsame(Esame);
	}

	public void deleteEsame(long esameId) {
		this.esameDaoImpl.deleteEsame(esameId);
	}
	public Esame findEsame(long id){
		return this.esameDaoImpl.findEsame(id);
	}
	public void updateEsame(Esame e){
		this.esameDaoImpl.updateEsame(e);
	}
}