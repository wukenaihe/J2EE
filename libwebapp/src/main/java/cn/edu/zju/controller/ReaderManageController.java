package cn.edu.zju.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.edu.zju.dao.ItemDao;
import cn.edu.zju.dao.UserDao;
import cn.edu.zju.entity.User;

@Controller
@RequestMapping(value="reader")
public class ReaderManageController {
	@Autowired
	private UserDao userDao;
	@Autowired
	private ItemDao itemDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public void setItemDao(ItemDao itemDao) {
		this.itemDao = itemDao;
	}



	@RequestMapping(value="readers")
	public String getReaders(Model model){
		List<User> users=userDao.find("from User");
		for (User user : users) {
			int num=itemDao.borrowNum(user.getId());
			user.setBorrowBooks(num);
		}
		model.addAttribute("users", users);
		return "reader/readers";
	}
	
	@RequestMapping(value="add",method=RequestMethod.GET)
	public String addReader(){
		return "reader/readerAdd";
	}
	
	@RequestMapping(value="addReader",method=RequestMethod.POST)
	public String addReader(User user){
		userDao.save(user);
		return "redirect:/reader/readers";
	}
	
	@RequestMapping(value="delete",method=RequestMethod.GET)
	public String deleteReader(String id){
		User user=userDao.get(id);
		if(user!=null){
			userDao.remove(user);
		}
		return "redirect:/reader/readers";
	}
}
