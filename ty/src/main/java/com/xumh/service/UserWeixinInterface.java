package com.xumh.service;

import com.xumh.bean.UserInfo;

public interface UserWeixinInterface {
	/**
	 * 根据用户同意获取的授权code获取用户基本信息
	 * 
	 * @param code
	 * @return
	 */
	UserInfo getUserInfo(String code);
	Access_Token getAccessToken(String code);
}
