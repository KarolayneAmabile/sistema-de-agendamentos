package models;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Salon {

    private Map<LocalDate, List<Appointment>> appointments;
    private List<SalonListener> listerners;
    private List<Service> services;
    private BigDecimal total = BigDecimal.ZERO;
    
    public Salon() {
    	appointments = new HashMap<>();
    	services = new ArrayList<>();
    	listerners = new LinkedList<>();
    }
    
    public synchronized void addSalonListener(SalonListener listener) {
    	if(listerners.contains(listener)) {
    		return;
    	}
    	this.listerners.add(listener);
    }
    
    public void notifyNewAppointment(Appointment appointment) {
    	for(SalonListener listeners : this.listerners) {
    		listeners.updateAppointment(new SalonEvent(this, appointment));
    	}
    }
    
    public void notifyNewService(Service service) {
    	for(SalonListener listeners : this.listerners) {
    		listeners.updateService(new SalonEvent(this, service));
    	}
    }
    
    public void addAppointment(Appointment appointment) {
    	LocalDate date = appointment.getDate();

    	if (!appointments.containsKey(date)) {
    		appointments.put(date, new ArrayList<>());
        }
        appointments.get(date).add(appointment);
        this.total = this.total.add(appointment.getTotalValue());
        this.notifyNewAppointment(appointment);
    }
    
    public void addService(Service service) {
    	services.add(service);
    	notifyNewService(service);
    }
    
    public Map<LocalDate, List<Appointment>> getAppointments() {
    	return appointments;
    }

    public List<Service> getServices() {
    	return this.services;
    }
    
    public BigDecimal getTotal() {
    	return this.total;
    }
}
