package ty;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import com.sina.sae.fetchurl.SaeFetchurl;
import com.xumh.bean.UserInfo;
import com.xumh.service.Access_Token;
import com.xumh.service.UserWeixinImpl;
import com.xumh.service.UserWeixinSae;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:config.xml")
public class UserWeiXinImplTest {
	@Autowired
	public UserWeixinSae userWeixinImpl;

	@Test
	@Ignore
	public void getAccessToken() {
		Access_Token a = userWeixinImpl
				.getAccessToken("OezXcEiiBSKSxW0eoylIeBQ_nGm2emrnW_6Uto1lDh9BmWKo3ZZmjHbTZTmotpuwNR0L-cZWfGBpzBP1o2lBw2QGXsI1Mh8CvNaQed23Lq-rMh6aAq2NBSZQxiomCyN6HcnaCE6qpufUpSo7tSDgUQ");
		System.out.println(a);
	}

	@Test
//	@Ignore
	public void getUserInfoStr() {
		Access_Token acess_token = userWeixinImpl
				.getRefreshAccessToken("OezXcEiiBSKSxW0eoylIeBQ_nGm2emrnW_6Uto1lDh9BmWKo3ZZmjHbTZTmotpuwhbAe3xCqJt66yURRuVYDT9CrZOBO4k9IpsVKrHDB3I2WmbeQMkBkZ8l_mtrDMUH7WDqwqCxgpLhiTUlk91klnw");
		System.out.println(acess_token);
		UserInfo userInfo = userWeixinImpl.getUserInfoFromWeixin(
				acess_token.getAccess_token(), acess_token.getOpenid());
		System.out.println(userInfo);
	}

	@Test
	@Ignore
	public void getRefreshAccessToken(){
		Access_Token a=userWeixinImpl.getRefreshAccessToken("OezXcEiiBSKSxW0eoylIeBQ_nGm2emrnW_6Uto1lDh9BmWKo3ZZmjHbTZTmotpuwhbAe3xCqJt66yURRuVYDT9CrZOBO4k9IpsVKrHDB3I2WmbeQMkBkZ8l_mtrDMUH7WDqwqCxgpLhiTUlk91klnw");
		System.out.println(a);
		
	}

	@Test
	@Ignore
	public void getUserInfo() {
		UserInfo userInfo = userWeixinImpl
				.getUserInfo("041cab5b40d1ccefeaccd8b68fd5f01f");
		Assert.notNull(userInfo);
		System.out.println(userInfo);
	}
}
