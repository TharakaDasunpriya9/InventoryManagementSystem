/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.inventory.dao;
import lk.ijse.inventory.dao.custom.impl.CustomerDAOImpl;
import lk.ijse.inventory.dao.custom.impl.ItemDAOImpl;

/**
 *
 * @author Tharaka Dasunpriya
 */
public class DAOFactory {

    private static DAOFactory dAOFactory;

    private DAOFactory() {

    }

    public static DAOFactory getInstance() {
        if (dAOFactory == null) {
            dAOFactory = new DAOFactory();
        }

        return dAOFactory;
    }
    
    public enum DAOTypes {
        CUSTOMER, ITEM, ORDERS, ORDERDETAILS, QUERYDAO;
    }

    public SuperDAO getDAO(DAOTypes types) {
        switch (types) {
            case CUSTOMER:
                return new CustomerDAOImpl();
            case ITEM:
                return new ItemDAOImpl();
            default:
                return null;
        }

    }

}
