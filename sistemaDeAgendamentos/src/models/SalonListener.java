package models;

public interface SalonListener {
	public void updateAppointment(SalonEvent event);
	public void updateService(SalonEvent event);
}
