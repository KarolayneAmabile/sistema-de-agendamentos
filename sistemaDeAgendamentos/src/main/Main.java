package main;

import controller.SalonController;
import models.Salon;
import view.Planner;

public class Main {
    public static void main(String[] args) {
    	Salon salon = Salon.start();
    	if (salon == null) {
    	    salon = new Salon(); 
    	}
        SalonController controller = new SalonController(salon);
        Planner planner = new Planner(salon); 
    }
}
