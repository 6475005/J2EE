package object;

public class Building {
	private Integer id;
	private String name;
	private String location;
	private Integer SumOfRoom;
	private String postcode;
	public Building(String name, String location,int sumOfRoom,String postcode) {
		this.name = name;
		this.location = location;
		this.SumOfRoom = sumOfRoom;
		this.postcode = postcode;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public String getLocation() {
		return location;
	}
	public Integer getSumOfRoom() {
		return SumOfRoom;
	}
	public String getPostcode() {
		return postcode;
	}
	
}
