package data;

import business.MenuItem;
import java.io.*;
import java.util.ArrayList;

public class FileWriter {
    public static void writeMenu(ArrayList<MenuItem> menu,String fileName){
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(".//"+fileName);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeInt(menu.size());
            for(MenuItem menuItem: menu)
                objectOutputStream.writeObject(menuItem);
            objectOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
