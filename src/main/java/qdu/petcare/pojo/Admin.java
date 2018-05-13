package qdu.petcare.pojo;

public class Admin {
	private Integer id;
	private String adminname;
	private String password;
	
	public Admin() {
		super();
	}
	
	public Admin(String adminname, String password) {
		super();
		this.adminname = adminname;
		this.password = password;
	}

	public Admin(Integer id, String adminname, String password) {
		super();
		this.id = id;
		this.adminname = adminname;
		this.password = password;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAdminname() {
		return adminname;
	}
	public void setAdminname(String adminname) {
		this.adminname = adminname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Admin [id=" + id + ", adminname=" + adminname + ", password=" + password + "]";
	}
	
	

}
