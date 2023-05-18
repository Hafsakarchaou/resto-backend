package Dao;

import java.util.List;

public interface IDao<T> {

	T save(T o);
	
	List<T> findAll();
	
	T findById(String id);
	
	void  update(String id,T o);
	
	void delete (String id);
}
