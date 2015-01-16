package com.xumh.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xumh.bean.UserInfo;
import com.xumh.dao.UserInfoDao;
import com.xumh.dto.ActivityRegisterRecord;
import com.xumh.service.UserRegisterActivity;
import com.xumh.service.UserWeixinInterface;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	private static Logger logger=LoggerFactory.getLogger(CustomerController.class);

	@Autowired
	private UserWeixinInterface userWeixinInterface;
	@Autowired
	private UserInfoDao userInfoDao;
	@Autowired
	private UserRegisterActivity userRegisterActivity;

	public void setUserWeixinInterface(UserWeixinInterface userWeixinInterface) {
		this.userWeixinInterface = userWeixinInterface;
	}

	public void setUserInfoDao(UserInfoDao userInfoDao) {
		this.userInfoDao = userInfoDao;
	}

	public void setUserRegisterActivity(UserRegisterActivity userRegisterActivity) {
		this.userRegisterActivity = userRegisterActivity;
	}

	@RequestMapping(value="register",method=RequestMethod.GET)
	public String registerCustomer(String code,Model model){
		UserInfo userInfo=userWeixinInterface.getUserInfo(code);
		if(userInfo==null){
			logger.error("code:"+code+"  can not get user information");
			return "";
		}
		if(userInfoDao.containUser(userInfo.getOpenid())){
			userInfoDao.updateWeixinInfo(userInfo);
			userInfo=userInfoDao.get(userInfo.getOpenid());
		}else{
			userInfoDao.save(userInfo);
		}
		
		model.addAttribute("userInfo", userInfo);
		return "register";
	}
	
	@RequestMapping(value="register-save",method=RequestMethod.POST)
	public String registerCustomerSave(UserInfo userInfo){
		try{
			userInfoDao.update(userInfo);
		}catch (Exception e) {
			logger.error(e.getMessage(), e);
			return "error-register";
		}
		return "success-register";
	}
	
	
	@RequestMapping(value="registerActivity",method=RequestMethod.GET)
	public String registerActivity(String openid,Model model){
	
		if(!userRegisterActivity.isRegister(openid)){
			return "unregister";
		}
		List<ActivityRegisterRecord> activityRegisterRecords=userRegisterActivity.getActivityRegisterRecords(openid);
		
		model.addAttribute("arr", activityRegisterRecords);
		return "registerActivity";
	}
	
	@RequestMapping(value="registerdActivities",method=RequestMethod.GET)
	public String getActivities(){
		return "activities";
	}
	
	@RequestMapping(value="registerActivityList",method=RequestMethod.GET)
	public String getActivityRegister(){
		return "activity-register-peoples";
	}
}
