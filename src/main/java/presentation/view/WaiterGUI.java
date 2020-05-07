package presentation.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class WaiterGUI extends JFrame {
    private JFrame frame;
    private JTable jTableWaiter=new JTable();
    private JTabbedPane jTabbedPaneWaiter=new JTabbedPane();
    private JPanel jPanelCreateOrder=new JPanel();
    private JPanel jPanelComputePrice=new JPanel();
    private JPanel jPanelOrders=new JPanel();
    private JTextArea textArea = new JTextArea();
    private JButton btnFinish = new JButton("Finish order");
    private JLabel lblChooseItems= new JLabel("Choose items");
    private JButton btnAddToOrder = new JButton("Add to order");
    private JComboBox comboBoxCreateOrder = new JComboBox();
    private JTextField textFieldTable = new JTextField();
    private JTextField textFieldCompute= new JTextField();
    private  JLabel lblNewLabel = new JLabel("Table number");
    private JButton btnCompute = new JButton("Compute");
    private JTextPane textPaneCompute = new JTextPane();
    private JButton buttonGenerateBill = new JButton("Generate Bill");

    public WaiterGUI() {
        initialize();
    }
    private void initialize() {
        frame = new JFrame();

        frame.setBounds(500, 100, 650, 600);
        jTabbedPaneWaiter.setBounds(0,0,650,600);
        frame.getContentPane().setLayout(null);
        jPanelCreateOrder.setLayout(null);
        jPanelComputePrice.setLayout(null);
        jPanelOrders.setLayout(null);

        //create order

        btnFinish.setBounds(445, 484, 145, 21);
        jPanelCreateOrder.add(btnFinish);

        textArea.setBounds(232, 280, 265, 154);
        jPanelCreateOrder.add(textArea);

        lblChooseItems.setBounds(89, 187, 106, 21);
        jPanelCreateOrder.add(lblChooseItems);

        btnAddToOrder.setBounds(498, 187, 118, 21);
        jPanelCreateOrder.add(btnAddToOrder);

        comboBoxCreateOrder.setBounds(254, 187, 207, 23);
        jPanelCreateOrder.add(comboBoxCreateOrder);

        textFieldTable.setBounds(250, 117, 96, 19);
        jPanelCreateOrder.add(textFieldTable);
        textFieldTable.setColumns(10);

        lblNewLabel.setBounds(155, 116, 80, 16);
        jPanelCreateOrder.add(lblNewLabel);

        JLabel lblOrderItems = new JLabel("Order items:");
        lblOrderItems.setBounds(67, 286, 106, 21);
        jPanelCreateOrder.add(lblOrderItems);

        //compute price
        JLabel lblChooseTableCompute = new JLabel("Choose Table");
        lblChooseTableCompute.setBounds(86, 111, 125, 26);
        jPanelComputePrice.add(lblChooseTableCompute);

        textFieldCompute.setBounds(254, 114, 107, 23);
        jPanelComputePrice.add(textFieldCompute);

        textPaneCompute.setBounds(282, 288, 159, 26);
        jPanelComputePrice.add(textPaneCompute);

        JLabel lblPriceCompute = new JLabel("Price");
        lblPriceCompute.setBounds(140, 301, 49, 13);
        jPanelComputePrice.add(lblPriceCompute);

        btnCompute.setBounds(500, 114, 85, 21);
        jPanelComputePrice.add(btnCompute);

        buttonGenerateBill.setBackground(new Color(242, 255, 154));
        buttonGenerateBill.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        buttonGenerateBill.setBounds(275, 421, 159, 37);
        jPanelComputePrice.add(buttonGenerateBill);

        jTableWaiter.setBounds(0,0,500,600);
        JScrollPane sp=new JScrollPane(jTableWaiter);
        sp.setBounds(50,0,500,600);
        jPanelOrders.add(sp);

        jTabbedPaneWaiter.add("Create Order",jPanelCreateOrder);
        jTabbedPaneWaiter.add("Payment",jPanelComputePrice);
        jTabbedPaneWaiter.add("View orders",jPanelOrders);

        frame.getContentPane().add(jTabbedPaneWaiter);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
        frame.setTitle("Waiter");
    }
    public void addFinishListener(ActionListener action) {
        btnFinish.addActionListener(action);
    }
    public void addToOrderListener(ActionListener action) {
        btnAddToOrder.addActionListener(action);
    }
    public void addComputeListener(ActionListener action) {
        btnCompute.addActionListener(action);
    }
    public void addGenerateBillListener(ActionListener action) {
        buttonGenerateBill.addActionListener(action);
    }
    public JComboBox getComboBoxCreateOrder() {
        return comboBoxCreateOrder;
    }
    public void setComboBoxCreateOrder(JComboBox comboBoxCreateOrder) {
        this.comboBoxCreateOrder = comboBoxCreateOrder;
    }
    public String getTextArea() {
        return textArea.getText()+" ";
    }
    public void setTextArea(String s) {
        this.textArea.setText(s);
    }
    public String getTextFieldTable(){
        return this.textFieldTable.getText();
    }
    public void setTextFieldTable(String s){
        this.textFieldTable.setText(s);
    }
    public String getTextFieldCompute(){
        return this.textFieldCompute.getText();
    }
    public void setTextFieldCompute(String s){
        this.textFieldCompute.setText(s);
    }
    public void setTextPaneCompute(String s){ this.textPaneCompute.setText(s);}
    public JTable getJTableWaiter(){
        return this.jTableWaiter;
    }
}
