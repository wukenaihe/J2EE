package com.xumh.dto;

import java.io.Serializable;

public class ActivityRegisterRecord implements Serializable{
	private String activityName;//活动名称
	private boolean isFull;//已满
	private boolean isRegister;//已报名
	private int registerNum;//已报名人数
	
	private long activityId;

	public String getActivityName() {
		return activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

	public boolean getIsFull() {
		return isFull;
	}

	public void setFull(boolean isFull) {
		this.isFull = isFull;
	}

	public boolean getIsRegister() {
		return isRegister;
	}

	public void setRegister(boolean isRegister) {
		this.isRegister = isRegister;
	}

	public long getActivityId() {
		return activityId;
	}

	public void setActivityId(long activityId) {
		this.activityId = activityId;
	}

	public int getRegisterNum() {
		return registerNum;
	}

	public void setRegisterNum(int registerNum) {
		this.registerNum = registerNum;
	}

	@Override
	public String toString() {
		return "ActivityRegisterRecord [activityName=" + activityName
				+ ", isFull=" + isFull + ", isRegister=" + isRegister
				+ ", registerNum=" + registerNum + ", activityId=" + activityId
				+ "]";
	}

	

}
