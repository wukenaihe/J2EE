package com.xumh.dao;

import java.util.List;

import com.xumh.bean.Activity;

public interface ActivityDao extends Dao<Activity> {
	List<Activity> getUnexceedActivities();
}
