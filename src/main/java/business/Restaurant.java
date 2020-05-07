package business;

import data.RestaurantSerializator;

import java.io.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Restaurant extends Observable implements IRestaurantProcessing{
    private HashMap<Order,ArrayList<MenuItem>> orderedItems=new HashMap<Order,ArrayList<MenuItem>>();
    /**
     * @invariant isWellFormed()
     */
    private ArrayList<MenuItem> menu;
    private ArrayList<Order> orders;
    private String fileName;
    private Observer observer;

    /**
     * constructor for restaurant
     * @param fileName name of the file where the menu is stored
     */
    public Restaurant(String fileName){
        this.fileName=fileName;
        menu=new ArrayList<MenuItem>();
        orders= new ArrayList<Order>();
        menu=RestaurantSerializator.readMenu(fileName);

    }
    public void setObserver(Observer observer){
        this.observer=observer;
    }
    public HashMap<Order, ArrayList<MenuItem>> getOrderedItems() {
        return orderedItems;
    }
    public ArrayList<MenuItem> getMenu() {
        return menu;
    }
    public ArrayList<Order> getOrders() {
        return orders;
    }

    /**
     * notify the chef that he has to cook, when an order is placed
     * @param o the restaurant
     * @param order order that has to be prepared by the chef
     */
    public void notifyObserver(Observable o, ArrayList<MenuItem> order){
        observer.update(o,order);
    }

    @Override
    public void createMenuItem(int price, String name) {
        int size=menu.size();
        System.out.println(price);
        assert price>0&&name!=null:"invalid input";
        assert isWellFormed():"is not well formed";

        BaseProduct baseProduct = new BaseProduct(name, price);
        menu.add(baseProduct);

        assert menu.size()==size+1:"error while inserting";
        assert isWellFormed():"is not well formed";

    }

    @Override
    public void createMenuItem(String name, ArrayList<MenuItem> items) {
        int size=menu.size();
        assert name!=null&&items.size()!=0:"invalid input";
        assert isWellFormed():"is not well formed";

        ArrayList<MenuItem> itemsAux=new ArrayList<MenuItem>();
        for(MenuItem menuItem: items){
            MenuItem men=menuItem;
            itemsAux.add(men);
        }

        CompositeProduct compositeProduct= new CompositeProduct(name);
        for(MenuItem menuItem: itemsAux){
            compositeProduct.addItem(menuItem);
        }
        menu.add(compositeProduct);

        assert menu.size()==size+1:"error while inserting";
        assert isWellFormed():"is not well formed";
    }

    @Override
    public void editMenuItem(String oldName,String newName, int newPrice) {
        int size=menu.size();
        assert oldName!=null&&newName!=null&&newPrice>0:"invalid input";
        assert isWellFormed():"is not well formed";

        for(MenuItem menuItem: menu)
            if(menuItem.getName().equals(oldName)) {
                menuItem.setName(newName);
                menuItem.setPrice(newPrice);
            }

        assert menu.size()==size:"invalid edit";
        assert isWellFormed():"is not well formed";
    }
    @Override
    public void editMenuItem(String oldName,String newName,ArrayList<MenuItem> items) {
        int size=menu.size();
        assert oldName!=null&&newName!=null&&items.size()!=0:"invalid input";
        assert isWellFormed():"is not well formed";

        ArrayList<MenuItem> itemsAux=new ArrayList<MenuItem>();
        for(MenuItem menuItem: items){
            MenuItem men=menuItem;
            itemsAux.add(men);
        }

        for(MenuItem menuItem: menu)
            if(menuItem.getName().equals(oldName)) {
                CompositeProduct comp=(CompositeProduct)menuItem;
                comp.setName(newName);
                comp.getCompositions().removeAll(comp.getCompositions());
                comp.setPrice(0);
                for(MenuItem men: itemsAux){
                    comp.addItem(men);
                }
            }

        assert menu.size()==size:"invalid edit";
        assert isWellFormed():"is not well formed";
    }
    @Override
    public void deleteMenuItem(String name) {
        int size=menu.size();
        assert name!=null:"invalid input";
        assert isWellFormed():"is not well formed";

        Iterator<MenuItem> m=menu.iterator();
        ArrayList<MenuItem> toDelete=new ArrayList<MenuItem>();
        MenuItem menuItemAux=null;
        while(m.hasNext()){
            MenuItem menuItem=m.next();
            if(menuItem instanceof CompositeProduct)
            {
                CompositeProduct aux=(CompositeProduct)menuItem;
                if(menuItem.getName().equals(name))
                    menuItemAux=menuItem;
                for(MenuItem menItem: aux.getCompositions())
                    if(menItem.getName().equals(name))
                    {
                        toDelete.add(menuItem);
                    }
            }
            else {
                if(menuItem.getName().equals(name))
                    menuItemAux=menuItem;
            }
        }
        for(MenuItem aux: toDelete)
        {
            deleteMenuItem(aux.getName());
            size--;
        }
        menu.remove(menuItemAux);
        size--;

        assert menu.size()==size:"invalid delete";
        assert isWellFormed():"is not well formed";
    }

    @Override
    public void createOrder(int table, ArrayList<MenuItem> items) {
        int size=orders.size();
        assert table>0&&items.size()>0:"invalid input";
        assert isWellFormed():"is not well formed";

        Date date = new Date(System.currentTimeMillis());
        Order order = new Order(orders.size(),date,table);
        orders.add(order);

        ArrayList<MenuItem> itemsAux=new ArrayList<MenuItem>();
        for(MenuItem menuItem: items){
            MenuItem men=menuItem;
            itemsAux.add(men);
        }
        orderedItems.put(order,itemsAux);
        try{
            notifyObserver(this,itemsAux);
        }
        catch(Exception e){
            System.out.println("Please open chef window");
        }

        assert orders.size()==size+1:"error while inserting order";
        assert isWellFormed():"is not well formed";
    }

    @Override
    public int computePrice(int table) {
        assert table>0:"invalid input";
        assert isWellFormed():"is not well formed";

        int price=0;
        for(Order o: this.getOrders())
            if(o.getTable()==table){
                ArrayList <MenuItem> ordered=orderedItems.get(o);
                for(MenuItem menuItem: ordered)
                    price+=menuItem.getPrice();
            }
        assert price>0:"invalid price";
        assert isWellFormed():"is not well formed";

        return price;
    }

    @Override
    public void generateBill(int table) {
        int price=0;
        int size=orders.size();
        assert table>0:"invalid input";
        assert isWellFormed():"is not well formed";

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH a");
        LocalDateTime now = LocalDateTime.now();
        String data=(String)dtf.format(now);
        String filename="Bill table "+table+" "+data+" "+".txt";

        Date orderDate=new Date();
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(filename, "UTF-8");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        writer.println("Ordered products:");
        for(Order o: this.getOrders())
            if(o.getTable()==table){
                ArrayList <MenuItem> ordered=orderedItems.get(o);
                orderDate=o.getDate();
                for(MenuItem menuItem: ordered)
                {
                    writer.println("Product: "+menuItem.getName()+" price:"+menuItem.getPrice());
                    price+=menuItem.getPrice();
                }
            }
        writer.println("--------------------------------------");
            writer.println("Total: "+price);
            writer.println("Date: "+orderDate);
            writer.println("Table: "+table);
        writer.close();

        assert orders.size()==size:"error generating bill";
        assert isWellFormed():"is not well formed";
    }

    /**
     * check validity for menu (class invariant)
     * @return true if menu is valid, else false
     */
    protected boolean isWellFormed(){
        if(menu==null)
            return false;
        return true;
    }
}
