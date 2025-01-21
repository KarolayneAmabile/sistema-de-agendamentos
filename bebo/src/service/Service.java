package service;

public class Service {
	private int id;
	private String description;
	private float price;
	
	public Service(int id, String description, float price) {
		this.id = id;
		this.setDescription(description);
		this.setPrice(price);
	}
	
	public String getDescripstion() {
		return this.description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public float getPrice() {
		return this.price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
}
