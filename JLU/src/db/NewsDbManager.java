package db;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
	public List<News> querySheLian() {
		News news = new News();
		news.setType("社联新闻");
		List<News> list = getHibernateTemplate().findByExample(news);
		Collections.reverse(list);
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<News> querySheTuan() {
		News news = new News();
		news.setType("社团新闻");
		List<News> list = getHibernateTemplate().findByExample(news);
		Collections.reverse(list);
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<News> queryImportant() {
		News news = new News();
		news.setType("要闻提示");
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
		Session session = getHibernateTemplate().getSessionFactory().openSession();
		Query query = session.createQuery("from News");
		int startRow = (currentPage - 1) *10;
		query.setFirstResult(startRow);
		query.setMaxResults(10);
		List<News> list = query.list();
		Collections.reverse(list);
		session.close();
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public List<News> getNewsByPaging(int currentPage,String type) {
		Session session = getHibernateTemplate().getSessionFactory().openSession();
		Query query = session.createQuery("from News where type = '"+type+"'");
		int startRow = (currentPage - 1) *10;
		query.setFirstResult(startRow);
		query.setMaxResults(10);
		List<News> list = query.list();
		Collections.reverse(list);
		session.close();
		return list;
	}

}
