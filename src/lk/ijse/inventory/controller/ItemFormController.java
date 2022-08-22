/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.ijse.inventory.controller;
import lk.ijse.inventory.bo.BOFactory;
import lk.ijse.inventory.bo.custom.ItemBO;
import lk.ijse.inventory.dto.ItemDTO;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Tharaka Dasunpriya
 */
public class ItemFormController {
    ItemBO bo = (ItemBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.ITEM);
  
    public boolean addItem(ItemDTO item) throws ClassNotFoundException,SQLException{
        return bo.addItem(item);
    }

  
    public boolean updateItem(ItemDTO item) throws ClassNotFoundException,SQLException{
       return bo.updateItem(item);
    }

  
    public boolean removeItem(String itemCode)throws ClassNotFoundException,SQLException{
        return bo.removeItem(itemCode);
    }

   
    public ItemDTO searchItem(String itemCode) throws ClassNotFoundException,SQLException{
       return bo.searchItem(itemCode);
    }

   
    public ArrayList<ItemDTO> getAllItem() throws ClassNotFoundException,SQLException{
       return bo.getAllItem();
    }
}
