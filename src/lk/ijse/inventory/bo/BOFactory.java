/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.inventory.bo;

import lk.ijse.inventory.bo.custom.impl.CustomerBOImpl;
import lk.ijse.inventory.bo.custom.impl.ItemBOImpl;
/**
 *
 * @author Tharaka Dasunpriya
 */
public class BOFactory {

    private static BOFactory boFactory;

    private BOFactory() {
    }

    public static BOFactory getInstance() {
        if (boFactory == null) {
            boFactory = new BOFactory();
        }
        return boFactory;
    }

    public enum BOTypes {
        CUSTOMER, ITEM, PURCHASEORDER
    }

    public SuperBO getBO(BOTypes types) {
        switch (types) {
            case CUSTOMER:
                return new CustomerBOImpl();
            default:
                return null;

        }
    }

}
