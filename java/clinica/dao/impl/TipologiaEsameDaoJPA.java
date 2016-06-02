package clinica.dao.impl;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import clinica.model.TipologiaEsame;
@Repository
public class TipologiaEsameDaoJPA {
	private static final Logger logger = LoggerFactory
			.getLogger(MedicoDaoJPA.class);

	@Autowired
	private SessionFactory sessionFactory;
	public void create(TipologiaEsame esa) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.save(esa);
		session.getTransaction().commit();
	}

	public TipologiaEsame retrieve(long id) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		TipologiaEsame tip=(TipologiaEsame) session.load(TipologiaEsame.class,id);
		session.getTransaction().commit();
		return tip;
	}

	public void update(long id) {
	
	}

	public void delete(long id) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		TipologiaEsame tip=(TipologiaEsame) session.load(TipologiaEsame.class,id);
		session.delete(tip);
		session.getTransaction().commit();
		
	}
	public List<TipologiaEsame> findAll(){
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		List<TipologiaEsame> list=session.createQuery("select t from TipologiaEsame t").list();
		session.getTransaction().commit();
		return list;
	}
}
