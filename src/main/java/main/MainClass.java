package main;

import presentation.controller.Controller;
import presentation.view.FrontGUI;

public class MainClass {
    public static void main(String []args){
        String fileName;
        if(args.length>0)
            fileName=args[0];
        else
            fileName="restaurant.ser";
        FrontGUI f=new FrontGUI();
        Controller controller= new Controller(f,fileName);
    }

}
