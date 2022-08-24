/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.inventory.dao.custom;


import lk.ijse.inventory.dao.CRUDDAO;
import lk.ijse.inventory.entity.Item;

public interface ItemDAO extends CRUDDAO<Item, String>{
    public String getItemLastID()throws Exception;
}
