package cn.edu.zju.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.edu.zju.dao.BookDao;
import cn.edu.zju.entity.Book;

@Controller
@RequestMapping(value="book")
public class BookManageController {
	
	@Autowired
	private BookDao bookDao;
	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}
	@RequestMapping(value="main")
	public String mainPage(){
		return "main/mainpage";
	}
	@RequestMapping(value="books",method=RequestMethod.GET)
	public String listBook(Model model){
		List<Book> books=bookDao.findAll();
		model.addAttribute("list", books);
		return "book/books";
	}
	
	@RequestMapping(value="add",method=RequestMethod.GET)
	public String addBook(){
		return "book/bookAdd";
	}
	
	@RequestMapping(value="addbook",method=RequestMethod.POST)
	public String addBook(Book book){
		book.setRemain(book.getTotal());
		bookDao.save(book);
		return "redirect:/book/books";
	}
	
	@RequestMapping(value="delete",method=RequestMethod.GET)
	public String deleteBook(String isdn){
		Book b=bookDao.get(isdn);
		bookDao.remove(b);
		return "redirect:/book/books";
	}
	
	@RequestMapping(value="updateBook",method=RequestMethod.GET)
	public String update(String isdn,Model model){
		Book b=bookDao.get(isdn);
		model.addAttribute("book", b);
		return "book/bookUpdate";
	}
	
	@RequestMapping(value="update",method=RequestMethod.POST)
	public String update(Book book){
		Book old=bookDao.get(book.getIsdn());
		int outer=old.getTotal()-old.getRemain();
		book.setRemain(book.getTotal()-outer);
		bookDao.update(book);
		return "redirect:/book/books";
	}
	
	
}
