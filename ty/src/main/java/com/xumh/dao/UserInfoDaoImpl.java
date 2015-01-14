package com.xumh.dao;

import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.xumh.bean.UserInfo;

@Repository("userInfoDao")
public class UserInfoDaoImpl extends HbBaseDao<UserInfo> implements UserInfoDao {

	private static Logger logger = LoggerFactory
			.getLogger(UserInfoDaoImpl.class);

	private static final String UPDATE_WEIXIN_INFO = "update ty_userinfo set nickname=?,sex=?,province=?,city=?,country=?,headimgurl=?,unionid=? where openid=?";
	private static final String CONTAIN_USER="select count(openid) from ty_userinfo where openid=?";

	@Autowired
	protected JdbcTemplate jt;

	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}

//	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void updateWeixinInfo(UserInfo userInfo) {
		try {
			jt.update(UPDATE_WEIXIN_INFO, userInfo.getNickname(),
					userInfo.getSex(), userInfo.getProvince(),
					userInfo.getCity(), userInfo.getCountry(),
					userInfo.getHeadimgurl(), userInfo.getUnionid(),
					userInfo.getOpenid());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}

	@Override
	public boolean containUser(String openId) {
		int num=jt.queryForInt(CONTAIN_USER,openId);
		if(num==1) return true;
		return false;
	}

}
