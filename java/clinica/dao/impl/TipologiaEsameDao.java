package clinica.dao.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaQuery;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import clinica.model.TipologiaEsame;


@Repository
public class TipologiaEsameDao {

	private static final Logger logger = LoggerFactory
			.getLogger(TipologiaEsameDao.class);

	@Autowired
	private SessionFactory sessionFactory;

	public void insertTipologiaEsame(TipologiaEsame tipologia) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(tipologia);
		session.getTransaction().commit();
	}

	
	public List<TipologiaEsame> listaTipologiaEsame() {
		System.out.println("ok");
		Session session=sessionFactory.getCurrentSession();
		System.out.println("ok");
		session.beginTransaction();
		String hql = "FROM TipologiaEsame";
		System.out.println("ok");
		Query query = session.createQuery(hql);
		System.out.println("ok");
		List<TipologiaEsame> empList = query.list();
		System.out.println("ok2");
		logger.info("TipologiaEsame List::" + empList);
		System.out.println("ok3");
		System.out.println(empList.get(1));
		return empList;
	}

	public void deleteTipologiaEsame(long esameId) {
		System.out.println("hql Using Delete");
		Session session = sessionFactory.openSession();		
		String hql = "DELETE from TipologiaEsame T WHERE T.id = :tipologiaesame_id";
		Query query = session.createQuery(hql);
		query.setParameter("tipologiaesame_id", esameId);
		int result = query.executeUpdate();		
		System.out.println("Row affected: " + result);
	}
}