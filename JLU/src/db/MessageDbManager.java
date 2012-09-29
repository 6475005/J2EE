package db;

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
		Session session = getHibernateTemplate().getSessionFactory().openSession();
		Query query = session.createQuery("from Message");
		int startRow = (currentPage - 1) *10;
		query.setFirstResult(startRow);
		query.setMaxResults(10);
		List<Message> list = query.list();
		Collections.reverse(list);
		session.close();
		return list;
	}
}
