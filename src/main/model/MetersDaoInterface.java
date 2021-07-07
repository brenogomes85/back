package main.model;

import java.io.Serializable;
import java.util.List;

public interface MetersDaoInterface<T, Id extends Serializable>{

	public void persist(T identity);
	
	public void update(T entity);
	
	public T findById(Id id);
	
	public void delete(T entity);
	
	public List<T> findAll();
	
	public void deleteAll();
	
}
