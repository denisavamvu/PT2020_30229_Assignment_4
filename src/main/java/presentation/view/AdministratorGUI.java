package presentation.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class AdministratorGUI extends JFrame {
    private JFrame frame;
    private JTabbedPane jTabbedPane=new JTabbedPane();
    private JPanel jPanelMenuItems=new JPanel();
    private JTable jTableAdministrator=new JTable();
    //create composite product
    private JPanel jPanelCreateComposite=new JPanel();
    private JButton buttonCreateComposite = new JButton("Create");
    private JButton buttonCreateCompositeAddIngredient = new JButton("Add ingredient");
    private JTextArea textAreaCompositeIngredients = new JTextArea();
    private JTextField textFieldCompositeName = new JTextField();
    private JComboBox comboBoxComposite = new JComboBox();
    //create base product
    private JPanel jPanelCreateBase=new JPanel();
    private JTextField textFieldCreateBaseName;
    private JTextField textFieldCreateBasePrice;
    private JButton buttonCreateBase=new JButton("Create");
    //edit composite product
    private JPanel jPanelEditComposite=new JPanel();
    private JButton buttonEditCompositeAddIngredient = new JButton("Add ingredient");
    private JButton buttonEditCompositeFinish = new JButton("Finish");
    private JComboBox comboBoxCompositeSelectToAdd = new JComboBox();
    private JComboBox comboBoxCompositeSelectProduct = new JComboBox();
    private  JTextArea textAreaCompositeEdit = new JTextArea();
    private JTextField textFieldEditCompositeName=new JTextField();
    //edit base product
    private JPanel jPanelEditBase=new JPanel();
    private JComboBox comboBoxEditBase = new JComboBox();
    private JButton buttonChangeBase = new JButton("Change");
    private JTextField jTextFieldChangeBaseName = new JTextField();
    private JTextField jTextFieldChangeBasePrice = new JTextField();
    //delete product
    private JPanel jPanelDeleteProduct=new JPanel();
    private JComboBox comboBoxDelete = new JComboBox();
    private JButton buttonDelete = new JButton("Delete");


    public AdministratorGUI() {
        initialize();
    }
    private void initialize() {
        frame = new JFrame();

        frame.setBounds(500, 100, 700, 600);
        frame.getContentPane().setLayout(null);

        jTabbedPane.setBounds(0,0,700,600);

        jPanelCreateComposite.setLayout(null);
        jPanelCreateBase.setLayout(null);
        jPanelEditComposite.setLayout(null);
        jPanelEditBase.setLayout(null);
        jPanelDeleteProduct.setLayout(null);
        jPanelMenuItems.setLayout(null);

        //create base product
        JLabel lblIntroduceName = new JLabel("Introduce name");
        lblIntroduceName.setBounds(77, 173, 120, 46);
        lblIntroduceName.setFont(new Font("Times New Roman", Font.PLAIN, 17));
        jPanelCreateBase.add(lblIntroduceName);

        textFieldCreateBaseName = new JTextField();
        textFieldCreateBaseName.setBounds(226, 181, 250, 30);
        jPanelCreateBase.add(textFieldCreateBaseName);
        textFieldCreateBaseName.setColumns(10);

        JLabel lblIntroducePrice = new JLabel("Introduce price");
        lblIntroducePrice.setBounds(77, 255, 110, 46);
        lblIntroducePrice.setFont(new Font("Times New Roman", Font.PLAIN, 17));
        jPanelCreateBase.add(lblIntroducePrice);

        textFieldCreateBasePrice = new JTextField();
        textFieldCreateBasePrice.setBounds(226, 261, 250, 30);
        jPanelCreateBase.add(textFieldCreateBasePrice);
        textFieldCreateBasePrice.setColumns(10);

        buttonCreateBase.setBounds(294, 322, 118, 30);
        jPanelCreateBase.add(buttonCreateBase);

        //delete product
        JLabel lblSelectProduct = new JLabel("Select product");
        lblSelectProduct.setBounds(179, 113, 100, 46);
        lblSelectProduct.setFont(new Font("Times New Roman", Font.PLAIN, 17));
        jPanelDeleteProduct.add(lblSelectProduct);

        buttonDelete.setBounds(287, 333, 85, 21);
        jPanelDeleteProduct.add(buttonDelete);


        comboBoxDelete.setBounds(423, 126, 207, 23);
        jPanelDeleteProduct.add(comboBoxDelete);

        //edit base product
        JLabel lblSelectProductEditBase = new JLabel("Select product");
        lblSelectProductEditBase.setFont(new Font("Times New Roman", Font.PLAIN, 17));
        lblSelectProductEditBase.setBounds(179, 113, 100, 46);
        jPanelEditBase.add(lblSelectProductEditBase);

        JLabel lblIntroduceNameEdit = new JLabel("Introduce name");
        lblIntroduceNameEdit.setBounds(77, 173, 120, 46);
        lblIntroduceNameEdit.setFont(new Font("Times New Roman", Font.PLAIN, 17));
        jPanelEditBase.add(lblIntroduceNameEdit);

        jTextFieldChangeBaseName.setBounds(226, 181, 250, 30);
        jPanelEditBase.add(jTextFieldChangeBaseName);
        jTextFieldChangeBaseName.setColumns(10);

        JLabel lblIntroducePriceEdit = new JLabel("Introduce price");
        lblIntroducePriceEdit.setBounds(77, 255, 110, 46);
        lblIntroducePriceEdit.setFont(new Font("Times New Roman", Font.PLAIN, 17));
        jPanelEditBase.add(lblIntroducePriceEdit);

        jTextFieldChangeBasePrice.setBounds(226, 261, 250, 30);
        jPanelEditBase.add(jTextFieldChangeBasePrice);
        jTextFieldChangeBasePrice.setColumns(10);


        buttonChangeBase.setBounds(287, 333, 85, 21);
        jPanelEditBase.add(buttonChangeBase);

        comboBoxEditBase.setBounds(423, 126, 207, 23);
        jPanelEditBase.add(comboBoxEditBase);

        //create composite product
        buttonCreateComposite.setBounds(446, 482, 85, 21);
        jPanelCreateComposite.add(buttonCreateComposite);

        JLabel lblIntroduceNameComposite = new JLabel("Introduce name");
        lblIntroduceNameComposite.setBounds(112, 98, 91, 21);
        jPanelCreateComposite.add(lblIntroduceNameComposite);

        comboBoxComposite.setBounds(257, 167, 207, 23);
        jPanelCreateComposite.add(comboBoxComposite);

        buttonCreateCompositeAddIngredient.setBounds(531, 167, 118, 21);
        jPanelCreateComposite.add(buttonCreateCompositeAddIngredient);

        JLabel lblChooseIngredient = new JLabel("Choose ingredient");
        lblChooseIngredient.setBounds(66, 169, 121, 17);
        jPanelCreateComposite.add(lblChooseIngredient);

        textFieldCompositeName.setBounds(281, 99, 118, 20);
        jPanelCreateComposite.add(textFieldCompositeName);
        textFieldCompositeName.setColumns(10);

        JLabel lblByNowThe = new JLabel("By now, the new product consists of: ");
        lblByNowThe.setBounds(86, 257, 249, 21);
        jPanelCreateComposite.add(lblByNowThe);

        textAreaCompositeIngredients.setBounds(292, 257, 265, 154);
        jPanelCreateComposite.add(textAreaCompositeIngredients);

        JLabel lblIsTheNew = new JLabel("Is the new product ready?");
        lblIsTheNew.setBounds(226, 484, 173, 17);
        jPanelCreateComposite.add(lblIsTheNew);

        //edit composite product
        buttonEditCompositeFinish.setBounds(446, 482, 85, 21);
        jPanelEditComposite.add(buttonEditCompositeFinish);

        JLabel lblChooseProduct= new JLabel("Choose product");
        lblChooseProduct.setBounds(83, 40, 164, 17);
        jPanelEditComposite.add(lblChooseProduct);

        comboBoxCompositeSelectProduct.setBounds(250,40,207,23);
        jPanelEditComposite.add(comboBoxCompositeSelectProduct);

        comboBoxCompositeSelectToAdd.setBounds(250, 165, 207, 23);
        jPanelEditComposite.add(comboBoxCompositeSelectToAdd);

        buttonEditCompositeAddIngredient.setBounds(530, 165, 140, 21);
        jPanelEditComposite.add(buttonEditCompositeAddIngredient);

        JLabel lblChooseIngredientEdit = new JLabel("Choose new ingredient");
        lblChooseIngredientEdit.setBounds(40, 167, 180, 17);
        jPanelEditComposite.add(lblChooseIngredientEdit);

        JLabel lblIngredients = new JLabel("The product consists of: ");
        lblIngredients.setBounds(73, 302, 144, 21);
        jPanelEditComposite.add(lblIngredients);

        textAreaCompositeEdit.setBounds(224, 300, 265, 154);
        jPanelEditComposite.add(textAreaCompositeEdit);

        JLabel lblCheck = new JLabel("Is the product ready?");
        lblCheck.setBounds(226, 484, 173, 17);
        jPanelEditComposite.add(lblCheck);

        JLabel lblChooseNewName = new JLabel("Choose new name");
        lblChooseNewName.setBounds(123, 102, 106, 21);
        jPanelEditComposite.add(lblChooseNewName);

        textFieldEditCompositeName = new JTextField();
        textFieldEditCompositeName.setBounds(303, 103, 96, 19);
        jPanelEditComposite.add(textFieldEditCompositeName);
        textFieldEditCompositeName.setColumns(10);


        jTableAdministrator.setBounds(0,0,500,600);
        JScrollPane sp=new JScrollPane(jTableAdministrator);
        sp.setBounds(150,0,400,600);
        jPanelMenuItems.add(sp);

        jTabbedPane.add("Menu",jPanelMenuItems);
        jTabbedPane.add("Create Composite",jPanelCreateComposite);
        jTabbedPane.add("Create Base Product",jPanelCreateBase);
        jTabbedPane.add("Edit Composite Product",jPanelEditComposite);
        jTabbedPane.add("Edit Base Product",jPanelEditBase);
        jTabbedPane.add("Delete",jPanelDeleteProduct);

        frame.getContentPane().add(jTabbedPane);

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
        frame.setTitle("Administrator");
    }

    public void addCreateBaseListener(ActionListener action) {
        buttonCreateBase.addActionListener(action);
    }
    public void addDeleteListener(ActionListener action) {
        buttonDelete.addActionListener(action);
    }
    public void addChangeBaseListener(ActionListener action) {
        buttonChangeBase.addActionListener(action);
    }
    public void addCreateCompositeListener(ActionListener action) {
        buttonCreateComposite.addActionListener(action);
    }
    public void addCreateCompositeAddIngredientListener(ActionListener action) {
        buttonCreateCompositeAddIngredient.addActionListener(action);
    }
    public void addEditCompositeAddIngredientListener(ActionListener action){
        buttonEditCompositeAddIngredient.addActionListener(action);
    }
    public void addEditCompositeFinish(ActionListener action){
        buttonEditCompositeFinish.addActionListener(action);
    }
    public String getTextCreateBaseName(){
        return textFieldCreateBaseName.getText();
    }
    public String getTextCreateBasePrice(){
        return textFieldCreateBasePrice.getText();
    }
    public void setTextCreateBaseName(String s){
        textFieldCreateBaseName.setText(s);
    }
    public void setTextCreateBasePrice(String s){
         textFieldCreateBasePrice.setText(s);
    }
    public JComboBox getComboBoxDelete(){
        return this.comboBoxDelete;
    }
    public JComboBox getComboBoxComposite(){
        return this.comboBoxComposite;
    }
    public JComboBox getComboBoxCompositeSelectToAdd() {
        return comboBoxCompositeSelectToAdd;
    }
    public JComboBox getComboBoxEditBase() {
        return comboBoxEditBase;
    }
    public JComboBox getComboBoxCompositeSelectProduct(){return comboBoxCompositeSelectProduct;}
    public String getTextCompositeName() {
        return textFieldCompositeName.getText();
    }
    public void setTextAreaCompositeIngredients(String s){
        textAreaCompositeIngredients.setText(s);
    }
    public String getTextAreaCompositeIngredients(){
        return textAreaCompositeIngredients.getText()+" ";
    }
    public void setTextCreateCompositeName(String s){
        textFieldCompositeName.setText(s);
    }
    public String getTextEditBaseName(){
        return this.jTextFieldChangeBaseName.getText();
    }
    public void setTextEditBaseName(String s){
        this.jTextFieldChangeBaseName.setText(s);
    }
    public String getTextEditBasePrice(){
        return this.jTextFieldChangeBasePrice.getText();
    }
    public void setTextEditBasePrice(String s){
        this.jTextFieldChangeBasePrice.setText(s);
    }
    public String getTextFieldCompositeName(){
        return this.textFieldCompositeName.getText();
    }
    public void setTextFieldCompositeName(String s){
        this.textFieldCompositeName.setText(s);
    }
    public void setTextAreaCompositeEdit(String s){
        this.textAreaCompositeEdit.setText(s);
    }
    public String getTextAreaCompositeEdit(){
        return this.textAreaCompositeEdit.getText()+" ";
    }
    public void setTextFieldEditCompositeName(String s){
        textFieldEditCompositeName.setText(s);
    }
    public String getTextFieldEditCompositeName(){
        return this.textFieldEditCompositeName.getText();
    }
    public void setJTableAdministrator(JTable table){
        this.jTableAdministrator=table;
    }
    public JTable getJTableAdministrator(){
        return jTableAdministrator;
    }
}
