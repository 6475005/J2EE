package object;

public class Room {
	private Integer id;
	private Integer bid;
	private Integer uid;
	private Integer floor;
	private Float area;
	public Room(int bid,int uid,int floor,float area) {
		this.bid = bid;
		this.uid = uid;
		this.floor = floor;
		this.area = area;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getBid() {
		return bid;
	}
	public Integer getUid() {
		return uid;
	}
	public Integer getFloor() {
		return floor;
	}
	public Float getArea() {
		return area;
	}
	
}
