/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.ijse.inventory.bo.custom.impl;

import lk.ijse.inventory.bo.custom.ItemBO;
import lk.ijse.inventory.dao.DAOFactory;
import lk.ijse.inventory.dao.custom.ItemDAO;
import lk.ijse.inventory.dto.ItemDTO;
import lk.ijse.inventory.entity.Item;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Tharaka Dasunpriya
 */
public class ItemBOImpl implements ItemBO{
    ItemDAO dao = (ItemDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ITEM);

    @Override
    public boolean addItem(ItemDTO dto)throws ClassNotFoundException,SQLException{
        return dao.add(new Item(dto.getItemCode(),dto.getItemName(),dto.getQty(),dto.getUnitPrice()));
    }

    @Override
    public boolean updateItem(ItemDTO dto) throws SQLException, ClassNotFoundException {
     return dao.update(new Item(dto.getItemCode(),dto.getItemName(),dto.getQty(),dto.getUnitPrice()));
    }

    @Override
    public boolean removeItem(String itemCode) throws ClassNotFoundException, SQLException {
     return dao.delete(itemCode);
    }

    @Override
    public ItemDTO searchItem(String itemCode) throws ClassNotFoundException, SQLException {
       Item itm= dao.search(itemCode);
       return new ItemDTO(itm.getItemCode(),itm.getItemName(),itm.getQty(),itm.getUnitPrice());
    }

    @Override
    public ArrayList<ItemDTO> getAllItem() throws SQLException, ClassNotFoundException {
        ArrayList<Item>all =dao.getAll();
        ArrayList<ItemDTO> allItem =new ArrayList<>();
        for (Item i : all) {
            allItem.add(new ItemDTO(i.getItemCode(),i.getItemName(),i.getQty(),i.getUnitPrice()));
            
        }
        return allItem;
    }
    
    
    
}
