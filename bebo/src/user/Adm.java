package user;

public class Adm extends User {
	private int id;
	private String password;
	private String email;
	
	public Adm (int id, String name, String phone, String password, String email) {
		super(name, phone);
		this.id = id;
		this.setPassword(password);
		this.setEmail(email);
	}
	
	public String getPassword() {
		return this.password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getEmail() {
		return this.email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
