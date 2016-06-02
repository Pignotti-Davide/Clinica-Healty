package clinica.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import clinica.dao.impl.EsameDao;
import clinica.model.Esame;

@Service
public class FacadeEsame {

	@Autowired
	private EsameDao esameDao;

	public List<Esame> listaEsame() {
		return this.esameDao.listaEsame();
	}

	public void insertEsame(Esame Esame) {
		this.esameDao.insertEsame(Esame);
	}

	public void deleteEsame(Integer esameId) {
		this.esameDao.deleteEsame(esameId);
	}

}