package studentaction;

import java.util.ArrayList;
import java.util.List;

import object.Student;

import com.opensymphony.xwork2.ActionSupport;

import db.StudentDbManager;

@SuppressWarnings("serial")
public class StudentQueryByNameAction extends ActionSupport {
	private static final int PAGESIZE = 7;
	private List<Student> list = new ArrayList<Student>();
	private StudentDbManager studentDao;
	private String name;
	private int currentPage;
	private int countPage;
	private int countStudent;
	private String[] pages;

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
		if (name.equals("")) {
			return INPUT;
		}
		if (!java.nio.charset.Charset.forName("GB2312").newEncoder()
				.canEncode(name)) {
			name = new String(name.getBytes("ISO-8859-1"), "UTF-8");
		}
		if (currentPage <= 0) {
			currentPage = 1;
		}
		List<Student> listset = studentDao.query(name);
		if (listset == null) {
			countStudent = 0;
		} else {
			countStudent = listset.size();
		}
		countPage = (countStudent / PAGESIZE) + 1;
		if (currentPage >= countPage) {
			currentPage = countPage;
		}

		list = studentDao.queryByName(name, currentPage, PAGESIZE);

		if (list == null) {
			return ERROR;
		} else {
			return SUCCESS;
		}
	}

}
