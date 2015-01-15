package com.xumh.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.xumh.bean.Activity;

@Repository("acitvityDao")
public class ActivityDaoImpl extends HbBaseDao<Activity> implements ActivityDao {
		private static Logger logger=LoggerFactory.getLogger(ActivityDaoImpl.class);
	
	public static final String GET_UNEXCEEDFULL_ACTIVITIES="from Activity a where a.lastDate>current_date()";
	@Override
	public List<Activity> getUnexceedActivities() {
		List<Activity> activities=hibernateTemplate.find(GET_UNEXCEEDFULL_ACTIVITIES);
		
		return activities;
	}

	
}
