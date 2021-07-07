package main.model;

import java.io.File;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import main.model.Meters;

public class MetersDao implements MetersDaoInterface<Meters, Integer>{
	
	private Session currentSession;
	
	private Transaction currentTransaction;
	
	public MetersDao() {
		
	}
	
	public Session openCurrentSession() {
		currentSession = getSessionFactory().openSession();
		return currentSession;
	}
	
	public Session openCurrentSessionWithTransaction() {
		currentSession = getSessionFactory().openSession();
		currentTransaction = currentSession.beginTransaction();
		return currentSession;
	}
	
	public void closeCurrentSession() {
		currentSession.close();
	}
	
	public void closeCurrentSessionwithTransaction() {
		currentTransaction.commit();
		currentSession.close();
	}
	
	public static SessionFactory getSessionFactory() {
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
		SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
		return sessionFactory;
	}
	
	public Session getCurrentSession() {
		return currentSession;
	}
	
	public void setCurrentSession(Session currentSession) {
		this.currentSession = currentSession;
	}
	
	public Transaction getCurrentTransaction() {
		return currentTransaction;
	}
	
	public void persist(Meters entity) {
		getCurrentSession().save(entity);
	}
	
	public void update(Meters entity) {
		getCurrentSession().update(entity);
	}
	
	public Meters findById(Integer id) {
		Meters meters = (Meters) getCurrentSession().get(Meters.class, id);
		return meters;
	}
	
	public void delete(Meters entity) {
		getCurrentSession().delete(entity);
	}
	
	@SuppressWarnings("unchecked")
	public List<Meters> findAll(){
		List<Meters> meters = (List<Meters>) getCurrentSession().createQuery("from Meters").list();
		return meters;
	}
	
	public void deleteAll() {
		List<Meters> entityList = findAll();
		for(Meters entity : entityList) {
			delete(entity);
		}
	}
}