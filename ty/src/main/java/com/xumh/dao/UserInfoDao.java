package com.xumh.dao;

import com.xumh.bean.UserInfo;

public interface UserInfoDao extends Dao<UserInfo>{

	public void updateWeixinInfo(UserInfo userInfo);
	
	public boolean containUser(String openId);
}
