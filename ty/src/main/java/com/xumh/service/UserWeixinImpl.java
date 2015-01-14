package com.xumh.service;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.DeserializationConfig.Feature;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.xumh.bean.UserInfo;
import com.xumh.common.PublicServiceInfo;

public class UserWeixinImpl implements UserWeixinInterface{
	
	static private Logger logger=LoggerFactory.getLogger(UserWeixinImpl.class);
	
	@Autowired
	private PublicServiceInfo publicServiceInfo;
//	@Autowired
	private RestTemplate rt;
	private ObjectMapper mapper;

	public void setPublicServiceInfo(PublicServiceInfo publicServiceInfo) {
		this.publicServiceInfo = publicServiceInfo;
	}


	public void setRt(RestTemplate rt) {
		this.rt = rt;
	}
	
	public UserWeixinImpl() {
		rt=new RestTemplate();
		StringHttpMessageConverter shm=new StringHttpMessageConverter(Charset.forName("UTF-8"));
		List<HttpMessageConverter<?>> list=new ArrayList<HttpMessageConverter<?>>();
		list.add(shm);
		rt.setMessageConverters(list);
		mapper = new ObjectMapper();
		mapper.configure(Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}



	@Override
	public UserInfo getUserInfo(String code) {
		Access_Token access_Token=getAccessToken(code);
		if(access_Token==null) return null;
		UserInfo userInfo=getUserInfoFromWeixin(access_Token.getAccess_token(), access_Token.getOpenid());
		return userInfo;
	}
	
	/**
	 * 通过code换取网页授权access_token
	 * 
	 * @param code
	 * @return
	 */
	public Access_Token getAccessToken(String code){
		Map<String, String> urlVariables=new HashMap<String, String>();
		urlVariables.put("appid", publicServiceInfo.getAppID());
		urlVariables.put("secret", publicServiceInfo.getAppsecret());
		urlVariables.put("code", code);
		String accessTokenStr=rt.getForObject("https://api.weixin.qq.com/sns/oauth2/access_token?appid={appid}&secret={secret}&code={code}&grant_type=authorization_code", String.class, urlVariables);
		Access_Token accessToken = null;
		try {
			accessToken = mapper.readValue(accessTokenStr, Access_Token.class);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return accessToken;
	}
	
	public UserInfo getUserInfoFromWeixin(String accessToken,String openId){
		Map<String, String> urlVariables=new HashMap<String, String>();
		urlVariables.put("access_token", accessToken);
		urlVariables.put("openid", openId);
		String userInfoStr=rt.getForObject("https://api.weixin.qq.com/sns/userinfo?access_token={access_token}&openid={openid}&lang=zh_CN", String.class, urlVariables);
		UserInfo userInfo=null;
		try {
			userInfo=mapper.readValue(userInfoStr, UserInfo.class);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return userInfo;
	}
	
	public Access_Token getRefreshAccessToken(String refreshAccessToken){
		Map<String, String> urlVariables=new HashMap<String, String>();
		urlVariables.put("refresh_token", refreshAccessToken);
		urlVariables.put("appid", publicServiceInfo.getAppID());
		String accessTokenStr=rt.getForObject("https://api.weixin.qq.com/sns/oauth2/refresh_token?appid={appid}&grant_type=refresh_token&refresh_token={refresh_token}", String.class, urlVariables);
		Access_Token accessToken = null;
		try {
			accessToken = mapper.readValue(accessTokenStr, Access_Token.class);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return accessToken;
	}

}
