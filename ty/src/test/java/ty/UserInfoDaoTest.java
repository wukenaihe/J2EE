package ty;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import com.xumh.bean.UserInfo;
import com.xumh.dao.UserInfoDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:config.xml")
public class UserInfoDaoTest {

	@Autowired
	public UserInfoDao userInfoDao;
	
	@Test
	@Ignore
	public void save(){
		UserInfo userInfo=new UserInfo();
		userInfo.setOpenid("oUKteuDrXHEdt_8qasEWkn9FNqbw");
		userInfo.setCity("杭州");
		userInfo.setSex(1);
		
		userInfo.setName("许敏华");
		userInfo.setSingle("单身");
		userInfo.setAge(26);
		userInfo.setSexOrientation("直的");
		
		userInfoDao.save(userInfo);
	}
	
	@Test
	@Ignore
	public void update(){
		UserInfo userInfo=new UserInfo();
		userInfo.setOpenid("oUKteuDrXHEdt_8qasEWkn9FNqbw");
		userInfo.setCity("杭州");
		userInfo.setSex(1);
		userInfo.setProvince("浙江");
		
		userInfoDao.updateWeixinInfo(userInfo);

	}
	
	@Test
//	@Ignore
	public void containUser(){
		boolean r=userInfoDao.containUser("oUKteuDrXHEdt_8qasEWkn9FNqbw");
		Assert.isTrue(r);
		r=userInfoDao.containUser("1");
		Assert.isTrue(!r);
	}
}
