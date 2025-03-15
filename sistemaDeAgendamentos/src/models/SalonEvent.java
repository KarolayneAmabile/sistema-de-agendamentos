package models;

import java.math.BigDecimal;
import java.util.EventObject;

@SuppressWarnings("serial")
public class SalonEvent extends EventObject {
	private Appointment appointment;
	private Service service;
	private BigDecimal total = BigDecimal.ZERO;
	
	public SalonEvent(Salon source) {
		super(source);
	}
	
	public SalonEvent(Salon source, Appointment appointment) {
		super(source);
		this.appointment = appointment;
		this.total = source.getTotal();
	}

	public SalonEvent(Salon source, Service service) {
		super(source);
		this.service = service;
	}
	
	public Appointment getAppointment() {
		return this.appointment;
	}
	public Service getService() {
		return this.service;
	}
	public BigDecimal getTotal() {
		return this.total;
	}
}
