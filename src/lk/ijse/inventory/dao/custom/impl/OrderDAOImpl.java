/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.ijse.inventory.dao.custom.impl;
import lk.ijse.inventory.dao.CrudUtil;
import lk.ijse.inventory.dao.custom.OrderDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import lk.ijse.inventory.entity.Order;

/**
 *
 * @author Tharaka Dasunpriya
 */
public class OrderDAOImpl implements OrderDAO{

    @Override
    public boolean add(Order enty) throws ClassNotFoundException, SQLException {
        return CrudUtil.executeUpdate("insert into orders values(?,?,?)", enty.getOid(),enty.getDate(),enty.getCustomerID());
//        CrudUtil thma Main CRUD thiyenne ekata adala queery eka ywananna thiyenne

    }

    @Override
    public boolean delete(String id) throws ClassNotFoundException, SQLException {
       return CrudUtil.executeUpdate("delete from orders where oid=?",id);
    }

    @Override
    public boolean update(Order enty) throws SQLException, ClassNotFoundException {
       return CrudUtil.executeUpdate("update orders set date=?,customerID=? where oid=?",enty.getDate(),enty.getCustomerID(),enty.getOid());
    }

    @Override
    public Order search(String id) throws SQLException, ClassNotFoundException {
        ResultSet rst =CrudUtil.executeQuery("select * from orders where oid=?",id);
       if(rst.next()){
           String oid= rst.getString(1);
           String date = rst.getString(2);
           String customerID = rst.getString(3);
           return new Order(oid,date,customerID);     
//           return new Order- entity Order Object eka
       }
       return null;
    }

    @Override
    public ArrayList<Order> getAll() throws SQLException, ClassNotFoundException {
        ResultSet rst= CrudUtil.executeQuery("select * from orders");
        ArrayList<Order> allOrders = new ArrayList<>();
//        methanath Order entity Order Object
        while (rst.next()) {            
            String oid= rst.getString(1);
            String date= rst.getString(2);
            String customerId= rst.getString(3);
            
            Order order = new Order(oid,date,customerId);
            allOrders.add(order);
        }
       return allOrders;
    }
    
    
    
}
