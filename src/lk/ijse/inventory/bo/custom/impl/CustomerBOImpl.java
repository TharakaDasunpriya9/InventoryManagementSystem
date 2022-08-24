/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.inventory.bo.custom.impl;

import lk.ijse.inventory.bo.custom.CustomerBO;
import lk.ijse.inventory.dao.DAOFactory;
import lk.ijse.inventory.dao.custom.CustomerDAO;
import lk.ijse.inventory.dto.CustomerDTO;
import java.sql.SQLException;
import java.util.ArrayList;
import lk.ijse.inventory.entity.Customer;


public class CustomerBOImpl implements CustomerBO {

    CustomerDAO dao = (CustomerDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.CUSTOMER);

    @Override
    public boolean addCustomer(CustomerDTO dto) throws ClassNotFoundException, SQLException {
        return dao.add(new Customer(dto.getCustomerID(), dto.getCustomerName(), dto.getCustomerAddress(), dto.getCustomerSalary()));
    }

    @Override
    public boolean updateCustomer(CustomerDTO dto) throws ClassNotFoundException, SQLException {

        return dao.update(new Customer(dto.getCustomerID(), dto.getCustomerName(), dto.getCustomerAddress(), dto.getCustomerSalary()));
    }

    @Override
    public boolean removeCustomer(String customerID) throws ClassNotFoundException, SQLException {
        return dao.delete(customerID);
    }

    @Override
    public CustomerDTO searchCustomer(String customerID) throws ClassNotFoundException, SQLException {
        Customer ent = dao.search(customerID);
        return new CustomerDTO(ent.getId(), ent.getName(), ent.getAddress(), ent.getSalary());
    }

    @Override
    public ArrayList<CustomerDTO> getAllCustomers() throws ClassNotFoundException, SQLException {
        ArrayList<Customer> all = dao.getAll();
        ArrayList<CustomerDTO> allCustomers = new ArrayList<>();
        for (Customer c : all) {
            allCustomers.add(new CustomerDTO(c.getId(), c.getName(), c.getAddress(), c.getSalary()));
        }
        return allCustomers;
    }

}
