package clinca.dao;

import java.util.List;

import clinica.model.TipologiaEsame;

public interface TipologiaEsameDao {

	public void insertTipologiaEsame(TipologiaEsame tipologia);
	public List<TipologiaEsame> findAll();
	public TipologiaEsame findTipologiaEsame(long id);
	public void deleteTipologiaEsame(long id);
}
