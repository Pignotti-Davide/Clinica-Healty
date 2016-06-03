package clinica.dao.impl;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import clinica.model.Paziente;



@Repository
public class PazienteDao {

	private static final Logger logger = LoggerFactory
			.getLogger(PazienteDao.class);

	@Autowired
	private SessionFactory sessionFactory;

	public void insertPaziente(Paziente u) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(u);
		session.getTransaction().commit();
	}

	@SuppressWarnings("unchecked")
	public List<Paziente> listaPaziente() {
		Session session = sessionFactory.openSession();
		String hql = "FROM Paziente";
		Query query = session.createQuery(hql);
		List<Paziente> uList = query.list();
		logger.info("Paziente List::" + uList);
		return uList;
	}

	public void deletePaziente(Integer pazienteId) {
		System.out.println("hql Using Delete");
		Session session = sessionFactory.openSession();
		String hql = "DELETE from Paziente P WHERE P.id = :paziente_id";
		Query query = session.createQuery(hql);
		query.setParameter("paziente_id", pazienteId);
		int result = query.executeUpdate();
		System.out.println("Row affected: " + result);
	}
}