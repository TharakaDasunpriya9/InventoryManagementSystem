/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.inventory.controller;


import java.sql.SQLException;
import java.util.ArrayList;
import lk.ijse.inventory.bo.BOFactory;
import lk.ijse.inventory.bo.custom.ItemBO;
import lk.ijse.inventory.dto.ItemDTO;


public class ItemFormController {

     ItemBO bo = (ItemBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.ITEM);

    public boolean addItem(ItemDTO item) throws ClassNotFoundException, SQLException {
        return bo.addItem(item);

    }

    public boolean updateItem(ItemDTO item) throws ClassNotFoundException, SQLException {
        return bo.updateItem(item);
    }

    public boolean removeItem(String itemCode) throws ClassNotFoundException, SQLException {
        return bo.removeItem(itemCode);
    }

    public ItemDTO searchItem(String itemCode) throws ClassNotFoundException, SQLException {
        return bo.searchItem(itemCode);
    }

    public ArrayList<ItemDTO> getAllItems() throws ClassNotFoundException, SQLException {
        return bo.getAllItems();
    }
}
