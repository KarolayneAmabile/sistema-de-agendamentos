package factory;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;

import exceptions.StrException;
import models.Appointment;
import models.Service;
import serialization.Serialization;

public class SalonFactory {
	private static int serialService = 0;
	private static int serialAppointment = 0;
		
	public static Service createService(String serviceName, BigDecimal price) throws StrException {
		Service service = null;

		if (!(serviceName != null && !serviceName.trim().isEmpty() && (serviceName.length() <= 100 && serviceName.length() >= 3))) {
			throw new StrException("Adicione um nome ao serviço cadastrado.");
		}
		if ((price == null || price.compareTo(BigDecimal.ZERO) <= 0)) {
	        throw new StrException("O preço deve ser maior que zero e não pode ser nulo.");
	    }
		service = new Service(serialService, serviceName, price);
		serialService++;
		return service;
	}
	
	public static Appointment createAppointment(String customer, String date, String time, Service service) throws StrException {
		Appointment appointment = null;
        LocalDate parsedDate = null;
        LocalTime parsedTime = null;
        try {
            parsedDate = LocalDate.parse(date);
        } catch (DateTimeParseException e) {
            throw new StrException("Data inválida. O formato correto é yyyy-MM-dd.");
        }
        try {
            parsedTime = LocalTime.parse(time);
        } catch (DateTimeParseException e) {
            throw new StrException("Hora inválida. O formato correto é HH:mm.");
        }
        
		appointment = new Appointment(serialAppointment, customer, parsedDate, parsedTime, service);
		serialAppointment++;
		return appointment;
	}
}
