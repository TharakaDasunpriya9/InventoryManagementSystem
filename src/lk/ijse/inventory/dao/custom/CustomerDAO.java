/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.inventory.dao.custom;

import lk.ijse.inventory.dao.CRUDDAO;
import lk.ijse.inventory.entity.Customer;

public interface CustomerDAO extends CRUDDAO<Customer, String>{
    public String getCustomerLastID(String id)throws Exception;
}
