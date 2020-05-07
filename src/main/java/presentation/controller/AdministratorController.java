package presentation.controller;

import business.BaseProduct;
import business.CompositeProduct;
import business.MenuItem;
import business.Restaurant;
import data.FileWriter;
import presentation.view.AdministratorGUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Vector;

public class AdministratorController {
    private AdministratorGUI administratorGUI;
    private Restaurant restaurant;
    private ArrayList<MenuItem> createCompositeRecepie=new ArrayList<MenuItem>();
    private ArrayList<MenuItem> editCompositeItems=new ArrayList<MenuItem>();
    private String fileName;
    public AdministratorController(AdministratorGUI administratorGUI,Restaurant restaurant,String fileName){
        this.fileName=fileName;
        this.administratorGUI=administratorGUI;
        this.restaurant= restaurant;
        administratorGUI.addCreateBaseListener(new CreateBaseListener());
        administratorGUI.addCreateCompositeAddIngredientListener(new CreateCompositeAddItemListener());
        administratorGUI.addCreateCompositeListener(new CreateCompositeCreateProductListener() );
        administratorGUI.addDeleteListener(new DeleteListener());
        administratorGUI.addChangeBaseListener(new ChangeBaseListener());
        administratorGUI.addEditCompositeFinish(new CreateFinishEditListener());
        administratorGUI.addEditCompositeAddIngredientListener(new CreateEditCompositeAddListener());
        fillTable();
        refreshComboBoxes();
    }
    private void addItemsToComboBox(JComboBox jComboBox){
        jComboBox.removeAllItems();
        for(MenuItem menuItem: restaurant.getMenu()){
            jComboBox.addItem(new String(menuItem.getName()));
        }
    }
    private void addOnlyBase(JComboBox jComboBox){
        jComboBox.removeAllItems();
        for(MenuItem menuItem: restaurant.getMenu()){
            if(menuItem instanceof BaseProduct){
                jComboBox.addItem(new String(menuItem.getName()));
            }
        }
    }
    private void addOnlyComposite(JComboBox jComboBox){
        jComboBox.removeAllItems();
        for(MenuItem menuItem: restaurant.getMenu()){
            if(menuItem instanceof CompositeProduct){
                jComboBox.addItem(new String(menuItem.getName()));
            }
        }
    }
    private void refreshComboBoxes(){
        addItemsToComboBox(administratorGUI.getComboBoxComposite());
        addOnlyBase(administratorGUI.getComboBoxEditBase());
        addItemsToComboBox(administratorGUI.getComboBoxDelete());
        addItemsToComboBox(administratorGUI.getComboBoxCompositeSelectToAdd());
        addOnlyComposite(administratorGUI.getComboBoxCompositeSelectProduct());
        fillTable();
    }
    private void fillTable(){
        JTable table = administratorGUI.getJTableAdministrator();
        table.removeAll();
        Vector<Vector<Object>> rows = new Vector<Vector<Object>>();
        Vector<String> name = new Vector<>();
        name.add("Name");
        name.add("Price");

        for(MenuItem m: restaurant.getMenu()) {
            Vector<Object> row = new Vector<>();
            row.add(m.getName());
            row.add(m.getPrice());
            rows.add(row);
        }

        table.setModel(new DefaultTableModel(rows, name));
    }
    class CreateBaseListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String name=administratorGUI.getTextCreateBaseName();
            int price=Integer.parseInt(administratorGUI.getTextCreateBasePrice());
            System.out.println(price);
            restaurant.createMenuItem(price,name);
            FileWriter.writeMenu(restaurant.getMenu(),fileName);
            administratorGUI.setTextCreateBaseName("");
            administratorGUI.setTextCreateBasePrice("");
            refreshComboBoxes();
        }
    }
    class CreateCompositeAddItemListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            ArrayList<MenuItem> menuItemsComboBox = restaurant.getMenu();
            String name = (String) administratorGUI.getComboBoxComposite().getSelectedItem();
            for(MenuItem menuItem: menuItemsComboBox)
                if(menuItem.getName().equals(name))
                {
                    createCompositeRecepie.add(menuItem);
                    administratorGUI.getComboBoxComposite().removeItem(name);
                    break;
                }
            administratorGUI.setTextAreaCompositeIngredients(administratorGUI.getTextAreaCompositeIngredients()+name);
        }
    }
    class CreateCompositeCreateProductListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            String name=administratorGUI.getTextCompositeName();
            restaurant.createMenuItem(name,createCompositeRecepie);
            FileWriter.writeMenu(restaurant.getMenu(),fileName);
            refreshComboBoxes();
            administratorGUI.setTextCreateCompositeName("");
            administratorGUI.setTextAreaCompositeIngredients("");
            createCompositeRecepie.removeAll(createCompositeRecepie);
        }
    }
    class DeleteListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            String name = (String) administratorGUI.getComboBoxDelete().getSelectedItem();
            restaurant.deleteMenuItem(name);
            FileWriter.writeMenu(restaurant.getMenu(),fileName);
            refreshComboBoxes();
        }
    }
    class ChangeBaseListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            String product=(String) administratorGUI.getComboBoxEditBase().getSelectedItem();
            String newName=administratorGUI.getTextEditBaseName();
            String price=administratorGUI.getTextEditBasePrice();
            int newPrice=-1;
            if(price.equals("")==false)
                newPrice=Integer.parseInt(price);
            restaurant.editMenuItem(product,newName,newPrice);
            FileWriter.writeMenu(restaurant.getMenu(),fileName);
            administratorGUI.setTextEditBaseName("");
            administratorGUI.setTextEditBasePrice("");
            refreshComboBoxes();

        }
    }
    class CreateEditCompositeAddListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            ArrayList<MenuItem> menuItemsComboBox = restaurant.getMenu();
            String name = (String) administratorGUI.getComboBoxCompositeSelectToAdd().getSelectedItem();
            for(MenuItem menuItem: menuItemsComboBox)
                if(menuItem.getName().equals(name))
                {
                    editCompositeItems.add(menuItem);
                    administratorGUI.getComboBoxCompositeSelectToAdd().removeItem(name);
                    break;
                }
            administratorGUI.setTextAreaCompositeEdit(administratorGUI.getTextAreaCompositeEdit()+name);
        }
    }
    class CreateFinishEditListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            String name=(String) administratorGUI.getComboBoxCompositeSelectProduct().getSelectedItem();
            String newName=administratorGUI.getTextFieldEditCompositeName();

            restaurant.editMenuItem(name,newName,editCompositeItems);
            FileWriter.writeMenu(restaurant.getMenu(),fileName);
            refreshComboBoxes();
            administratorGUI.setTextFieldEditCompositeName("");
            administratorGUI.setTextAreaCompositeEdit("");
            editCompositeItems.removeAll(editCompositeItems);
        }
    }

}
