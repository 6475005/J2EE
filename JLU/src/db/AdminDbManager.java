package db;

import java.util.List;

import object.Admin;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class AdminDbManager extends HibernateDaoSupport {
	@SuppressWarnings("unchecked")
	public Admin queryByUsername(String username) {
		Admin admin = new Admin();
		admin.setUsername(username);
		List<Admin> list = getHibernateTemplate().findByExample(admin);
		if (list.size() == 0 || list == null) {
			return null;
		} else {
			return list.get(0);
		}
	}
	public void updata(Admin admin){
		getHibernateTemplate().update(admin);
	}
}
