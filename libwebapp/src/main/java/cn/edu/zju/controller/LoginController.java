package cn.edu.zju.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cn.edu.zju.common.CommonConstant;
import cn.edu.zju.dao.UserDao;
import cn.edu.zju.entity.User;

@Controller
public class LoginController{
	
	
	@Autowired
	public UserDao userDao;

	
    /**
     * user login
     * @param request
     * @param user
     * @return
     */
	@RequestMapping(value="/doLogin",method=RequestMethod.POST)
	public ModelAndView login(HttpServletRequest request, User user) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("forward:/login.jsp");
		if(user==null||user.getName()==null){
			mav.addObject("errorMsg", "No such user");
			return mav;
		}
		User dbUser = userDao.get(user.getName());
		if(dbUser==null){
			mav.addObject("errorMsg", "No such user");
			return mav;
		}else if (!dbUser.getPassword().equals(user.getPassword())) {
			mav.addObject("errorMsg", "Error password");
			return mav;
		}  else {
			setSessionUser(request,dbUser);
			String toUrl = (String)request.getSession().getAttribute(CommonConstant.LOGIN_TO_URL);
			request.getSession().removeAttribute(CommonConstant.LOGIN_TO_URL);
			if(StringUtils.isEmpty(toUrl)){
				toUrl = "/book/books";
			}
			mav.setViewName("redirect:"+toUrl);
		}
		return mav;
	}
	
	@RequestMapping("/doLogout")
	public String logout(HttpSession session) {
		session.removeAttribute(CommonConstant.USER_ATTR);
		return "forward:/login.jsp";
	}
	
	/**
	 * save user to session
	 * @param request
	 * @param user
	 */
	private void setSessionUser(HttpServletRequest request,User user) {
		request.getSession().setAttribute(CommonConstant.USER_ATTR,
				user);
	}

}
