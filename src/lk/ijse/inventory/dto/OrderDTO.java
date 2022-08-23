/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.ijse.inventory.dto;

import java.util.ArrayList;

/**
 *
 * @author Tharaka Dasunpriya
 */
public class OrderDTO {
    private String oid;
    private String date;
    private String CustomerID;
    private ArrayList<OrderDetailDTO> orderDetails = new ArrayList<>();

    public OrderDTO() {
    }
    
    

    public OrderDTO(String oid, String date, String CustomerID) {
        this.oid = oid;
        this.date = date;
        this.CustomerID = CustomerID;
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
        return CustomerID;
    }

    public void setCustomerID(String CustomerID) {
        this.CustomerID = CustomerID;
    }

    public ArrayList<OrderDetailDTO> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(ArrayList<OrderDetailDTO> orderDetails) {
        this.orderDetails = orderDetails;
    }
    
    
    
    
}
