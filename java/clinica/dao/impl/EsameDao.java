package clinica.dao.impl;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import clinica.model.Esame;
import clinica.model.Paziente;


@Repository
public class EsameDao {

	private static final Logger logger = LoggerFactory
			.getLogger(EsameDao.class);

	@Autowired
	private SessionFactory sessionFactory;

	public void insertEsame(Esame esame) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(esame);
		session.getTransaction().commit();
	}

	@SuppressWarnings("unchecked")
	public List<Esame> listaEsame() {
		Session session = sessionFactory.openSession();
		String hql = "FROM Esame";
		Query query = session.createQuery(hql);
		List<Esame> empList = query.list();
		logger.info("Esame List::" + empList);
		return empList;
	}

	public void deleteEsame(long esameId) {
		System.out.println("hql Using Delete");
		Session session = sessionFactory.openSession();
		String hql = "DELETE from Esame E WHERE E.id = :esame_id";
		Query query = session.createQuery(hql);
		query.setParameter("esame_id", esameId);
		int result = query.executeUpdate();
		System.out.println("Row affected: " + result);
	}
	public List<Esame> retrieveEsamiDelPaziente(Paziente p){
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		List<Esame> list=session.createQuery("select e from Esame e where e.paziente.idPaziente="+p.getIdPaziente()).list();
		session.getTransaction().commit();
		return list;
	}
}
