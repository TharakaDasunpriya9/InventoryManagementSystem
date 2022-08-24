/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.inventory.dao.custom.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import lk.ijse.inventory.dao.CrudUtil;
import lk.ijse.inventory.dao.custom.OrderDAO;
import lk.ijse.inventory.entity.Order;

public class OrderDAOImpl implements OrderDAO {

    @Override
    public boolean add(Order enty) throws ClassNotFoundException, SQLException {
        return CrudUtil.executeUpdate("insert into Orders values(?,?,?)", enty.getOid(), enty.getDate(), enty.getCustomerID());
    }

    @Override
    public boolean delete(String id) throws ClassNotFoundException, SQLException {
        return CrudUtil.executeUpdate("delete from Orders where oid=?", id);
    }

    @Override
    public boolean update(Order enty) throws SQLException, ClassNotFoundException {
        return CrudUtil.executeUpdate("Update Orders set date=?,customerID=? where oid=?", enty.getDate(), enty.getCustomerID(), enty.getOid());
    }

    @Override
    public Order search(String id) throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.executeQuery("select * from Orders where oid=?", id);
        if (rst.next()) {
            String oid = rst.getString(1);
            String date = rst.getString(2);
            String customerID = rst.getString(3);
            return new Order(oid, date, customerID);
        }
        return null;
    }

    @Override
    public ArrayList<Order> getAll() throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.executeQuery("select * from Orders");
        ArrayList<Order> allOrders = new ArrayList<>();
        while (rst.next()) {
            String oid = rst.getString(1);
            String date = rst.getString(2);
            String customerID = rst.getString(3);

            Order order = new Order(oid, date, customerID);
            allOrders.add(order);

        }
        return allOrders;
    }

    @Override
    public ArrayList<Order> getAllbyID(String id) throws SQLException, ClassNotFoundException {
      ResultSet rst = CrudUtil.executeQuery("select * from Orders where customerID=?", id);
         ArrayList<Order> allOrders = new ArrayList<>();
        while (rst.next()) {
            String oid = rst.getString(1);
            String date = rst.getString(2);
            String customerID = rst.getString(3);

            Order order = new Order(oid, date, customerID);
            allOrders.add(order);

        }
        return allOrders;
    }
   

}
