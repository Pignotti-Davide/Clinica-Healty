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

	private static final Logger logger = LoggerFactory.getLogger(TipologiaEsameDaoImpl.class);

	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public void insertTipologiaEsame(TipologiaEsame tipologia) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(tipologia);
		session.getTransaction().commit();
	}
	@SuppressWarnings("unchecked")
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
	public List<String> listaRisultati(long id){
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<String> list = (List<String>) session.createQuery("select t from TipologiaEsame t").list();
		session.getTransaction().commit();
		return list;
	}
	@Override
	public void deleteTipologiaEsame(long id) {
		Session session = sessionFactory.openSession();		
		Query query = session.createSQLQuery("DELETE from tipologiaesame_indicatoriRisultati T WHERE T.tipologiaesame_tipologia_id = :tipologiaesame_id");
		query.setParameter("tipologiaesame_id", id);
		Query query3 = session.createSQLQuery("DELETE from tipologiaesame_requisiti T WHERE T.tipologiaesame_tipologia_id = :tipologiaesame_id");
		query3.setParameter("tipologiaesame_id", id);
		int result = query.executeUpdate();	
		String hql2 = "DELETE from TipologiaEsame T WHERE T.id = :tipologiaesame_id";
		Query query2 = session.createQuery(hql2);
		query2.setParameter("tipologiaesame_id", id);
		System.out.println("Row affected: " + result);
	}
}