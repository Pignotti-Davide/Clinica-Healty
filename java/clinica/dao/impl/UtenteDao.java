package clinica.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import clinica.model.Utente;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



@Repository
public class UtenteDao {

	private static final Logger logger = LoggerFactory
			.getLogger(UtenteDao.class);

	@Autowired
	private SessionFactory sessionFactory;

	public void insertUtente(Utente u) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(u);
		session.getTransaction().commit();
	}

	@SuppressWarnings("unchecked")
	public List<Utente> listaUtente() {
		Session session = sessionFactory.openSession();
		String hql = "FROM Utente";
		Query query = session.createQuery(hql);
		List<Utente> uList = query.list();
		logger.info("Utente List::" + uList);
		return uList;
	}

	public void deleteUtente(Integer utenteId) {
		System.out.println("hql Using Delete");
		Session session = sessionFactory.openSession();
		String hql = "DELETE from Utente U WHERE U.id = :utente_id";
		Query query = session.createQuery(hql);
		query.setParameter("utente_id", utenteId);
		int result = query.executeUpdate();
		System.out.println("Row affected: " + result);
	}
}
