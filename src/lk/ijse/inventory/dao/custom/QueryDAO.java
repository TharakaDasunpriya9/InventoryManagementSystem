/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.inventory.dao.custom;
import java.sql.SQLException;
import java.util.ArrayList;
import lk.ijse.inventory.dao.SuperDAO;
import lk.ijse.inventory.entity.CustomEntity;

public interface QueryDAO extends SuperDAO{
     public ArrayList<CustomEntity> getCustomersOrderDetails(String oid) throws ClassNotFoundException, SQLException;
}
