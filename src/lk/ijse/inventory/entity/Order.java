/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.ijse.inventory.entity;

/**
 *
 * @author Tharaka Dasunpriya
 */
public class Order {
    private String oid;
    private String date;
    private String customerID;

    public Order() {
    }

    public Order(String oid, String date, String customerID) {
        this.oid = oid;
        this.date = date;
        this.customerID = customerID;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }
    
    
}
