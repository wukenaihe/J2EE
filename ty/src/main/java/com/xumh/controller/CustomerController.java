package com.xumh.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xumh.bean.UserInfo;
import com.xumh.dao.UserInfoDao;
import com.xumh.service.UserWeixinInterface;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	private static Logger logger=LoggerFactory.getLogger(CustomerController.class);

	@Autowired
	private UserWeixinInterface userWeixinInterface;
	@Autowired
	private UserInfoDao userInfoDao;

	public void setUserWeixinInterface(UserWeixinInterface userWeixinInterface) {
		this.userWeixinInterface = userWeixinInterface;
	}

	public void setUserInfoDao(UserInfoDao userInfoDao) {
		this.userInfoDao = userInfoDao;
	}


	@RequestMapping(value="register",method=RequestMethod.GET)
	public String registerCustomer(String code,Model model){
		UserInfo userInfo=userWeixinInterface.getUserInfo(code);
//		UserInfo userInfo=new UserInfo();
//		userInfo.setOpenid("oUKteuDrXHEdt_8qasEWkn9FNqbw");
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
}
