package clinica.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import clinca.dao.UtenteDao;
import clinica.model.Medico;
import clinica.model.Paziente;
import clinica.model.Utente;
@Repository
public class UtenteDaoImpl implements UtenteDao{
	private static final Logger logger = LoggerFactory
			.getLogger(UtenteDaoImpl.class);

	@Autowired
	private SessionFactory sessionFactory;
	public void insertUtente(Utente utente) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(utente);
		session.getTransaction().commit();
		
	}
	public Utente findUtente(String nickname) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		String hql = "FROM Utente m WHERE m.username = :utente_username";
		Query query = session.createQuery(hql);
		query.setParameter("utente_username", nickname);
		Utente p = (Utente)query.uniqueResult();
		return p;
	}

}
