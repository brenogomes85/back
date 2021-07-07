package main.model;

import java.util.List;

import main.model.Meters;
import main.model.MetersDao;

public class MetersService {

	private static MetersDao metersDao;
	
	public MetersService() {
		metersDao = new MetersDao();
	}
	
	public void persist(Meters entity) {
		metersDao.openCurrentSessionWithTransaction();
		metersDao.persist(entity);
		metersDao.closeCurrentSessionwithTransaction();
	}
	
	public void update(Meters entity) {
		metersDao.openCurrentSessionWithTransaction();
		metersDao.update(entity);
		metersDao.closeCurrentSessionwithTransaction();
	}
	
	public Meters findById(Integer id) {
		metersDao.openCurrentSession();
		Meters meters = metersDao.findById(id);
		metersDao.closeCurrentSession();
		return meters;
	}
	
	public void delete(Integer id) {
		metersDao.openCurrentSessionWithTransaction();
		Meters meters = metersDao.findById(id);
		metersDao.delete(meters);
		metersDao.closeCurrentSessionwithTransaction();
	}
	
	public List<Meters> findAll(){
		metersDao.openCurrentSession();
		List<Meters> meters = metersDao.findAll();
		metersDao.closeCurrentSession();
		return meters;
	}
	
	public void deleteAll() {
		metersDao.openCurrentSessionWithTransaction();
		metersDao.deleteAll();
		metersDao.closeCurrentSessionwithTransaction();
	}
	
	public MetersDao metersDao() {
		return metersDao;
	}
	
}
