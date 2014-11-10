package cn.edu.zju.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "M_ITEM")
public class Item {
	
	@Id  
	@GeneratedValue(strategy = GenerationType.IDENTITY)  
	private long id;
	
	@Column
	private Date borrowDate;//借书日
	
	@Column
	private Date returnDate;
	
	@Column
	private char isHistory='n';//y为历史记录,n非历史记录
	
	@Column
	private String isdn;//所借书的isdn
	
	@Column
	private String readerId;//读者Id

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getBorrowDate() {
		return borrowDate;
	}

	public void setBorrowDate(Date borrowDate) {
		this.borrowDate = borrowDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public char getIsHistory() {
		return isHistory;
	}

	public void setIsHistory(char isHistory) {
		this.isHistory = isHistory;
	}

	public String getIsdn() {
		return isdn;
	}

	public void setIsdn(String isdn) {
		this.isdn = isdn;
	}

	public String getReaderId() {
		return readerId;
	}

	public void setReaderId(String readerId) {
		this.readerId = readerId;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", borrowDate=" + borrowDate
				+ ", returnDate=" + returnDate + ", isHistory=" + isHistory
				+ ", isdn=" + isdn + ", readerId=" + readerId + "]";
	}
	
}
