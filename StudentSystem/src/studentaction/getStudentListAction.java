package studentaction;

import java.util.ArrayList;
import java.util.List;

import object.Student;

import com.opensymphony.xwork2.ActionSupport;

import db.StudentDbManager;

public class getStudentListAction extends ActionSupport {
	private static final int PAGESIZE = 7;
	private int currentPage;
	private int countPage;
	private String []pages;
	private List<Student> list = new ArrayList<Student>();
	private StudentDbManager studentDao;
	

	public String[] getPages() {
		return pages;
	}

	public void setPages(String[] pages) {
		this.pages = pages;
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
		countPage = (studentDao.query().size()/PAGESIZE)+1;
		String []temp = new String[countPage];
		for(int i=0;i<countPage;i++){
			temp[i]=(i+1)+"";
		}
		pages = temp;
		if(currentPage<=0){currentPage=1;}
		if(currentPage>=countPage){currentPage=countPage;}
		list = studentDao.getStudentByPaging(currentPage, PAGESIZE);
		return SUCCESS;
	}
	
}
