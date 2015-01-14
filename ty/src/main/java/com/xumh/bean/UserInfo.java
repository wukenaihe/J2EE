package com.xumh.bean;

import java.io.Serializable;
import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ty_userinfo")
public class UserInfo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5426333161405708883L;
	
	//微信信息部分
	@Column
	@Id
	private String openid;//对同一用户唯一不变
	@Column
	private String nickname;//微信昵称
	@Column
	private int sex;
	@Column
	private String province;//
	@Column
	private String city;
	@Column
	private String country;
	@Column
	private String headimgurl;
	
	private String[] privilege;
	@Column
	private String unionid;
	
	//
	@Column
	private String zhifuNikcname;//支付宝昵称
	@Column
	private String phone;//手机号
	@Column
	private String name;//真实姓名
	@Column
	private String cardId;//身份证号码
	
	@Column
	private String single;//是否单身
	@Column
	private String sexOrientation;//性取向
	@Column
	private String school;//学校
	@Column
	private String job;//职业
	@Column
	private int age;
	
	
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getHeadimgurl() {
		return headimgurl;
	}
	public void setHeadimgurl(String headimgurl) {
		this.headimgurl = headimgurl;
	}
	public String[] getPrivilege() {
		return privilege;
	}
	public void setPrivilege(String[] privilege) {
		this.privilege = privilege;
	}
	public String getUnionid() {
		return unionid;
	}
	public void setUnionid(String unionid) {
		this.unionid = unionid;
	}
	public String getZhifuNikcname() {
		return zhifuNikcname;
	}
	public void setZhifuNikcname(String zhifuNikcname) {
		this.zhifuNikcname = zhifuNikcname;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCardId() {
		return cardId;
	}
	public void setCardId(String cardId) {
		this.cardId = cardId;
	}
	public String getSingle() {
		return single;
	}
	public void setSingle(String single) {
		this.single = single;
	}

	public String getSexOrientation() {
		return sexOrientation;
	}
	public void setSexOrientation(String sexOrientation) {
		this.sexOrientation = sexOrientation;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "UserInfo [openid=" + openid + ", nickname=" + nickname
				+ ", sex=" + sex + ", province=" + province + ", city=" + city
				+ ", country=" + country + ", headimgurl=" + headimgurl
				+ ", privilege=" + Arrays.toString(privilege) + ", unionid="
				+ unionid + ", zhifuNikcname=" + zhifuNikcname + ", phone="
				+ phone + ", name=" + name + ", cardId=" + cardId + ", single="
				+ single + ", sexOrientation=" + sexOrientation + ", school="
				+ school + ", job=" + job + ", age=" + age + "]";
	}

}
