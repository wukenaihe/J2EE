package com.xumh.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

/**
 * 活动报名情况
 * 
 * @author xumh
 *
 */
@Entity
@Table(name="ty_activity_item")
public class ActivityItem {

	@Id  
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private long id;
	@Column
	private long activityId;
	@Column
	private String openId;
	@Column
	private Date registeDate;//报名时间
	@Column
	@Lob
	private String remark;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getActivityId() {
		return activityId;
	}
	public void setActivityId(long activityId) {
		this.activityId = activityId;
	}
	public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	public Date getRegisteDate() {
		return registeDate;
	}
	public void setRegisteDate(Date registeDate) {
		this.registeDate = registeDate;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "ActivityItem [id=" + id + ", activityId=" + activityId
				+ ", openId=" + openId + ", registeDate=" + registeDate
				+ ", remark=" + remark + "]";
	}
}
