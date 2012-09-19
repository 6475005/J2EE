package studentaction;

import java.util.ArrayList;
import java.util.List;

import object.Student;

import com.opensymphony.xwork2.ActionSupport;

import db.StudentDbManager;

@SuppressWarnings("serial")
public class getStudentListAction extends ActionSupport {
	private static final int PAGESIZE = 7;
	private int currentPage;
	private int countPage;
	private int countStudent;
	private List<Student> list = new ArrayList<Student>();
	private StudentDbManager studentDao;
	
	public int getCountStudent() {
		return countStudent;
	}

	public void setCountStudent(int countStudent) {
		this.countStudent = countStudent;
	}

	public int getCountPage() {
		return countPage;
	}

	public void setCountPage(int countPage) {
		this.countPage = countPage;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public StudentDbManager getStudentDao() {
		return studentDao;
	}

	public void setStudentDao(StudentDbManager studentDao) {
		this.studentDao = studentDao;
	}

	public List<Student> getList() {
		return list;
	}

	public void setList(List<Student> list) {
		this.list = list;
	}

	@Override
	public String execute() throws Exception {
		countStudent = studentDao.query().size();
		countPage = (countStudent/PAGESIZE)+1;
		if(currentPage<=0){currentPage=1;}
		if(currentPage>=countPage){currentPage=countPage;}
		list = studentDao.getStudentByPaging(currentPage, PAGESIZE);
		return SUCCESS;
	}
	
}
