package cn.edu.zju.dao;

import java.util.List;

import cn.edu.zju.entity.Item;

public interface ItemDao extends Dao<Item>{

	public Item getItem(String isdn,String reader);
	
	public List<Item> getItemsByBook(String isdn);
	
	public List<Item> getItemsByReader(String readerId);
}
