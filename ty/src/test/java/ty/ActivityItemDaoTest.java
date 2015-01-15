package ty;

import java.util.Date;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import com.xumh.bean.ActivityItem;
import com.xumh.dao.ActivityItemDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:config.xml")
public class ActivityItemDaoTest {

	@Autowired
	public ActivityItemDao activityItemDao;
	
	@Test
	@Ignore
	public void isRegister(){
		boolean r=activityItemDao.isRegister("oUKteuDrXHEdt_8qasEWkn9FNqbw", 2);
		
		Assert.isTrue(!r);
		
		r=activityItemDao.isRegister("oUKteuDrXHEdt_8qasEWkn9FNqbw", 1);
		Assert.isTrue(r);
	}
	
	@Test
	public void registerNum(){
		int num=activityItemDao.registerNum(1);
		
		Assert.isTrue(num==1);
		
		num=activityItemDao.registerNum(3);
		Assert.isTrue(num==0);
	}
	
	@Test
	@Ignore
	public void save(){
		ActivityItem activityItem=new ActivityItem();
		activityItem.setActivityId(1);
		activityItem.setOpenId("oUKteuDrXHEdt_8qasEWkn9FNqbw");
		activityItem.setRegisteDate(new Date());
		activityItem.setRemark("会带个人");
		
		activityItemDao.save(activityItem);
	}
}
