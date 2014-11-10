package cn.edu.zju.dao;

import java.util.List;

import cn.edu.zju.entity.Book;

public interface BookDao extends Dao<Book> {
	public List<Book> findAll();
}
