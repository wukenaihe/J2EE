package com.xumh.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.DeserializationConfig.Feature;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sina.sae.fetchurl.SaeFetchurl;
import com.xumh.bean.UserInfo;
import com.xumh.common.PublicServiceInfo;

public class UserWeixinSae implements UserWeixinInterface {
	static private Logger logger = LoggerFactory.getLogger(UserWeixinSae.class);

	@Autowired
	private PublicServiceInfo publicServiceInfo;
	private ObjectMapper mapper;
	private SaeFetchurl fetchUrl;

	public void setPublicServiceInfo(PublicServiceInfo publicServiceInfo) {
		this.publicServiceInfo = publicServiceInfo;
	}

	public UserWeixinSae() {
		fetchUrl = new SaeFetchurl();
		mapper=new ObjectMapper();
		mapper.configure(Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}

	@Override
	public UserInfo getUserInfo(String code) {
		Access_Token access_Token = getAccessToken(code);
		if (access_Token == null)
			return null;
		UserInfo userInfo = getUserInfoFromWeixin(
				access_Token.getAccess_token(), access_Token.getOpenid());
		return userInfo;
	}

	/**
	 * 通过code换取网页授权access_token
	 * 
	 * @param code
	 * @return
	 */
	public Access_Token getAccessToken(String code) {
		String url = String
				.format("https://api.weixin.qq.com/sns/oauth2/access_token?appid=%s&secret=%s&code=%s&grant_type=authorization_code",
						publicServiceInfo.getAppID(),
						publicServiceInfo.getAppsecret(), code);
		String accessTokenStr = fetchUrl.fetch(url);
		Access_Token accessToken = null;
		try {
			System.out.println(accessTokenStr);
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

	public UserInfo getUserInfoFromWeixin(String accessToken, String openId) {
		Map<String, String> urlVariables = new HashMap<String, String>();
		urlVariables.put("access_token", accessToken);
		urlVariables.put("openid", openId);
		String url = String
				.format("https://api.weixin.qq.com/sns/userinfo?access_token=%s&openid=%s&lang=zh_CN",
						accessToken, openId);
		String userInfoStr = fetchUrl.fetch(url);
		UserInfo userInfo = null;
		try {
			userInfoStr=new String(userInfoStr.getBytes("ISO-8859-1"),"UTF-8");
			System.out.println(userInfoStr);
			userInfo = mapper.readValue(userInfoStr, UserInfo.class);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return userInfo;
	}

	public Access_Token getRefreshAccessToken(String refreshAccessToken) {
		String url=String.format("https://api.weixin.qq.com/sns/oauth2/refresh_token?appid=%s&grant_type=refresh_token&refresh_token=%s", publicServiceInfo.getAppID(),refreshAccessToken);
		String accessTokenStr = fetchUrl.fetch(url);
		Access_Token accessToken = null;
		try {
			System.out.println(accessTokenStr);
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
