package bean;

public class Doctor {
	private int id;
	private String name;
	private String jobtitle;
	private int titleid;
	private String hospital;
	private String departdetail;
	private String goodat;
	private int area;
	private String department;
	private int hospitalid;
	private double rating;
	private Hospital hos;
	
	
	
	/**
	 * @return the hos
	 */
	public Hospital getHos() {
		return hos;
	}



	/**
	 * @param hos the hos to set
	 */
	public void setHos(Hospital hos) {
		this.hos = hos;
	}



	public Doctor(int id, String name, String jobtitle, int titleid,
			String hospital, String departdetail, String goodat, int area,
			String department, int hospitalid, int rating) {
		super();
		this.id = id;
		this.name = name;
		this.jobtitle = jobtitle;
		this.titleid = titleid;
		this.hospital = hospital;
		this.departdetail = departdetail;
		this.goodat = goodat;
		this.area = area;
		this.department = department;
		this.hospitalid = hospitalid;
		this.rating = rating;
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Doctor [id=" + id + ", name=" + name + ", jobtitle=" + jobtitle
				+ ", titleid=" + titleid + ", hospital=" + hospital
				+ ", departdetail=" + departdetail + ", goodat=" + goodat
				+ ", area=" + area + ", department=" + department
				+ ", hospitalid=" + hospitalid + ", rating=" + rating + "]";
	}



	/**
	 * @return the hospitalid
	 */
	public int getHospitalid() {
		return hospitalid;
	}



	/**
	 * @param hospitalid the hospitalid to set
	 */
	public void setHospitalid(int hospitalid) {
		this.hospitalid = hospitalid;
	}



	/**
	 * @return the titleid
	 */
	public int getTitleid() {
		return titleid;
	}

	

	/**
	 * @param titleid the titleid to set
	 */
	public void setTitleid(int titleid) {
		this.titleid = titleid;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJobtitle() {
		return jobtitle;
	}
	public void setJobtitle(String jobtitle) {
		this.jobtitle = jobtitle;
	}
	public String getHospital() {
		return hospital;
	}
	public void setHospital(String hospital) {
		this.hospital = hospital;
	}
	public String getDepartdetail() {
		return departdetail;
	}
	public void setDepartdetail(String departdetail) {
		this.departdetail = departdetail;
	}
	public String getGoodat() {
		return goodat;
	}
	public void setGoodat(String goodat) {
		this.goodat = goodat;
	}
	public int getArea() {
		return area;
	}
	public void setArea(int area) {
		if((1<=area&&area<=4)||(8<=area&&area<=31))
			this.area = area;
		else
			this.area = 1;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	
	

	public Doctor() {
		// TODO Auto-generated constructor stub
	}

}
