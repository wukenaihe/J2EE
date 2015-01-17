package com.xumh.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xumh.bean.Activity;
import com.xumh.bean.UserInfo;
import com.xumh.dao.ActivityDao;
import com.xumh.dao.ActivityItemDao;
import com.xumh.dao.UserInfoDao;
import com.xumh.dto.ActivityRegisterRecord;

@Service("userRegisterActivity")
public class UserRegisterActivityImpl implements UserRegisterActivity{

	@Autowired
	private UserInfoDao userInfoDao;
	@Autowired
	private ActivityDao activityDao;
	@Autowired
	private ActivityItemDao activityItemDao;
	
	public void setUserInfoDao(UserInfoDao userInfoDao) {
		this.userInfoDao = userInfoDao;
	}
	public void setActivityDao(ActivityDao activityDao) {
		this.activityDao = activityDao;
	}
	public void setActivityItemDao(ActivityItemDao activityItemDao) {
		this.activityItemDao = activityItemDao;
	}
	@Override
	public boolean isRegister(String openid) {
		UserInfo userInfo=userInfoDao.get(openid);
		if(userInfo==null||userInfo.getName()==null||userInfo.getZhifuNikcname()==null||userInfo.getCardId()==null){
			return false;
		}
		return true;
	}
	
	/**
	 * 获取可报名活动信息
	 * 
	 * @param openid
	 * @return
	 */
	public List<ActivityRegisterRecord> getActivityRegisterRecords(String openid){
		//获取为过期的活动
		List<Activity> activities=activityDao.getUnexceedActivities();
		
		List<ActivityRegisterRecord> activityRegisterRecords=new ArrayList<ActivityRegisterRecord>();
		for (Activity activity : activities) {
			ActivityRegisterRecord activityRegisterRecord=new ActivityRegisterRecord();
			activityRegisterRecords.add(activityRegisterRecord);
			activityRegisterRecord.setActivityName(activity.getName());
			activityRegisterRecord.setActivityId(activity.getId());
			activityRegisterRecord.setRegister(activityItemDao.isRegister(openid, activity.getId()));
			
			int registerNum=activityItemDao.registerNum(activity.getId());
			activityRegisterRecord.setRegisterNum(registerNum);
			activityRegisterRecord.setFull(registerNum>=activity.getMaxPepole());
			
		}
		return activityRegisterRecords;
	}
	@Override
	public boolean isFull(long activityId) {
		Activity activity=activityDao.get(activityId);
		int registerNum=activityItemDao.registerNum(activityId);
		if(registerNum>=activity.getMaxPepole()){
			return true;
		}
		return false;
	}

}
