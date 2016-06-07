package clinica.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import clinca.dao.MedicoDao;
import clinica.model.Esame;
import clinica.model.Medico;



@Repository
public class MedicoDaoImpl implements MedicoDao{

	private static final Logger logger = LoggerFactory.getLogger(MedicoDaoImpl.class);

	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public void insertMedico(Medico m) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(m);
		session.getTransaction().commit();
	}
	@Override
	@SuppressWarnings("unchecked")
	public List<Medico> findAll() {
		Session session = sessionFactory.openSession();
		String hql = "FROM Medico";
		Query query = session.createQuery(hql);
		List<Medico> uList = query.list();
		logger.info("Medico List::" + uList);
		return uList;
	}
	@Override
	public void deleteMedico(long id) {
		System.out.println("hql Using Delete");
		Session session = sessionFactory.openSession();
		String hql = "DELETE from Medico M WHERE M.id = :medico_id";
		Query query = session.createQuery(hql);
		query.setParameter("medico_id", id);
		int result = query.executeUpdate();
		System.out.println("Row affected: " + result);
	}
	@Override
	public Medico findMedico(long id){
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Medico m=(Medico) session.get(Medico.class, id);
		session.getTransaction().commit();
		return m;
	}
	public Medico findMedicoPerNomeECognome(String nome, String cognome){
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		String hql = "FROM Medico m WHERE m.nome = :medico_nome and m.cognome=:medico_cognome";
		Query query = session.createQuery(hql);
		query.setParameter("medico_nome", nome);
		query.setParameter("medico_cognome", cognome);
		Medico medico = (Medico)query.uniqueResult();
		return medico;

	}
	@SuppressWarnings("unchecked")
	public List<Esame>  findListaEsame(long id){
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		List<Esame> lista = new ArrayList<>();
		String hql = "FROM Esame c WHERE c.medico.idMedico = :medico_id";
		Query query = session.createQuery(hql);
		query.setParameter("medico_id", id);
		lista = (List<Esame>)query.list();
		return lista;
	}
}

