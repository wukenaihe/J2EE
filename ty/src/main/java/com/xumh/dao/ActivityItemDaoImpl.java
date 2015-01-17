package com.xumh.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.xumh.bean.ActivityItem;
import com.xumh.bean.UserInfo;

@Repository("activityItemDao")
public class ActivityItemDaoImpl extends HbBaseDao<ActivityItem> implements ActivityItemDao {

	private static Logger logger=LoggerFactory.getLogger(ActivityDaoImpl.class);
	
	public static final String IS_REGISTER="select count(id) from ty_activity_item where openId=? and activityId=?";
	
	public static final String ACTIVITYITEM_NUMBER="select count(id) from ty_activity_item where activityId=?";
	
	public static final String REGISTER_LIST="select u from UserInfo u,ActivityItem a where a.openId=u.openid and a.activityId=?";
	
	@Autowired
	protected JdbcTemplate jt;

	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}
	
	@Override
	public boolean isRegister(String openid, long activityId) {
		int num=jt.queryForInt(IS_REGISTER,openid,activityId);
		if(num==0){
			return false;
		}
		return true;
	}

	@Override
	public int registerNum(long activityId) {
		return jt.queryForInt(ACTIVITYITEM_NUMBER,activityId);
	}

	@Override
	public List<UserInfo> getRegisterList(long activityId) {
		List<UserInfo> users=hibernateTemplate.find(REGISTER_LIST, activityId);
		return users;
	}

}
