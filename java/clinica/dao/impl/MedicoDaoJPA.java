package clinica.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import clinica.model.Medico;

@Repository
public class MedicoDaoJPA {
	private static final Logger logger = LoggerFactory
			.getLogger(MedicoDaoJPA.class);

	@Autowired
	private SessionFactory sessionFactory;

	public void create(Medico m) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.save(m);
		session.getTransaction().commit();

	}

	public Medico retrieve(Long id) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Medico med=(Medico) session.load(Medico.class,id);
		session.getTransaction().commit();
		return med;
	}

	public void update(Medico m) {

	}

	public void delete(long id) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Medico med=(Medico) session.load(Medico.class,id);
		session.delete(med);
		session.getTransaction().commit();
	}
	public List<Medico> findAll(){
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		List<Medico> list=session.createQuery("select m from Medico m").list();
		session.getTransaction().commit();
		return list;
	}
}
