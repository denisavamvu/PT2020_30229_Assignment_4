package presentation.view;

import business.MenuItem;
import business.Restaurant;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class ChefGUI extends JFrame implements Observer {
    private JFrame frame;
    private JTextPane textPaneChef;
    public ChefGUI(){
        initialize();
    }
    public void initialize(){
        frame = new JFrame();
        frame.setBounds(500, 100, 600, 400);
        frame.getContentPane().setLayout(null);

        textPaneChef= new JTextPane();
        textPaneChef.setBounds(30,30,400,300);
        frame.add(textPaneChef);


        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
        frame.setTitle("Chef");
    }
    public void setTextPaneChef(String s){
        this.textPaneChef.setText(s);
    }
    @Override
    public void update(Observable o, Object arg) {
        String s="Processing order\nProducts: ";
        ArrayList <MenuItem> order=(ArrayList<MenuItem>)arg;
        for(MenuItem menuItem: order)
            s+=menuItem.getName()+" ";
        setTextPaneChef(s);
    }
}
