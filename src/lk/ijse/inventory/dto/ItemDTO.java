/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.ijse.inventory.dto;

/**
 *
 * @author Tharaka Dasunpriya
 */
public class ItemDTO {
    private String itemCode;
    private String itemName;
    private Integer qty;
    private double unitPrice;

    public ItemDTO() {
    }

    public ItemDTO(String itemCode, String itemName, Integer qty, double unitPrice) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.qty = qty;
        this.unitPrice = unitPrice;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }
    
    
            
    
}
