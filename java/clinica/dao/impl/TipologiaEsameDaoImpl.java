package clinica.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import clinca.dao.TipologiaEsameDao;
import clinica.model.TipologiaEsame;


@Repository
public class TipologiaEsameDaoImpl implements TipologiaEsameDao{

	private static final Logger logger = LoggerFactory
			.getLogger(TipologiaEsameDaoImpl.class);

	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public void insertTipologiaEsame(TipologiaEsame tipologia) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(tipologia);
		session.getTransaction().commit();
	}
	@Override
	public List<TipologiaEsame> findAll() {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		List<TipologiaEsame> list = (List<TipologiaEsame>) session.createQuery("select t from TipologiaEsame t").list();
		session.getTransaction().commit();
		return list;
	}
	@Override
	public TipologiaEsame findTipologiaEsame(long id){
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		TipologiaEsame t=(TipologiaEsame) session.get(TipologiaEsame.class, id);
		session.getTransaction().commit();
		return t;
		
	}

	public TipologiaEsame findMappaRequisiti(long id){
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		TipologiaEsame t=(TipologiaEsame) session.get(TipologiaEsame.class, id);
		session.getTransaction().commit();
		return t;
		
	}
	@Override
	public void deleteTipologiaEsame(long id) {
		System.out.println("hql Using Delete");
		Session session = sessionFactory.openSession();		
		String hql = "DELETE from TipologiaEsame T WHERE T.id = :tipologiaesame_id";
		Query query = session.createQuery(hql);
		query.setParameter("tipologiaesame_id", id);
		int result = query.executeUpdate();		
		System.out.println("Row affected: " + result);
	}
}