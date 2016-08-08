package bean;

public class User {

	private int id;
	private String name;
	private String password;
	private double L = 0;
	private double T;
	private int S = 0;
	private double C = 0;
	
	public User(int id, String name, String password) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password
				+ "]";
	}
	
	
	public double getC() {
		return C;
	}

	public void setC(double c) {
		C = c;
	}

	public int getS() {
		return S;
	}

	public void setS(int s) {
		S = s;
	}

	public double getT() {
		return T;
	}

	public void setT(double t) {
		T = t;
	}

	/**
	 * @return the l
	 */
	public double getL() {
		return L;
	}

	/**
	 * @param l the l to set
	 */
	public void setL(double l) {
		L = l;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User() {
		// TODO Auto-generated constructor stub
	}

}
