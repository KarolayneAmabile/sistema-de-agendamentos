package view;

import models.Appointment;
import models.Salon;
import models.SalonEvent;
import models.Service;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.math.BigDecimal;
import java.util.List;

import controller.SalonController;
import exceptions.StrException;
import factory.SalonFactory;
import models.SalonListener;

@SuppressWarnings("serial")
public class Planner extends JFrame implements SalonListener {

    private static Salon salon;
    private static JTable table;
    private static JLabel totalValue;
    private static JFrame frame;
    
    public Planner(Salon salon) {
        Planner.salon = salon;
        salon.addSalonListener(this);
        createWindow();
    }

    public static void createWindow() {
        frame = new JFrame("Sistema de Agendamentos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 500);
        frame.setLayout(new BorderLayout(10, 10));

        JPanel topPanel = new JPanel(new BorderLayout());
        JLabel name = new JLabel("Sistema de Agendamentos");
        name.setFont(new Font("Arial", Font.BOLD, 20));
        topPanel.add(name, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        JButton newAppointment = new JButton("NOVO AGENDAMENTO");
        JButton newService = new JButton("CADASTRAR SERVIÇO");

        SalonController controller = new SalonController(salon);
        newAppointment.addActionListener(controller);
        newService.addActionListener(controller);

        buttonPanel.add(newAppointment);
        buttonPanel.add(newService);
        topPanel.add(buttonPanel, BorderLayout.EAST);

        frame.add(topPanel, BorderLayout.NORTH);

        List<Appointment> appointments = salon.getAppointments().values().stream().flatMap(List::stream).toList();
        Object[][] rows = new Object[appointments.size()][5];

        for (int i = 0; i < appointments.size(); i++) {
            Appointment appointment = appointments.get(i);
            rows[i][0] = appointment.getDate().toString() + " : " + appointment.getTime().toString();
            rows[i][1] = appointment.getCustomer();
            rows[i][2] = appointment.getService().getServiceName();
            rows[i][3] = "R$ " + appointment.getTotalValue().toString();
        }

        table = new JTable(new DefaultTableModel(rows, new String[]{"HORÁRIOS", "CLIENTE", "SERVIÇO", "PREÇO FINAL"}));

        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new BorderLayout());
        JLabel totalLabel = new JLabel("TOTAL DO DIA", SwingConstants.LEFT);
        totalLabel.setFont(new Font("Arial", Font.BOLD, 12));
        bottomPanel.add(totalLabel, BorderLayout.WEST);

        totalValue = new JLabel("R$ " + salon.getTotal().toString(), SwingConstants.RIGHT);
        totalValue.setFont(new Font("Arial", Font.BOLD, 12));
        bottomPanel.add(totalValue, BorderLayout.EAST);

        frame.add(bottomPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    public static void openAppointmentForm() {
        JPanel appointmentPanel = new JPanel(new GridLayout(4, 2));
        
        JTextField clientName = new JTextField();
        JTextField dateText = new JTextField();
        JTextField timeText = new JTextField();

        JComboBox<Service> serviceComboBox = new JComboBox<>(salon.getServices().toArray(new Service[0]));

        appointmentPanel.add(new JLabel("Nome do cliente: "));
        appointmentPanel.add(clientName);
        appointmentPanel.add(new JLabel("Data: yyyy-MM-dd"));
        appointmentPanel.add(dateText);
        appointmentPanel.add(new JLabel("Horário: HH:mm"));
        appointmentPanel.add(timeText);
        appointmentPanel.add(new JLabel("Serviço: "));
        appointmentPanel.add(serviceComboBox);

        int option = JOptionPane.showConfirmDialog(null, appointmentPanel, "Novo Agendamento", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
        	try {
            	salon.addAppointment(SalonFactory.createAppointment(
            			clientName.getText(),
            			dateText.getText(),
            			timeText.getText(),
            			(Service) serviceComboBox.getSelectedItem())
            	);
            	JOptionPane.showMessageDialog(null, "Agendamento criado com sucesso");
            } catch (StrException e) {
            	JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
            }
            
            frame.dispose();
            createWindow();
        }
    }

    public static void openServiceForm() {
        JPanel servicePanel = new JPanel(new GridLayout(3, 2));
        JTextField serviceName = new JTextField();
        JTextField price = new JTextField();

        servicePanel.add(new JLabel("Nome do serviço: "));
        servicePanel.add(serviceName);
        servicePanel.add(new JLabel("Preço do serviço: "));
        servicePanel.add(price);

        int option = JOptionPane.showConfirmDialog(null, servicePanel, "Novo Serviço", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            try {
                salon.addService(SalonFactory.createService(
                		serviceName.getText(), 
                		new BigDecimal(price.getText()))
                );
                JOptionPane.showMessageDialog(null, "Serviço cadastrado com sucesso.");
            } catch (StrException e) {
            	JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
            } catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
    }

    @Override
    public void updateAppointment(SalonEvent event) {
    //
    }

    @Override
    public void updateService(SalonEvent event) {
    //
    }
}
