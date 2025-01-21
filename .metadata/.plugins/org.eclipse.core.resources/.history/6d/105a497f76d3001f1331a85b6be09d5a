package service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import user.Customer;

public class Appointment {
	
	private int id;
	private Customer customer;
	private Service service;
	private float price;
	private Date date;
	private String obs;
	
	public Appointment (int id, Customer customer, Service service, float price, String date)
	{
		this.id = id;
		this.setCustomer(customer);
		this.setService(service);
		this.setPrice(price);
		this.setDate(date);
	}
	
	public Appointment (int id, Customer customer, Service service, float price, String date, String obs)
	{
		this.id = id;
		this.setCustomer(customer);
		this.setService(service);
		this.setPrice(price);
		this.setDate(date);
		this.setObs(obs);
	}
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public Service getService() {
		return service;
	}
	public void setService(Service service) {
		this.service = service;
	}
	
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	public Date getDate() {
		return date;
	}
	public void setDate(String date) {
			try {
				this.date = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(date);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	public String getObs() {
		return obs;
	}
	public void setObs(String obs) {
		this.obs = obs;
	}
	
}