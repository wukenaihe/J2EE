package com.xumh.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

/**
 * 
 * 活动
 * @author xumh
 *
 */
@Entity
@Table(name="ty_activity")
public class Activity implements Serializable{

	@Id  
	@GeneratedValue(strategy = GenerationType.IDENTITY)  
	private long id;
	@Column
	private String name;//活动名称
	@Column
	private int maxPepole;//活动最大人数
	@Column
	private Date lastDate;//活动最后期限
	@Column
	private Date endDate;//活动结束日期
	@Column
	@Lob
	private String remark;//备注

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMaxPepole() {
		return maxPepole;
	}

	public void setMaxPepole(int maxPepole) {
		this.maxPepole = maxPepole;
	}

	public Date getLastDate() {
		return lastDate;
	}

	public void setLastDate(Date lastDate) {
		this.lastDate = lastDate;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		return "Activity [id=" + id + ", name=" + name + ", maxPepole="
				+ maxPepole + ", lastDate=" + lastDate + ", endDate=" + endDate
				+ ", remark=" + remark + "]";
	}
}
