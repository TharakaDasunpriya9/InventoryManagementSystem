/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.inventory.controller;


import java.sql.SQLException;
import java.util.ArrayList;

import lk.ijse.inventory.bo.BOFactory;
import lk.ijse.inventory.bo.custom.CustomerBO;
import lk.ijse.inventory.dto.CustomerDTO;


public class CustomerFormController {

    CustomerBO bo = (CustomerBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.CUSTOMER);

    public boolean addCustomer(CustomerDTO customer) throws ClassNotFoundException, SQLException {
        return bo.addCustomer(customer);
    }

    public boolean updateCustomer(CustomerDTO customer) throws ClassNotFoundException, SQLException {
        return bo.updateCustomer(customer);
    }

    public boolean removeCustomer(String customerID) throws ClassNotFoundException, SQLException {
        return bo.removeCustomer(customerID);
    }

    public CustomerDTO searchCustomer(String customerID) throws ClassNotFoundException, SQLException {
        return bo.searchCustomer(customerID);
    }

    public ArrayList<CustomerDTO> getAllCustomers() throws ClassNotFoundException, SQLException {
        return bo.getAllCustomers();
    }

}
