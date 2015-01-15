package ty;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import com.xumh.bean.Activity;
import com.xumh.dao.ActivityDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:config.xml")
public class ActivityDaoTest {

	@Autowired
	public ActivityDao activityDao;
	
	@Test
	@Ignore
	public void save() throws Exception{
		Activity a1=new Activity();
		Calendar c=Calendar.getInstance();
		DateFormat d=new SimpleDateFormat("yyyy/MM/dd");
		Date date1=d.parse("2015/01/16");
		a1.setLastDate(date1);
		a1.setMaxPepole(37);
		a1.setName("大明山滑雪");
		a1.setRemark("风景优美");
		
		activityDao.save(a1);
		
		
		Activity a2=new Activity();
		a2.setLastDate(d.parse("2015/01/02"));
		a2.setMaxPepole(10);
		a2.setName("龙须山");
		
		activityDao.save(a2);
	}
	
	@Test
	public void getUnexceedFullActivities(){
		List<Activity> activities=activityDao.getUnexceedActivities();
		System.out.println(activities);
		Assert.notEmpty(activities);
	}
}
