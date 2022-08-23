/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.ijse.inventory.bo.custom.impl;

import lk.ijse.inventory.bo.custom.PurchaseOrderBO;
import lk.ijse.inventory.dao.DAOFactory;
import lk.ijse.inventory.dao.custom.CustomerDAO;
import lk.ijse.inventory.dao.custom.ItemDAO;
import lk.ijse.inventory.dao.custom.OrderDAO;
import lk.ijse.inventory.dao.custom.OrderDetailsDAO;
import lk.ijse.inventory.db.DBConnection;
import lk.ijse.inventory.dto.CustomerDTO;
import lk.ijse.inventory.dto.ItemDTO;
import lk.ijse.inventory.dto.OrderDTO;
import lk.ijse.inventory.dto.OrderDetailDTO;
import lk.ijse.inventory.entity.Customer;
import lk.ijse.inventory.entity.Item;
import lk.ijse.inventory.entity.Order;
import lk.ijse.inventory.entity.OrderDetail;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Tharaka Dasunpriya
 */
public class PurchaseOrderBOImpl implements PurchaseOrderBO{
    CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.CUSTOMER);
    ItemDAO itemDAO = (ItemDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ITEM);
    OrderDAO orderDAO = (OrderDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ORDERS);
    OrderDetailsDAO orderDetailsDAO = (OrderDetailsDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ORDERDETAILS);
   

    @Override
    public ArrayList<CustomerDTO> getAllCustomer() throws SQLException, ClassNotFoundException {
     ArrayList<Customer> all =  customerDAO.getAll();
     ArrayList<CustomerDTO> allCustomers = new ArrayList<>();
     for (Customer c : all) {
            CustomerDTO customerDTO = new CustomerDTO(c.getId(), c.getName(), c.getAddress(), c.getSalary());
            allCustomers.add(customerDTO);
        }
        return allCustomers;
    }

    @Override
    public ArrayList<ItemDTO> getAllItem() throws SQLException, ClassNotFoundException {
     ArrayList<Item> all = itemDAO.getAll();
        ArrayList<ItemDTO> allItems = new ArrayList<>();
        for (Item i : all) {
            ItemDTO itemDTO = new ItemDTO(i.getItemCode(), i.getItemName(), i.getQty(), i.getUnitPrice());
            allItems.add(itemDTO);
        }
        return allItems;
    }

    @Override
    public CustomerDTO searchCustomer(String id) throws ClassNotFoundException, SQLException{
       Customer c = customerDAO.search(id);
       return new CustomerDTO(c.getId(),c.getName(),c.getAddress(),c.getSalary());
       
    }

    @Override
    public ItemDTO searchItem(String id) throws SQLException, ClassNotFoundException {
        Item i = itemDAO.search(id);
        return new ItemDTO(i.getItemCode(),i.getItemName(),i.getQty(),i.getUnitPrice());
    }

    @Override
    public boolean purcaseOrder(OrderDTO dto) throws SQLException,ClassNotFoundException{
        Connection connection = DBConnection.getDBConnection().getConnection();
        connection.setAutoCommit(false);

        Order order = new Order(dto.getOid(),dto.getDate(),dto.getCustomerID());
        
        boolean add = orderDAO.add(order);
        if (add) {
            for (OrderDetailDTO od : dto.getOrderDetails()) {
                OrderDetail orderDetail = new OrderDetail(od.getOid(),od.getItemCode(),od.getQty(),od.getUnitPrice());
                boolean add1 = orderDetailsDAO.add(orderDetail);
                if (!add1) {
                    connection.rollback();
                    connection.setAutoCommit(true);
                    return false;

                }
            }
            connection.commit();
            connection.setAutoCommit(true);
            return true;
        }
        connection.rollback();
        connection.setAutoCommit(true);
        return false;
    }

    @Override
    public void getOrderDetailsForOID(String oid) {
        
    }
    
    
}
