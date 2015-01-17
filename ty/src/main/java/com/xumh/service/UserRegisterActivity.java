package com.xumh.service;

import java.util.List;

import com.xumh.dto.ActivityRegisterRecord;

public interface UserRegisterActivity {
	
	/**
	 * 数据库中的记录包含openid,name,cardId,phone,zhifunickname就是存在，缺一不可
	 * 
	 * @param openid
	 * @return
	 */
	boolean isRegister(String openid);
	
	List<ActivityRegisterRecord> getActivityRegisterRecords(String openid);
	
	boolean isFull(long activityId);
}
