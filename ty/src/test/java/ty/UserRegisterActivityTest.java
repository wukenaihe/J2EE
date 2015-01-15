package ty;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import com.xumh.dto.ActivityRegisterRecord;
import com.xumh.service.UserRegisterActivity;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:config.xml")
public class UserRegisterActivityTest {
	
	@Autowired
	public UserRegisterActivity userRegisterActivity;
	
	@Test
	@Ignore
	public void isRegister(){
		boolean r=userRegisterActivity.isRegister("oUKteuDrXHEdt_8qasEWkn9FNqbw");
		
		Assert.isTrue(r);
		
		r=userRegisterActivity.isRegister("asdgcasdf");
		
		Assert.isTrue(!r);
	}
	
	@Test
	public void getActivityRegisterRecords(){
		List<ActivityRegisterRecord> lists=userRegisterActivity.getActivityRegisterRecords("oUKteuDrXHEdt_8qasEWkn9FNqbw");
		
		System.out.println(lists);
	}
	
}
