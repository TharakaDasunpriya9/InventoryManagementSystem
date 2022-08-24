/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.inventory.bo.custom.impl;

import lk.ijse.inventory.bo.custom.PurchaseOrderBO;
import lk.ijse.inventory.dao.DAOFactory;
import lk.ijse.inventory.dao.custom.CustomerDAO;
import lk.ijse.inventory.dao.custom.ItemDAO;
import lk.ijse.inventory.dao.custom.OrderDAO;
import lk.ijse.inventory.dao.custom.OrderDetailsDAO;
import lk.ijse.inventory.dao.custom.QueryDAO;
import lk.ijse.inventory.db.DBConnection;
import lk.ijse.inventory.dto.CustomerDTO;
import lk.ijse.inventory.dto.ItemDTO;
import lk.ijse.inventory.dto.OrderDTO;
import lk.ijse.inventory.dto.OrderDetailDTO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import lk.ijse.inventory.entity.Customer;
import lk.ijse.inventory.entity.Item;
import lk.ijse.inventory.entity.Order;
import lk.ijse.inventory.entity.OrderDetail;


public class PurchaseOrderBOImpl implements PurchaseOrderBO {

    CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.CUSTOMER);
    ItemDAO itemDAO = (ItemDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ITEM);
    OrderDAO orderDAO = (OrderDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ORDERS);
    OrderDetailsDAO orderDetailsDAO = (OrderDetailsDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ORDERDETAILS);
    QueryDAO queryDao = (QueryDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.QUERYDAO);

    @Override
    public ArrayList<CustomerDTO> getAllCustomers() throws SQLException, ClassNotFoundException {
        ArrayList<Customer> all = customerDAO.getAll();
        ArrayList<CustomerDTO> allCustomers = new ArrayList<>();
        for (Customer c : all) {
            CustomerDTO customerDTO = new CustomerDTO(c.getId(), c.getName(), c.getAddress(), c.getSalary());
            allCustomers.add(customerDTO);
        }
        return allCustomers;
    }

    @Override
    public ArrayList<ItemDTO> getAllItems() throws SQLException, ClassNotFoundException {
        ArrayList<Item> all = itemDAO.getAll();
        ArrayList<ItemDTO> allItems = new ArrayList<>();
        for (Item i : all) {
            ItemDTO itemDTO = new ItemDTO(i.getCode(), i.getDescription(), i.getQtyOnHand(), i.getUnitPrice());
            allItems.add(itemDTO);
        }
        return allItems;
    }

    @Override
    public CustomerDTO searchCustomer(String id) throws SQLException, ClassNotFoundException {
        Customer c = customerDAO.search(id);
        return new CustomerDTO(c.getId(), c.getName(), c.getAddress(), c.getSalary());
    }

    @Override
    public ItemDTO searchItem(String code) throws SQLException, ClassNotFoundException {
        Item i = itemDAO.search(code);
        return new ItemDTO(i.getCode(), i.getDescription(), i.getQtyOnHand(), i.getUnitPrice());
    }

    @Override
    public boolean purchaseOrder(OrderDTO dto) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getDBConnection().getConnection();
        connection.setAutoCommit(false);

        Order order = new Order(dto.getOid(), dto.getDate(), dto.getCustomerID());
        
        boolean add = orderDAO.add(order);
        if (add) {
            for (OrderDetailDTO od : dto.getOrderDetails()) {
                OrderDetail orderDetail = new OrderDetail(od.getOid(), od.getItemCode(), od.getQty(), od.getUnitPrice());
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
    public void getOrderDetailsForOID(String oid) throws ClassNotFoundException, SQLException {
        queryDao.getCustomersOrderDetails(oid);
    }

    @Override
    public OrderDTO searchOrder(String oid) throws SQLException, ClassNotFoundException {
         Order o = orderDAO.search(oid);
        return new OrderDTO(o.getOid(), o.getDate(), o.getCustomerID());
    }
    
//    @Override
//    public OrderDTO getAllOrdersbyCustID(String custID)throws SQLException, ClassNotFoundException {
//         Order o = orderDAO.getAllbyID(custID);
//        return new OrderDTO(o.getOid(), o.getDate(), o.getCustomerID());
//    }
    
     @Override
    public ArrayList<OrderDTO> getAllOrdersbyCustID(String custID)throws SQLException, ClassNotFoundException {
         ArrayList<Order> all = orderDAO.getAllbyID(custID);
        ArrayList<OrderDTO> allOrdersbycustID = new ArrayList<>();
        for (Order c : all) {
            OrderDTO orderDTO = new OrderDTO(c.getOid(), c.getDate(), c.getCustomerID());
            allOrdersbycustID.add(orderDTO);
        }
        return allOrdersbycustID;
    }

    @Override
    public ArrayList<OrderDetailDTO> getAllItemDetailbyOrderID(String orderId) throws SQLException, ClassNotFoundException {
        ArrayList<OrderDetail> allorderdDetails = orderDetailsDAO.getAllbyID(orderId);
        ArrayList<OrderDetailDTO> allItemsbyorderID = new ArrayList<>();
        for (OrderDetail c : allorderdDetails) {
            OrderDetailDTO orderdetailDTO = new OrderDetailDTO(c.getOid(), c.getItemCode(), c.getQty(),c.getUnitPrice());
            allItemsbyorderID.add(orderdetailDTO);
        }
        return allItemsbyorderID;
      
    }

      
}

