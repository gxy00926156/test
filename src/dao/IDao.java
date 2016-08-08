package dao;

import java.util.List;

public interface IDao<T,P> {
	public void insert(T t);
	public void delete(T t);
	public T findById(P p);
	public List<T> findAll();
}
