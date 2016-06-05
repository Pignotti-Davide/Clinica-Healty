package clinica.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import clinica.dao.impl.EsameDaoImpl;
import clinica.model.Esame;

@Service
public class FacadeEsame {

	@Autowired
	private EsameDaoImpl esameDaoImpl;

	public List<Esame> listaEsame() {
		return this.esameDaoImpl.findAll();
	}

	public void addEsame(Esame Esame) {
		this.esameDaoImpl.insertEsame(Esame);
	}

	public void deleteEsame(long esameId) {
		this.esameDaoImpl.deleteEsame(esameId);
	}

}