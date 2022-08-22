/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package lk.ijse.inventory.bo.custom;
import lk.ijse.inventory.bo.SuperBO;
import lk.ijse.inventory.dto.ItemDTO;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Tharaka Dasunpriya
 */
public interface ItemBO extends SuperBO{
    public boolean addItem(ItemDTO item)throws ClassNotFoundException,SQLException;
    public boolean updateItem(ItemDTO item)throws ClassNotFoundException,SQLException;
    public boolean removeItem(String itemCode)throws ClassNotFoundException,SQLException;
    public ItemDTO searchItem(String itemCode)throws ClassNotFoundException,SQLException;
    public ArrayList<ItemDTO> getAllItem()throws ClassNotFoundException,SQLException;
    
}
