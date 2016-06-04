package clinica.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import clinica.dao.impl.TipologiaEsameDao;
import clinica.model.TipologiaEsame;

@Service
public class FacadeTipologiaEsame {

	@Autowired
	private TipologiaEsameDao tipologiaEsameDao;

	public List<TipologiaEsame> listaTipologiaEsame() {
		return this.tipologiaEsameDao.listaTipologiaEsame();
	}

	public void addTipologiaEsame(TipologiaEsame tipologiaEsame) {
		this.tipologiaEsameDao.insertTipologiaEsame(tipologiaEsame);
	}

	public void deleteTipologiaEsame(long tipId) {
		this.tipologiaEsameDao.deleteTipologiaEsame(tipId);
	}
	
	public TipologiaEsame retrieveTipologiaEsame(long id){
		return this.tipologiaEsameDao.findTipologiaEsame(id);
	}

}