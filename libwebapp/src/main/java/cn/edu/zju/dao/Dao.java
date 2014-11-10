package cn.edu.zju.dao;

import java.io.Serializable;
import java.util.List;

public interface Dao<T> {
	void save(T obj);
	void remove(T obj);
	void update(T obj);
	T get(Serializable id);
	List<T> find(String hql);
	List<T> find(String hql, Object... params);
	void initialize(Object entity);
	Page<T> pagedQuery(String hql, int pageNo, int pageSize, Object... values);
}
