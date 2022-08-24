/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.inventory.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import lk.ijse.inventory.bo.BOFactory;
import lk.ijse.inventory.bo.custom.PurchaseOrderBO;
import lk.ijse.inventory.dto.CustomerDTO;
import lk.ijse.inventory.dto.ItemDTO;
import lk.ijse.inventory.dto.OrderDTO;
import lk.ijse.inventory.dto.OrderDetailDTO;


public class OrderFormController {

    PurchaseOrderBO bo = (PurchaseOrderBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.PURCHASEORDER);

    public ArrayList<CustomerDTO> getAllCustomers() throws SQLException, ClassNotFoundException {

        return bo.getAllCustomers();
    }

    public ArrayList<ItemDTO> getAllItems() throws SQLException, ClassNotFoundException {
        return bo.getAllItems();
    }

    public CustomerDTO searchCustomer(String id) throws SQLException, ClassNotFoundException {
        return bo.searchCustomer(id);
    }
    
     public OrderDTO searchOrder(String id) throws SQLException, ClassNotFoundException {
        return bo.searchOrder(id);
    }
    
    

    public ItemDTO searchItem(String code) throws SQLException, ClassNotFoundException {
        return bo.searchItem(code);
    }

    public boolean purchaseOrder(OrderDTO dto) throws ClassNotFoundException, SQLException {
        return bo.purchaseOrder(dto);

    }
    
    
//    public OrderDTO getAllOrdersbycusCode(String CustID) throws SQLException, ClassNotFoundException {
//        return bo.getAllOrdersbyCustID(CustID);
//    }
 
    public ArrayList<OrderDTO> getAllOrdersbycusCode(String CustID) throws SQLException, ClassNotFoundException {
        return bo.getAllOrdersbyCustID(CustID);
    }

    public ArrayList<OrderDetailDTO> getAllItemsbyorderID(String orderID) throws SQLException, ClassNotFoundException {
        return bo.getAllItemDetailbyOrderID(orderID);
    }

   
    public void getOrderDetailsForOID(String oid){
    
    }

}
