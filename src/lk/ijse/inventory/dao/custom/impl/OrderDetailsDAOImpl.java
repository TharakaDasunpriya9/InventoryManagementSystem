/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.ijse.inventory.dao.custom.impl;

import lk.ijse.inventory.dao.CrudUtil;
import lk.ijse.inventory.dao.custom.OrderDetailsDAO;
import lk.ijse.inventory.entity.OrderDetail;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Tharaka Dasunpriya
 */
public class OrderDetailsDAOImpl implements OrderDetailsDAO{

    @Override
    public boolean add(OrderDetail enty) throws ClassNotFoundException, SQLException {
       return CrudUtil.executeUpdate("insert into orderDetails values(?,?,?,?)",enty.getOid(),enty.getItemCode(),enty.getQty(),enty.getUnitPrice());
    }

    @Override
    public boolean delete(String id) throws ClassNotFoundException, SQLException {
        return CrudUtil.executeUpdate("delete from orderDetails where orderID=?",id);
    }

    @Override
    public boolean update(OrderDetail enty) throws SQLException, ClassNotFoundException {
        return CrudUtil.executeUpdate("update orderDetails set itemCode=?,qty=?,unitPrice=? where orderID=?",enty.getItemCode(),enty.getQty(),enty.getUnitPrice(),enty.getOid());
    }

    @Override
    public OrderDetail search(String id) throws SQLException, ClassNotFoundException {
        ResultSet rst=CrudUtil.executeQuery("select * from orderDetails where orderId=?", id);
        if(rst.next()){
            String oid = rst.getString(1);
            String itemCode = rst.getString(2);
            int qty = rst.getInt(3);
            double unitPrice =rst.getDouble(4);
        }
        return null;
    }

    @Override
    public ArrayList<OrderDetail> getAll() throws SQLException, ClassNotFoundException {
       ResultSet rst = CrudUtil.executeQuery("select * from orderDetails");
        ArrayList<OrderDetail> allOrderDetails = new ArrayList();
        while (rst.next()) {
             String oid = rst.getString(1);
             String itemCode = rst.getString(2);
             int qty = rst.getInt(3);
             double unitPrice = rst.getDouble(4);
             
             OrderDetail orderDetails = new OrderDetail(oid, itemCode, qty, unitPrice);
             allOrderDetails.add(orderDetails);
            
        }
        return allOrderDetails;
        
    }
    
}
