package cn.edu.zju.filter;

import cn.edu.zju.entity.User;

public class UserTool {
	public static final ThreadLocal<User> localUser=new ThreadLocal<User>();
	
	public static User get(){
		User user=localUser.get();
		return user;
	}
	
	public static void set(User user){
		localUser.set(user);
	}
	
}	
