package com.xumh.dao;

import java.util.List;

import com.xumh.bean.ActivityItem;
import com.xumh.bean.UserInfo;

public interface ActivityItemDao extends Dao<ActivityItem> {

	boolean isRegister(String openid,long activityId);
	
	int registerNum(long activityId);
	
	List<UserInfo> getRegisterList(long activityId);
}
