package studentaction;

import object.Student;

import com.opensymphony.xwork2.ActionSupport;

import db.StudentDbManager;

@SuppressWarnings("serial")
public class UpdataStudentAction extends ActionSupport {
	private StudentDbManager studentDao;
	private String number;
	private String major;
	private String grade;
	private String phone;
	
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public StudentDbManager getStudentDao() {
		return studentDao;
	}

	public void setStudentDao(StudentDbManager studentDao) {
		this.studentDao = studentDao;
	}

	@Override
	public String execute() throws Exception {
		Student temp = studentDao.queryByNumber(Integer.valueOf(number));
		temp.setMajor(major);
		temp.setGrade(grade);
		temp.setPhone(phone);
		studentDao.updata(temp);
		return SUCCESS;
	}
}
