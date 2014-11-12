package cn.edu.zju.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.zju.dao.BookDao;
import cn.edu.zju.dao.ItemDao;
import cn.edu.zju.dao.UserDao;
import cn.edu.zju.entity.Book;
import cn.edu.zju.entity.Item;
import cn.edu.zju.entity.ItemDetail;
import cn.edu.zju.entity.User;

@Controller
@RequestMapping(value="reader")
public class ReaderManageController {
	@Autowired
	private UserDao userDao;
	@Autowired
	private ItemDao itemDao;
	@Autowired
	private BookDao bookDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public void setItemDao(ItemDao itemDao) {
		this.itemDao = itemDao;
	}
	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
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
	
	@RequestMapping(value="update",method=RequestMethod.GET)
	public String updateReader(String id,Model model){
		User user=userDao.get(id);
		model.addAttribute("user", user);
		return "reader/readerUpdate";
	}
	
	@RequestMapping(value="updateReader",method=RequestMethod.POST)
	public String updateReader(User user){
		userDao.update(user);
		return "redirect:/reader/readers";
	}
	
	@RequestMapping(value="search",method=RequestMethod.GET)
	public @ResponseBody Map<String, Object> queryReaderBook(String id){
		List<Item> list=itemDao.getItemsByReader(id);
		List<ItemDetail> itemDetails=new ArrayList<ItemDetail>();
		for (Item item : list) {
			ItemDetail itemDetail=new ItemDetail();
			Book b=bookDao.get(item.getIsdn());
			itemDetail.setAuthor(b.getAuthor());
			itemDetail.setBookName(b.getBookname());
			itemDetail.setIsbn(b.getIsdn());
			itemDetail.setBorrowDate(item.getBorrowDate());
			itemDetails.add(itemDetail);
		}
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("total", itemDetails.size());
		map.put("rows", itemDetails);
		return map;
	}
}
