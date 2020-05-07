package data;

import business.MenuItem;
import business.Order;

import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.HashMap;

public class RestaurantSerializator {
    public static ArrayList<MenuItem> readMenu(String fileName){
        ArrayList<MenuItem> menu= new ArrayList<MenuItem>();
        try {
            FileInputStream fileInputStream = new FileInputStream(".//"+fileName);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            int size=objectInputStream.readInt();
            for(int i=0;i<size;i++){
                menu.add((MenuItem)objectInputStream.readObject());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return menu;
    }
}
