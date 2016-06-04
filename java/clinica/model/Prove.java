package clinica.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import clinica.dao.impl.TipologiaEsameDao;

public class Prove {
	public static void main(String[] argw){
	
	 TipologiaEsameDao tipologiaEsameDao = new TipologiaEsameDao();
	tipologiaEsameDao.insertTipologiaEsame(new TipologiaEsame());
	List<TipologiaEsame> empList =tipologiaEsameDao.listaTipologiaEsame();
	System.out.println(empList.get(0));
	}

}
