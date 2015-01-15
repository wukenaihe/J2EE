package com.xumh.dao;

import com.xumh.bean.ActivityItem;

public interface ActivityItemDao extends Dao<ActivityItem> {

	boolean isRegister(String openid,long activityId);
	
	int registerNum(long activityId);
}
