package db;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import object.Message;
import object.News;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class NewsDbManager extends HibernateDaoSupport {
	public void save(News news) {
		getHibernateTemplate().save(news);
	}

	@SuppressWarnings("unchecked")
	public List<News> queryAll() {
		List<News> list = getHibernateTemplate().loadAll(News.class);
		Collections.reverse(list);
		return list;
	}

	public void updata(News news) {
		News temp = getNewsByTitleAndType(news.getTitle());
		news.setId(temp.getId());
		getHibernateTemplate().update(news);
	}

	public News getNewsByTitleAndType(String title) {
		News news = new News();
		news.setTitle(title);
		News temp = (News) getHibernateTemplate().findByExample(news).get(0);
		return temp;
	}

	public void delete(int id) {
		News news = (News) getHibernateTemplate().load(News.class, id);
		getHibernateTemplate().delete(news);
	}

	public News get(int id, String title) {
		News news = new News();
		news.setId(id);
		news.setTitle(title);
		news = (News) getHibernateTemplate().findByExample(news).get(0);
		return news;
	}

	@SuppressWarnings("unchecked")
	public List<News> query(String type) {
		News news = new News();
		news.setType(type);
		List<News> list = getHibernateTemplate().findByExample(news);
		Collections.reverse(list);
		return list;
	}

	public List<News> getTenNews() {
		List<News> list = queryAll();
		List<News> temp = new ArrayList<News>();
		if (list.size() > 10) {
			for (int i = 0; i < 10; i++) {
				temp.add(list.get(i));
			}
			return temp;
		} else {
			return list;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<News> getNewsByPaging(int currentPage) {
		List<News> temp = queryAll();
		int startRow = (currentPage - 1) *10;
		List<News> list = new ArrayList<News>();
		for(int i=0;i<10;i++){
			if((i+startRow)>=temp.size()){
				return list;
			}
			list.add(temp.get(i+startRow));
		}
		return list;
	}
	
	public List<News> getNewsByPaging(int currentPage,String type) {
		List<News> temp = query(type);
		List<News> list = new ArrayList<News>();
		int startRow = (currentPage - 1) *10;
		for(int i=0;i<10;i++){
			if((i+startRow)>=temp.size()){
				return list;
			}
			list.add(temp.get(i+startRow));
		}
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public List<News> queryNews(String title){
		Session session = getHibernateTemplate().getSessionFactory().openSession();
		Query query = session.createQuery("from object.News  s where s.title like:title");
		query.setString("title", "%"+title+"%");
		List<News> list = query.list();
		Collections.reverse(list);
		session.close();
		return list;
	}
}
