package studentaction;

import java.util.ArrayList;
import java.util.List;

import object.Student;

import com.opensymphony.xwork2.ActionSupport;

import db.StudentDbManager;

public class StudentQueryAction extends ActionSupport {
	private List<Student> list = new ArrayList<Student>();
	private StudentDbManager studentDao;
	private int number;
	private String name;
	private String major;
	private String grade;

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
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
		// TODO Auto-generated method stub
		return super.execute();
	}

	public String queryByNumber() {
		if (!String.valueOf(number).equals("")) {
			list = studentDao.queryByNumber(String.valueOf(number));
			if (list == null) {
				return ERROR;
			} else {
				return SUCCESS;
			}
		} else {
			return ERROR;
		}
	}

	public String queryByName() {
		list = studentDao.query(name);
		if (list == null) {
			return ERROR;
		} else {
			return SUCCESS;
		}
	}

	public String queryByMajor() {
		list = studentDao.queryByMajor(major);
		if (list == null) {
			return ERROR;
		} else {
			return SUCCESS;
		}
	}

	public String queryByGrade() {
		list = studentDao.queryByGrade(grade);
		if (list == null) {
			return ERROR;
		} else {
			return SUCCESS;
		}
	}

}
