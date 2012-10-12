package db;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import object.Message;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class MessageDbManager extends HibernateDaoSupport {
	public void add(Message message) {
		getHibernateTemplate().save(message);
	}

	public List<Message> queryAll() {
		@SuppressWarnings("unchecked")
		List<Message> list = getHibernateTemplate().loadAll(Message.class);
		Collections.reverse(list);
			return list;
	}
	public void delete(int id){
		Message message = (Message)getHibernateTemplate().load(Message.class, id);
		getHibernateTemplate().delete(message);
	}
	public Message get(int id){
		Message message = (Message)getHibernateTemplate().get(Message.class, id);
		return message;
	}
	@SuppressWarnings("unchecked")
	public List<Message> getNewsByPaging(int currentPage) {
		List<Message> temp = queryAll();
		int startRow = (currentPage - 1) *10;
		List<Message> list = new ArrayList<Message>();
		for(int i=0;i<10;i++){
			if((i+startRow)>=temp.size()){
				return list;
			}
			list.add(temp.get(i+startRow));
		}
		return list;
	}
}
