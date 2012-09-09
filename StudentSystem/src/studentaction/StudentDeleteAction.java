package studentaction;

import com.opensymphony.xwork2.ActionSupport;

import db.StudentDbManager;

public class StudentDeleteAction extends ActionSupport{
	private String number;
	private StudentDbManager studentDao;
	
	
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public StudentDbManager getStudentDao() {
		return studentDao;
	}

	public void setStudentDao(StudentDbManager studentDao) {
		this.studentDao = studentDao;
	}

	@Override
	public String execute() throws Exception {
		studentDao.delete(Integer.valueOf(number));
		return SUCCESS;
	}
	
	
}
