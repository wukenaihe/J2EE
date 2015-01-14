package com.xumh.common;

import java.io.Serializable;

public class PublicServiceInfo implements Serializable{

	private static final long serialVersionUID = -5774217046794242429L;
	
	private String appID;
	private String appsecret;
	private String name;
	public String getAppID() {
		return appID;
	}
	public void setAppID(String appID) {
		this.appID = appID;
	}
	public String getAppsecret() {
		return appsecret;
	}
	public void setAppsecret(String appsecret) {
		this.appsecret = appsecret;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
