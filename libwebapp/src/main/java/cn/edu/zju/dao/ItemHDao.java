package cn.edu.zju.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.zju.entity.Item;

@Repository("itemDao")
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public class ItemHDao extends HbBaseDao<Item> implements ItemDao {

	public Item getItem(String isdn, String reader) {
		List<Item> lists=find("from Item where isHistory = 'n' and isdn = "+isdn+" and readerId="+reader);
		if(lists==null||lists.size()==0){
			return null;
		}
		return lists.get(0);
	}

	@Override
	public List<Item> getItemsByBook(String isdn) {
		return find("from Item where isHistory = 'n' and isdn = "+isdn);
	}

	@Override
	public List<Item> getItemsByReader(String readerId) {
		return find("from Item where isHistory = 'n' and readerId="+readerId);
	}
}
