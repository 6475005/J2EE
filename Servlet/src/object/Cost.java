package object;

public class Cost {
	private Integer id;
	private Integer uid;
	private Float monthlyPay;
	private String year;
	private String month;
	private Integer state;
	public Cost(int uid,Float monthlypay,String year,String month,Integer state){
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
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
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
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	

}
