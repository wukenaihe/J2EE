package cn.edu.zju.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "M_BOOK")
public class Book {

	@Column
	@Id
	private String isdn;
	
	@Column
	private String bookname;// ����
	@Column
	private String author;// ����
	@Column
	private String publish;// ������
	@Column
	private double price;// �۸�
	@Column
	private int print;// ���
	@Column
	private int count;// ӡ��
	@Column
	private String time; // ����ʱ��
	@Column
	private int total;//�ܹ��鱾����
	@Column
	private int remain;//ʣ��
	public String getIsdn() {
		return isdn;
	}
	public void setIsdn(String isdn) {
		this.isdn = isdn;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublish() {
		return publish;
	}
	public void setPublish(String publish) {
		this.publish = publish;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getPrint() {
		return print;
	}
	public void setPrint(int print) {
		this.print = print;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getRemain() {
		return remain;
	}
	public void setRemain(int remain) {
		this.remain = remain;
	}
	@Override
	public String toString() {
		return "Book [isdn=" + isdn + ", bookname=" + bookname + ", author="
				+ author + ", publish=" + publish + ", price=" + price
				+ ", print=" + print + ", count=" + count + ", time=" + time
				+ ", total=" + total + ", remain=" + remain + "]";
	}

	
}
