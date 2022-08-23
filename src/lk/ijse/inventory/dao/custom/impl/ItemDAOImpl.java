/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.ijse.inventory.dao.custom.impl;
import lk.ijse.inventory.dao.CrudUtil;
import lk.ijse.inventory.dao.custom.ItemDAO;
import lk.ijse.inventory.entity.Item;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Tharaka Dasunpriya
 */
//Sql query table name use karanna ona SQL DB eke

public class ItemDAOImpl implements ItemDAO{

    @Override
    public String getItemLastID(String id) throws Exception{
        return null;
    }

    @Override
    public boolean add(Item enty) throws ClassNotFoundException, SQLException {
        return CrudUtil.executeUpdate("insert into item values(?,?,?,?)",enty.getItemCode(),enty.getItemName(),enty.getQty(),enty.getUnitPrice());
    }

    @Override
    public boolean delete(String id) throws ClassNotFoundException, SQLException {
       String sql = "Delete from item where itemCode =?";
       return CrudUtil.executeUpdate(sql,id);
    }

    @Override
    public boolean update(Item enty) throws SQLException, ClassNotFoundException {
    String sql = "Update item set itemName=?,itemQty=?,unitPrice=? where itemCode=?";
    return CrudUtil.executeUpdate(sql,enty.getItemName(),enty.getQty(),enty.getUnitPrice(),enty.getItemCode());
    }

    @Override
    public Item search(String id) throws SQLException, ClassNotFoundException {
       String sql = "Select * from item where code=?";
        ResultSet rst= CrudUtil.executeQuery(sql,id);
        if (rst.next()) {
        String itemCode=rst.getString(1);
        String itemName = rst.getString(2);
        Integer itemQty =rst.getInt(3);
        Double itemUnitPrice= rst.getDouble(4);
        
        return new Item(itemCode,itemName,itemQty,itemUnitPrice);
                 
        }else{
            return null;
        }      
    }

    @Override
    public ArrayList<Item> getAll() throws SQLException, ClassNotFoundException {
        String sql= "Select * from Item";
        ResultSet rst = CrudUtil.executeQuery(sql);
        ArrayList<Item> allItem = new ArrayList<>();
        
        while (rst.next()) {            
        String itemCode=rst.getString(1);
        String itemName = rst.getString(2);
        Integer itemQty =rst.getInt(3);
        Double itemUnitPrice= rst.getDouble(4);
        
       Item item =new Item(itemCode,itemName,itemQty,itemUnitPrice);
       allItem.add(item);
                 
        }return allItem;
                
        
    }
}
