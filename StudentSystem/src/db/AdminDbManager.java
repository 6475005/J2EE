package db;

import java.util.List;

import object.Admin;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class AdminDbManager extends HibernateDaoSupport {
	
	@SuppressWarnings("unchecked")
	public Admin queryByName(String username) {
		Admin admin = new Admin();
		admin.setUsername(username);
		List<Admin> aList = getHibernateTemplate().findByExample(admin);
		if (aList != null && aList.size() > 0) {
			return aList.get(0);
		} else {
			return null;
		}
	}
	public boolean add(Admin admin){
		if(queryByName(admin.getUsername())==null){
			getHibernateTemplate().save(admin);
			return true;
		}else{
			return false;
		}
	}
	public void add(String username,String password){
		Admin admin = new Admin();
		admin.setUsername(username);
		admin.setPassword(password);
		add(admin);
	}
	public void delete(int id){
		Admin admin = (Admin)getHibernateTemplate().load(Admin.class, id);
		getHibernateTemplate().delete(admin);
	}
	public void delete(Admin admin){
		getHibernateTemplate().delete(admin);
	}
	public void updata(Admin admin){
		getHibernateTemplate().update(admin);
	}
}
