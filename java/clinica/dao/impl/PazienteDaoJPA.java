package clinica.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import clinica.model.Paziente;

@Repository
public class PazienteDaoJPA {

	private static final Logger logger = LoggerFactory
			.getLogger(EsameDaoJPA.class);

	@Autowired
	private SessionFactory sessionFactory;
	
	public void create(Paziente p) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.save(p);
		session.getTransaction().commit();
		
	}

	public Paziente retrieve(long id) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Paziente paz= (Paziente) session.load(Paziente.class, id);
		session.getTransaction().commit();
		return paz;
	}
	
	public List<Paziente> findAll(){
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		List<Paziente> list=session.createQuery("select p from Paziente p").list();
		session.getTransaction().commit();
		return list;
	}
	
	

	public void update(Paziente p) {

	}

	public void delete(long id) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Paziente e=(Paziente) session.load(Paziente.class, id);
		session.delete(e);
		session.getTransaction().commit();
	}
}
