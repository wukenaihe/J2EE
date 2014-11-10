package cn.edu.zju.test;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.edu.zju.dao.BookDao;
import cn.edu.zju.entity.Book;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:domain.xml")
public class BookDaoTest {
	
	@Autowired
	public BookDao bookDao;
	
	@Test
	@Ignore
	public void add(){
		Book b=new Book();
		b.setIsdn("0002");
		b.setAuthor("Jam");
		b.setBookname("Thinking in C++");
		b.setPublish("机械工业");
		b.setTotal(10);
		b.setRemain(10);
		bookDao.save(b);
	}
	
	@Test
	@Ignore
	public void update(){
		Book b=new Book();
		b.setIsdn("0002");
		b.setAuthor("Jam");
		b.setBookname("Thinking in C++");
		b.setPublish("机械工业");
		b.setTotal(11);
		b.setRemain(11);
		bookDao.update(b);
	}
	
	@Test
	@Ignore
	public void delete(){
		Book b=bookDao.get("0002");
		bookDao.remove(b);
	}
	
	
	@Test
	public void getAll(){
		List<Book> list=bookDao.find("from Book");
		System.out.println(list);
	}
}
