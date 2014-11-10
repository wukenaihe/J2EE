package cn.edu.zju.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.zju.entity.Book;

@Repository("bookDao")
public class BookHDao extends HbBaseDao<Book> implements BookDao{

	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<Book> findAll() {
		List<Book> list=find("from Book");
		return list;
	}
	
}
