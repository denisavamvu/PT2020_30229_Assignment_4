package business;

import java.util.ArrayList;

public class CompositeProduct extends MenuItem{
    private ArrayList<MenuItem> compositions;

    public CompositeProduct(String name) {
       super(name);
       compositions = new ArrayList<MenuItem>();
    }
    public void addItem(MenuItem menuItem){
        this.compositions.add(menuItem);
        this.setPrice(this.getPrice()+menuItem.getPrice());
    }

    public ArrayList<MenuItem> getCompositions() {
        return compositions;
    }
}
