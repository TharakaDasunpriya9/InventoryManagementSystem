/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package lk.ijse.inventory.dao.custom;

import lk.ijse.inventory.dao.CRUDDAO;
import lk.ijse.inventory.entity.Item;

/**
 *
 * @author Tharaka Dasunpriya
 */
public interface ItemDAO extends CRUDDAO<Item,String>{
    public String getItemLastID(String id)throws Exception;        
    
}
