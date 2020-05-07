package presentation.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class FrontGUI extends JFrame {
    private JFrame frame;
    private JButton buttonWaiter= new JButton("Waiter");
    private JButton buttonAdministrator= new JButton("Administrator");
    private JButton buttonChef = new JButton("Chef");
    public FrontGUI() {
        initialize();
    }
    private void initialize() {
        frame = new JFrame();

        frame.setBounds(100, 100, 400, 300);
        frame.getContentPane().setLayout(null);

        buttonAdministrator.setBounds(100, 50, 150, 30);
        buttonAdministrator.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        buttonAdministrator.setBackground(Color.WHITE);
        frame.getContentPane().add(buttonAdministrator);

        buttonWaiter.setBounds(100, 100, 150, 30);
        buttonWaiter.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        buttonWaiter.setBackground(Color.WHITE);
        frame.getContentPane().add(buttonWaiter);

        buttonChef.setBounds(100, 150, 150, 30);
        buttonChef.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        buttonChef.setBackground(Color.WHITE);
        frame.getContentPane().add(buttonChef);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setTitle("Restaurant");
    }
    public void addAdministratorListener(ActionListener action) {
        buttonAdministrator.addActionListener(action);
    }
    public void addWaiterListener(ActionListener action) {
        buttonWaiter.addActionListener(action);
    }
    public void addChefListener(ActionListener action) {
        buttonChef.addActionListener(action);
    }
}
