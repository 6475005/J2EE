package db;

import java.util.ArrayList;
import java.util.List;

import object.Student;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class StudentDbManager extends HibernateDaoSupport {

	@SuppressWarnings("unchecked")
	public boolean query(int number) {
		Student student = new Student();
		student.setNumber(number);
		List<Student> sList = getHibernateTemplate().findByExample(student);
		if (sList != null && sList.size() > 0) {
			return true;
		} else {
			return false;
		}
	}

	public Student queryByNumber(int number) {
		Student student = new Student();
		student.setNumber(number);
		@SuppressWarnings("unchecked")
		List<Student> list = getHibernateTemplate().findByExample(student);
		return list.get(0);
	}

	@SuppressWarnings("unchecked")
	public List<Student> query() {
		List<Student> list = getHibernateTemplate().loadAll(Student.class);
		return list;
	}

	public void add(Student student) {
		getHibernateTemplate().save(student);
	}

	public void updata(Student student) {
		getHibernateTemplate().update(student);
	}

	@SuppressWarnings("unchecked")
	public void delete(int number) {
		Student student = new Student();
		student.setNumber(number);
		List<Student> sList = getHibernateTemplate().findByExample(student);
		getHibernateTemplate().delete(sList.get(0));
	}

	@SuppressWarnings("unchecked")
	public List<Student> getStudentByPaging(int currentPage, int pageSize) {
		Session session = getHibernateTemplate().getSessionFactory().openSession();
		Query query = session.createQuery("from Student");
		int startRow = (currentPage - 1) * pageSize;
		query.setFirstResult(startRow);
		query.setMaxResults(pageSize);
		List<Student> message = query.list();
		session.close();
		return message;

	}
	@SuppressWarnings("unchecked")
	public List<Student> queryByGrade(String grade,int currentPage, int pageSize) {
		Student student = new Student();
		student.setGrade(grade);
		List<Student> listset = getHibernateTemplate().findByExample(student);
		List<Student> list = new ArrayList<Student>();
		for(int i=(currentPage - 1) * pageSize;i<currentPage*pageSize;i++){
			if(listset.size()>i){
				list.add(listset.get(i));
			}
		}
		return list;
	}
	@SuppressWarnings("unchecked")
	public List<Student> queryByGrade(String grade) {
		Student student = new Student();
		student.setGrade(grade);
		List<Student> list = getHibernateTemplate().findByExample(student);
		return list;
	}
	
	public List<Student> queryByMajor(String major,int currentPage, int pageSize) {
		Student student = new Student();
		student.setMajor(major);
		@SuppressWarnings("unchecked")
		List<Student> listset = getHibernateTemplate().findByExample(student);
		List<Student> list = new ArrayList<Student>();
		for(int i=(currentPage - 1) * pageSize;i<currentPage*pageSize;i++){
			if(listset.size()>i){
				list.add(listset.get(i));
			}
		}
		return list;
	}
	@SuppressWarnings("unchecked")
	public List<Student> queryByMajor(String major) {
		Student student = new Student();
		student.setMajor(major);
		List<Student> list = getHibernateTemplate().findByExample(student);
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public List<Student> queryByName(String name,int currentPage, int pageSize) {
		Student student = new Student();
		student.setName(name);
		List<Student> listset = getHibernateTemplate().findByExample(student);
		List<Student> list = new ArrayList<Student>();
		for(int i=(currentPage - 1) * pageSize;i<currentPage*pageSize;i++){
			if(listset.size()>i){
				list.add(listset.get(i));
			}
		}
		return list;
	}
	@SuppressWarnings("unchecked")
	public List<Student> query(String name) {
		Student student = new Student();
		student.setName(name);
		List<Student> sList = getHibernateTemplate().findByExample(student);
		if (sList != null && sList.size() > 0) {
			return sList;
		} else {
			return null;
		}
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Student> queryByNumber(String number) {
		Student student = new Student();
		student.setNumber(Integer.valueOf(number));
		List<Student> list = getHibernateTemplate().findByExample(student);
		return list;
	}
}
