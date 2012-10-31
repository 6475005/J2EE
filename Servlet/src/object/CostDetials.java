package object;

public class CostDetials {
	private Integer id;
	private String uid;
	private Float monthlyPay;
	private String year;
	private String month;
	private String state;
	public CostDetials(int id,String uid,Float monthlypay,String year,String month,String state){
		this.id = id;
		this.uid = uid;
		this.monthlyPay = monthlypay;
		this.year = year;
		this.month = month;
		this.state = state;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public Float getMonthlyPay() {
		return monthlyPay;
	}
	public void setMonthlyPay(Float monthlyPay) {
		this.monthlyPay = monthlyPay;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	

}
