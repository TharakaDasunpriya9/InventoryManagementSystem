/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package lk.ijse.inventory.bo.custom;
import lk.ijse.inventory.bo.SuperBO;
import lk.ijse.inventory.dto.CustomerDTO;
import lk.ijse.inventory.dto.ItemDTO;
import lk.ijse.inventory.dto.OrderDTO;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Tharaka Dasunpriya
 */
public interface PurchaseOrderBO extends SuperBO {
    
    public ArrayList<CustomerDTO> getAllCustomer()throws SQLException,ClassNotFoundException;
    public ArrayList<ItemDTO> getAllItem()throws SQLException,ClassNotFoundException;
    public CustomerDTO searchCustomer(String id)throws SQLException,ClassNotFoundException;
    public ItemDTO searchItem(String id)throws SQLException,ClassNotFoundException;
    public boolean purcaseOrder(OrderDTO order)throws SQLException,ClassNotFoundException;
    public void getOrderDetailsForOID(String oid)throws SQLException,ClassNotFoundException;
   
}
