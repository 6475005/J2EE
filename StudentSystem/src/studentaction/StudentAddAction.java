package studentaction;

import object.Student;

import com.opensymphony.xwork2.ActionSupport;

import db.StudentDbManager;

public class StudentAddAction extends ActionSupport {
	private Student student;
	private StudentDbManager studentDao;

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public StudentDbManager getStudentDao() {
		return studentDao;
	}

	public void setStudentDao(StudentDbManager studentDao) {
		this.studentDao = studentDao;
	}

	@Override
	public String execute() throws Exception {
		if (!studentDao.query(Integer.valueOf(student.getNumber()))) {
			studentDao.add(student);
			return SUCCESS;
		} else {
			return ERROR;
		}
	}

}
