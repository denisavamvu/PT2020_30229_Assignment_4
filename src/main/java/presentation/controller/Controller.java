package presentation.controller;

import business.Restaurant;
import presentation.view.AdministratorGUI;
import presentation.view.ChefGUI;
import presentation.view.FrontGUI;
import presentation.view.WaiterGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
    private FrontGUI front;
    private Restaurant restaurant;
    private String fileName;
    public Controller(FrontGUI front,String fileName){
        this.front=front;
        this.fileName=fileName;
        restaurant=new Restaurant(fileName);

        front.addAdministratorListener(new AdministratorListener());
        front.addChefListener(new ChefListener());
        front.addWaiterListener(new WaiterListener());
    }
    class AdministratorListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            AdministratorGUI administratorGUI= new AdministratorGUI();
            AdministratorController administratorController= new AdministratorController(administratorGUI,restaurant,fileName);

        }
    }
    class ChefListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            ChefGUI chefGUI= new ChefGUI();
            restaurant.setObserver(chefGUI);

        }
    }
    class WaiterListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            WaiterGUI waiterGUI=new WaiterGUI();
            WaiterController waiterController= new WaiterController(waiterGUI,restaurant);
        }
    }

}
