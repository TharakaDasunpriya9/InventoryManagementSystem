/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.inventory.bo.custom;

import lk.ijse.inventory.bo.SuperBO;
import lk.ijse.inventory.dto.CustomerDTO;
import lk.ijse.inventory.dto.ItemDTO;
import lk.ijse.inventory.dto.OrderDTO;
import lk.ijse.inventory.dto.OrderDetailDTO;
import java.sql.SQLException;
import java.util.ArrayList;

 public interface PurchaseOrderBO extends SuperBO{

    public ArrayList<CustomerDTO> getAllCustomers() throws SQLException, ClassNotFoundException;

    public ArrayList<ItemDTO> getAllItems() throws SQLException, ClassNotFoundException;
    
//    public OrderDTO getAllOrdersbyCustID(String custCode) throws SQLException, ClassNotFoundException;
    public ArrayList<OrderDTO> getAllOrdersbyCustID(String custCode) throws SQLException, ClassNotFoundException;

    public ArrayList<OrderDetailDTO> getAllItemDetailbyOrderID(String orderId) throws SQLException, ClassNotFoundException;

    public CustomerDTO searchCustomer(String id) throws SQLException, ClassNotFoundException;

    public ItemDTO searchItem(String code) throws SQLException, ClassNotFoundException;
    
    public OrderDTO searchOrder(String oid) throws SQLException, ClassNotFoundException;

    public boolean purchaseOrder(OrderDTO order) throws ClassNotFoundException, SQLException;
    
    public void getOrderDetailsForOID(String oid)throws ClassNotFoundException, SQLException;
}
