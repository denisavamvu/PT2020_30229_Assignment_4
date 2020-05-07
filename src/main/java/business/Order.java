package business;

import java.util.Date;
import java.util.Objects;

public class Order  {
    private int orderID;
    private Date date;
    private int table;

    public Order(int orderID, Date date, int table) {
        this.orderID = orderID;
        this.date = date;
        this.table = table;
    }

    public int hashCode() {
        return Objects.hash(this.date, this.table, this.orderID);
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setTable(int table) {
        this.table = table;
    }

    public int getOrderID() {
        return orderID;
    }

    public Date getDate() {
        return date;
    }

    public int getTable() {
        return table;
    }
}
