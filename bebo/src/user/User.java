package user;

public class User {
	private String name;
	private String phone;
	
	public User (String name, String phone) {
		this.setName(name);
		this.setPhone(phone);
	}
	
	public User (String name) {
		this.setName(name);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
}
