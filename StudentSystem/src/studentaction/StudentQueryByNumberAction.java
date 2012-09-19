package studentaction;

import java.util.ArrayList;
import java.util.List;

import object.Student;

import com.opensymphony.xwork2.ActionSupport;

import db.StudentDbManager;

@SuppressWarnings("serial")
public class StudentQueryByNumberAction extends ActionSupport {
	private static final int PAGESIZE = 7;
	private List<Student> list = new ArrayList<Student>();
	private StudentDbManager studentDao;
	private String number;
	private int currentPage;
	private int countPage;
	private int countStudent;
	private String[] pages;
	
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getCountPage() {
		return countPage;
	}

	public void setCountPage(int countPage) {
		this.countPage = countPage;
	}

	public int getCountStudent() {
		return countStudent;
	}

	public void setCountStudent(int countStudent) {
		this.countStudent = countStudent;
	}

	public String[] getPages() {
		return pages;
	}

	public void setPages(String[] pages) {
		this.pages = pages;
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
		if(number.equals("")){return INPUT;}
		if(!isInteger(number)){return ERROR;}
		if (!String.valueOf(number).equals("")) {
			if (currentPage <= 0) {
				currentPage = 1;
			}
			list = studentDao.queryByNumber(String.valueOf(number));
			countStudent = list.size();
			countPage = (countStudent / PAGESIZE) + 1;
			if (currentPage >= countPage) {
				currentPage = countPage;
			}
			if (list == null) {
				return ERROR;
			} else {
				return SUCCESS;
			}
		} else {
			return ERROR;
		}
	}
	public static boolean isInteger(String value) {
		try {
			Integer.parseInt(value);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
}
