package models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import exceptions.StrException;

public class Appointment implements Serializable {
	
	private int id;
	private String customer;
	private BigDecimal totalValue = BigDecimal.ZERO;
	private LocalDate date; 
	private LocalTime time; 
	private Service service;
	
	public Appointment (int id, String customer, LocalDate date, LocalTime time, Service service) throws StrException {
		this.setId(id);
		this.setCustomer(customer);
		this.setDate(date);
		this.setTime(time);
		this.setService(service);
		this.totalValue = service.getPrice();
	}
	
	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	
	public Service getService() {
		return service;
	}
	public void setService(Service service) {
		this.service = service;
		this.totalValue = service.getPrice();
	}
	
	public BigDecimal getTotalValue() {
		return totalValue;
	}

	public LocalDate getDate() {
		return date;
	}
	
    public void setDate(LocalDate date) throws StrException {
           this.date = date;
    }

	public LocalTime getTime() {
		return time;
	}
	public void setTime(LocalTime time) throws StrException {
           this.time = time;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
