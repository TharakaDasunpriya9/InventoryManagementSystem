/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.inventory.bo.custom;

import lk.ijse.inventory.bo.SuperBO;
import lk.ijse.inventory.dto.CustomerDTO;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Tharaka Dasunpriya
 */
public interface CustomerBO extends SuperBO{
    public boolean addCustomer(CustomerDTO customer) throws ClassNotFoundException, SQLException;
    public boolean updateCustomer(CustomerDTO customer) throws ClassNotFoundException, SQLException;
    public boolean removeCustomer(String customerID) throws ClassNotFoundException, SQLException;
    public CustomerDTO searchCustomer(String customerID) throws ClassNotFoundException, SQLException;
    public ArrayList<CustomerDTO> getAllCustomers() throws ClassNotFoundException, SQLException ;
}
