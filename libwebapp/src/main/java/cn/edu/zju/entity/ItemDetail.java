package cn.edu.zju.entity;

import java.util.Date;

public class ItemDetail {
	private String isbn;
	private String bookName;
	private String author;
	private Date borrowDate;
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Date getBorrowDate() {
		return borrowDate;
	}
	public void setBorrowDate(Date borrowDate) {
		this.borrowDate = borrowDate;
	}
	@Override
	public String toString() {
		return "ItemDetail [isbn=" + isbn + ", bookName=" + bookName
				+ ", author=" + author + ", borrowDate=" + borrowDate + "]";
	}
	
	
}
