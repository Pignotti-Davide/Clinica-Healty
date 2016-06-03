package clinica.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import clinica.model.Medico;



@Repository
public class MedicoDao {

	private static final Logger logger = LoggerFactory
			.getLogger(MedicoDao.class);

	@Autowired
	private SessionFactory sessionFactory;

	public void insertUtente(Medico m) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(m);
		session.getTransaction().commit();
	}

	@SuppressWarnings("unchecked")
	public List<Medico> listaMedico() {
		Session session = sessionFactory.openSession();
		String hql = "FROM Medico";
		Query query = session.createQuery(hql);
		List<Medico> uList = query.list();
		logger.info("Medico List::" + uList);
		return uList;
	}

	public void deleteMedico(Integer utenteId) {
		System.out.println("hql Using Delete");
		Session session = sessionFactory.openSession();
		String hql = "DELETE from Medico M WHERE M.id = :medico_id";
		Query query = session.createQuery(hql);
		query.setParameter("medico_id", utenteId);
		int result = query.executeUpdate();
		System.out.println("Row affected: " + result);
	}
}

