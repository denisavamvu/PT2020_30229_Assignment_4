package business;

import java.util.ArrayList;

public interface IRestaurantProcessing {
    /**
     * create and insert a base product into the menu
     * @pre name!=null && price>0
     * @param price integer representing product's price
     * @param name string representing product's name
     * @post getSize()==getSize()@pre+1
     */
    public void createMenuItem(int price, String name);

    /**
     * create and insert a composite product into the menu
     * @pre name!=null && items.size()!=0
     * @param name string representing product's name
     * @param items list of menu items that compose the new product
     * @post getSize()==getSize()@pre+1
     */
    public void createMenuItem(String name, ArrayList<MenuItem> items);

    /**
     * edit an existing base product
     * @pre oldName!=null && newName!=null && newPrice>0
     * @param oldName product's old name
     * @param newName product's new name
     * @param newPrice product's new price
     * @post getSize()==getSize()@pre
     */
    public void editMenuItem(String oldName,String newName, int newPrice);
    /**
     * edit an existing composite product
     * @pre oldName!=null && name!=null &&items.size()!=0
     * @param oldName product's old name
     * @param name product's new name
     * @param items new list of ingredients
     * @post getSize()==getSize()@pre
     */
    public void editMenuItem(String oldName,String name,ArrayList<MenuItem> items);

    /**
     * delete a product with a given name
     * @pre name!=null
     * @param name name of product to be deleted
     * @post getSize()==getSize()@pre-1
     */
    public void deleteMenuItem(String name);

    /**
     * create ar order for a table represented by a number, containing a list of products from the menu
     * @pre table>0 && items.size()!=0
     * @param table table number
     * @param items list of menu items representing the order
     * @post getSize()==getSize()@pre+1
     */
    public void createOrder(int table, ArrayList<MenuItem> items);

    /**
     * compute price for an order from a table
     * @pre table>0
     * @param table table number
     * @return an integer representing the price as the sum of all the products from the order associated to the table
     * @post price>0
     */
    public int computePrice(int table);

    /**
     * generate a bill for a table in a .txt format
     * @pre table>0
     * @param table table number
     * @post getSize()==getSize()@pre
     */
    public void generateBill(int table);
}
