package cn.edu.zju.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import cn.edu.zju.dao.UserDao;
import cn.edu.zju.entity.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:domain.xml")
public class UserDaoTest {

	@Autowired
	public UserDao userDao;
	
	@Test
	public void save(){
		User user=new User();
		user.setId("21451001");
		user.setPassword("123456");
		
		userDao.save(user);
		
		User userNew=userDao.get("21451001");
		
		Assert.notNull(userNew);
	}
}
