/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.ijse.inventory.controller;

import lk.ijse.inventory.bo.BOFactory;
import lk.ijse.inventory.bo.custom.PurchaseOrderBO;
import lk.ijse.inventory.dto.CustomerDTO;
import lk.ijse.inventory.dto.ItemDTO;
import lk.ijse.inventory.dto.OrderDTO;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Tharaka Dasunpriya
 */
public class OrderFormController {
     PurchaseOrderBO bo = (PurchaseOrderBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.PURCHASEORDER);

    public ArrayList<CustomerDTO> getAllCustomers() throws SQLException, ClassNotFoundException {

        return bo.getAllCustomer();
    }

    public ArrayList<ItemDTO> getAllItems() throws SQLException, ClassNotFoundException {
        return bo.getAllItem();
    }

    public CustomerDTO searchCustomer(String id) throws SQLException, ClassNotFoundException {
        return bo.searchCustomer(id);
    }

    public ItemDTO searchItem(String code) throws SQLException, ClassNotFoundException {
        return bo.searchItem(code);
    }

    public boolean purchaseOrder(OrderDTO dto) throws ClassNotFoundException, SQLException {
        return bo.purcaseOrder(dto);
    }
       
    public void getOrderDetailsForOID(String oid){
    
    }

    
}
