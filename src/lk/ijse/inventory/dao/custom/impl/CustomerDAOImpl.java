/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.inventory.dao.custom.impl;

import lk.ijse.inventory.dao.CrudUtil;
import lk.ijse.inventory.dao.custom.CustomerDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import lk.ijse.inventory.entity.Customer;

/**
 *
 * @author Tharaka Dasunpriya
 */
public class CustomerDAOImpl implements CustomerDAO {

    @Override
    public boolean add(Customer e) throws ClassNotFoundException, SQLException {
        return CrudUtil.executeUpdate("insert into Customer values(?,?,?,?)", e.getId(), e.getName(), e.getAddress(), e.getSalary());
    }

    @Override
    public boolean delete(String id) throws ClassNotFoundException, SQLException {
        String sql = "Delete from Customer where id=?";
        return CrudUtil.executeUpdate(sql, id);
    }

    @Override
    public boolean update(Customer e) throws SQLException, ClassNotFoundException {
        String sql = "Update Customer set name=?,address=?,salary=? where id=?";
        return CrudUtil.executeUpdate(sql, e.getName(), e.getAddress(), e.getSalary(), e.getId());
    }

    @Override
    public Customer search(String id) throws SQLException, ClassNotFoundException {
        String sql = "Select * from Customer where id=?";
        ResultSet rst = CrudUtil.executeQuery(sql, id);
        if (rst.next()) {
            String cusID = rst.getString(1);
            String cusName = rst.getString(2);
            String cusAddress = rst.getString(3);
            double salary = rst.getDouble(4);

            return new Customer(cusID, cusName, cusAddress, salary);

        }
        return null;
    }

    @Override
    public ArrayList<Customer> getAll() throws SQLException, ClassNotFoundException {

        String sql = "Select * from Customer";
        ResultSet rst = CrudUtil.executeQuery(sql);
        ArrayList<Customer> allCustomers = new ArrayList<>();
        while (rst.next()) {
            String cusID = rst.getString(1);
            String cusName = rst.getString(2);
            String cusAddress = rst.getString(3);
            double cusSalary = rst.getDouble(4);

            Customer customer = new Customer(cusID, cusName, cusAddress, cusSalary);
            allCustomers.add(customer);
        }
        return allCustomers;
    }

    @Override
    public String getCustomerLastID(String id) throws Exception {
        return null;
    }
}
