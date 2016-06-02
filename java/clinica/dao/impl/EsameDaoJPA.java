package clinica.dao.impl;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import clinica.model.Esame;
import clinica.model.Paziente;

@Repository
public class EsameDaoJPA {

	private static final Logger logger = LoggerFactory
			.getLogger(EsameDaoJPA.class);

	@Autowired
	private SessionFactory sessionFactory;
	
	public void create(Esame es) {
	Session session=sessionFactory.openSession();
	session.beginTransaction();
	session.save(es);
	session.getTransaction().commit();
	}

	public Esame retrieve(long id) {
	
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Esame es= (Esame) session.load(Esame.class, id);
		session.getTransaction().commit();
		return es;
	}

	public void update(long id) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Esame e=(Esame) session.load(Esame.class, id);
		//set vari
		session.update(e);
		session.getTransaction().commit();
	}

	public void delete(long id) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Esame e=(Esame) session.load(Esame.class, id);
		session.delete(e);
		session.getTransaction().commit();
	}

	public List<Esame> retrieveEsamiDelPaziente(Paziente p){
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		List<Esame> list=session.createQuery("select e from Esame e where e.paziente.idPaziente="+p.getIdPaziente()).list();
		session.getTransaction().commit();
		return list;
	}
}

