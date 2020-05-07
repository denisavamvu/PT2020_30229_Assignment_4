package presentation.controller;

import business.CompositeProduct;
import business.MenuItem;
import business.Order;
import business.Restaurant;
import presentation.view.WaiterGUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Vector;

public class WaiterController {
    private WaiterGUI waiterGUI;
    private Restaurant restaurant;
    private ArrayList<MenuItem> order= new ArrayList<MenuItem>();
    public WaiterController(WaiterGUI waiterGUI, Restaurant restaurant){
        this.waiterGUI=waiterGUI;
        this.restaurant=restaurant;
        waiterGUI.addToOrderListener(new CreateOrderAddItemListener());
        waiterGUI.addFinishListener(new CreateFinishOrderListener());
        waiterGUI.addComputeListener(new CreateAddComputeListener());
        waiterGUI.addGenerateBillListener(new CreateGenerateBillListener());
        addItemsToComboBoxOrder(waiterGUI.getComboBoxCreateOrder());
        fillTable();
    }
    private void addItemsToComboBoxOrder(JComboBox jComboBox){
        jComboBox.removeAllItems();
        for(MenuItem menuItem: restaurant.getMenu()){
            if(menuItem instanceof CompositeProduct)
                jComboBox.addItem(new String(menuItem.getName()));
        }
    }
    private void fillTable(){
        JTable table = waiterGUI.getJTableWaiter();
        table.removeAll();
        Vector<Vector<Object>> rows = new Vector<Vector<Object>>();
        Vector<String> name = new Vector<>();
        name.add("ID");
        name.add("Table");
        name.add("Date");

        for(Order order: restaurant.getOrders()) {
            Vector<Object> row = new Vector<>();
            row.add(order.getOrderID());
            row.add(order.getTable());
            row.add(order.getDate());
            rows.add(row);
        }
        table.setModel(new DefaultTableModel(rows, name));
    }
    class CreateOrderAddItemListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            ArrayList<MenuItem> menuItemsComboBox = restaurant.getMenu();
           String nameOrderItem= (String) waiterGUI.getComboBoxCreateOrder().getSelectedItem();
            for(MenuItem menuItem: menuItemsComboBox)
                if(menuItem.getName().equals(nameOrderItem)) {
                    order.add(menuItem);
                    waiterGUI.getComboBoxCreateOrder().removeItem(nameOrderItem);
                    break;
                }
            waiterGUI.setTextArea(waiterGUI.getTextArea()+nameOrderItem);
        }
    }
    class CreateFinishOrderListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String tableNumber=waiterGUI.getTextFieldTable();
            int table=-1;
            if(tableNumber.equals("")==false)
                table=Integer.parseInt(tableNumber);
            restaurant.createOrder(table,order);
            waiterGUI.setTextArea("");
            waiterGUI.setTextFieldTable("");
            addItemsToComboBoxOrder(waiterGUI.getComboBoxCreateOrder());
            fillTable();
            order.removeAll(order);
        }
    }
    class CreateAddComputeListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String tableNumber=waiterGUI.getTextFieldCompute();
            int table=-1;
            if(tableNumber.equals("")==false)
                table=Integer.parseInt(tableNumber);
           int price=restaurant.computePrice(table);
           waiterGUI.setTextPaneCompute(Integer.toString(price));
        }
    }
    class CreateGenerateBillListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String tableNumber=waiterGUI.getTextFieldCompute();
            int table=-1;
            if(tableNumber.equals("")==false)
                table=Integer.parseInt(tableNumber);
            restaurant.generateBill(table);
            fillTable();
        }
    }
}
