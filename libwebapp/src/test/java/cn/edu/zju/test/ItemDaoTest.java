package cn.edu.zju.test;

import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.edu.zju.dao.ItemDao;
import cn.edu.zju.entity.Item;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:domain.xml")
public class ItemDaoTest {

	@Autowired
	public ItemDao itemDao;
	
	@Test
	@Ignore
	public void save(){
		Item item=new Item();
		item.setBorrowDate(new Date());
		item.setIsdn("0002");
		item.setReaderId("21451001");
		itemDao.save(item);
	}
	
	@Test
	@Ignore
	public void find(){
		Item lists=itemDao.getItem("0002", "21451001");
		System.out.println(lists);
	}
	
	@Test
	@Ignore
	public void update(){
		Item item=itemDao.getItem("0002", "21451001");
		item.setIsHistory('y');
		item.setReturnDate(new Date());
		itemDao.update(item);
	}
	
	@Test
	public void getByReader(){
		List<Item> lists=itemDao.getItemsByReader("21451001");
		System.out.println(lists);
	}
	
	@Test
	public void getByBook(){
		List<Item> lists=itemDao.getItemsByBook("0002");
		System.out.println(lists);
	}
}
