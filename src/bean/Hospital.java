package bean;

public class Hospital {
	private int id;
	private String hospital;
	private int province;
	private String address;
	private String level;
	private String goodat;
	private String type;
	private double rating;
	
	public Hospital(int id, String hospital, int province, String address,
			String level, String goodat, String type, double rating) {
		super();
		this.id = id;
		this.hospital = hospital;
		this.province = province;
		this.address = address;
		this.level = level;
		this.goodat = goodat;
		this.type = type;
		this.rating = rating;
	}

	public String getHospital() {
		return hospital;
	}

	public void setHospital(String hospital) {
		this.hospital = hospital;
	}

	public int getProvince() {
		return province;
	}

	public void setProvince(int province) {
		this.province = province;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getGoodat() {
		return goodat;
	}

	public void setGoodat(String goodat) {
		this.goodat = goodat;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Hospital(String hospital, int province, String address,
			String level, String goodat, String type, double rating) {
		super();
		this.hospital = hospital;
		this.province = province;
		this.address = address;
		this.level = level;
		this.goodat = goodat;
		this.type = type;
		this.rating = rating;
	}

	public Hospital() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Hospital [id=" + id + ", hospital=" + hospital + ", province="
				+ province + ", address=" + address + ", level=" + level
				+ ", goodat=" + goodat + ", type=" + type + ", rating="
				+ rating + "]";
	}

	
	
	
}
