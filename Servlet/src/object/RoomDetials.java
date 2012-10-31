package object;

public class RoomDetials {
	private Integer id;
	private String bid;
	private String uid;
	private Integer floor;
	private Float area;
	public RoomDetials(int id,String bid,String uid,int floor,float area) {
		this.id = id;
		this.bid = bid;
		this.uid = uid;
		this.floor = floor;
		this.area = area;
	}
	public Integer getId() {
		return id;
	}
	public String getBid() {
		return bid;
	}
	public String getUid() {
		return uid;
	}
	public Integer getFloor() {
		return floor;
	}
	public Float getArea() {
		return area;
	}
	
}
