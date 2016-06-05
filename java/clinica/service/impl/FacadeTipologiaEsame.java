package clinica.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import clinica.dao.impl.TipologiaEsameDaoImpl;
import clinica.model.TipologiaEsame;

@Service
public class FacadeTipologiaEsame {

	@Autowired
	private TipologiaEsameDaoImpl tipologiaEsameDaoImpl;

	public List<TipologiaEsame> findAll() {
		return this.tipologiaEsameDaoImpl.findAll();
	}

	public void addTipologiaEsame(TipologiaEsame tipologiaEsame) {
		this.tipologiaEsameDaoImpl.insertTipologiaEsame(tipologiaEsame);
	}

	public void deleteTipologiaEsame(long tipId) {
		this.tipologiaEsameDaoImpl.deleteTipologiaEsame(tipId);
	}
	
	public TipologiaEsame retrieveTipologiaEsame(long id){
		return this.tipologiaEsameDaoImpl.findTipologiaEsame(id);
	}

}