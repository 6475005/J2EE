package db;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import object.Comment;
import object.News;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class CommentDbManager extends HibernateDaoSupport{
	public void add(Comment comment){
		getHibernateTemplate().save(comment);
	}
	@SuppressWarnings("unchecked")
	public List<Comment> queryAll(){
		List<Comment> list = getHibernateTemplate().loadAll(Comment.class);
		Collections.reverse(list);
		return list;
	}
	
	public List<Comment> getCommentByPaging(int currentPage,String type) {
		List<Comment> temp = querySize(type);
		int startRow = (currentPage - 1) *5;
		List<Comment> list = new ArrayList<Comment>();
		for(int i=0;i<5;i++){
			if((i+startRow)>=temp.size()){
				return list;
			}
			list.add(temp.get(i+startRow));
		}
		return list;
	}
	@SuppressWarnings("unchecked")
	public List<Comment> querySize(String type) {
		Comment news = new Comment();
		news.setType(type);
		List<Comment> list = getHibernateTemplate().findByExample(news);
		Collections.reverse(list);
		return list;
	}
}
