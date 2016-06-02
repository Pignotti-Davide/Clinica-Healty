package clinica.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import clinica.model.TipologiaEsame;
import clinica.model.Utente;

@Repository
public class UtenteDaoJPA {

	private static final Logger logger = LoggerFactory
			.getLogger(MedicoDaoJPA.class);

	@Autowired
	private SessionFactory sessionFactory;
	
	public Utente retrieve(String id) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Utente utente=(Utente) session.load(Utente.class,id);
		session.getTransaction().commit();
		return utente;
	}
}
