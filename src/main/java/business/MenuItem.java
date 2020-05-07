package business;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class MenuItem implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private int price;

    public MenuItem(String name){
        this.name=name;
        this.price=0;
    }

    public MenuItem(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

}
