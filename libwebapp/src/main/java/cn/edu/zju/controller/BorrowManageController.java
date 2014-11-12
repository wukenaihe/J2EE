package cn.edu.zju.controller;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.zju.dao.BookDao;
import cn.edu.zju.dao.ItemDao;
import cn.edu.zju.entity.Book;
import cn.edu.zju.entity.Item;

@Controller
@RequestMapping(value="borrow")
public class BorrowManageController {
	
	@Autowired
	private BookDao bookDao;
	@Autowired
	private ItemDao itemDao;
	
	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}

	public void setItemDao(ItemDao itemDao) {
		this.itemDao = itemDao;
	}

	@RequestMapping(value="borrowMain",method=RequestMethod.GET)
	public String borrowBook(){
		return "borrow/borrowMain";
	}
	
	@RequestMapping(value="borrow",method=RequestMethod.POST)
	public String borrowBook(String isbn,String readerId){
		//是否还能借书
		Book b=bookDao.get(isbn);
		if(b!=null&&b.getRemain()>0){
			b.setRemain(b.getRemain()-1);
			Item item=new Item();
			item.setBorrowDate(new Date());
			item.setIsdn(isbn);
			item.setReaderId(readerId);
			bookDao.update(b);
			itemDao.save(item);
		}
		return "redirect:/book/books";
	}
	
	@RequestMapping(value="returnMain",method=RequestMethod.GET)
	public String returnBook(){
		return "borrow/returnMain";
	}
	
	@RequestMapping(value="return",method=RequestMethod.POST)
	public String returnBook(String isbn,String readerId){
		Item item=itemDao.getItem(isbn, readerId);
		if(item!=null){
			Book book=bookDao.get(isbn);
			book.setRemain(book.getRemain()+1);
			item.setIsHistory('y');
			item.setReturnDate(new Date());
			bookDao.update(book);
			itemDao.update(item);
		}
		return "redirect:/book/books";
	}
}
