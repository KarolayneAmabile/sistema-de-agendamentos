package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import models.Salon;
import models.Appointment;
import models.SalonListener;
import models.SalonEvent;
import view.Planner;

public class SalonController implements ActionListener {

    private Salon salon;

    public SalonController(Salon salon) {
        this.salon = salon;
    }

    public void actionPerformed(ActionEvent event) {
        String command = event.getActionCommand();
        if (command.equals("NOVO AGENDAMENTO")) {
            Planner.openAppointmentForm();
        }
        if (command.equals("CADASTRAR SERVIÇO")) {
            Planner.openServiceForm();
        }
    }
}