/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.inventory.views;

import lk.ijse.inventory.controller.ItemFormController;
import lk.ijse.inventory.dto.ItemDTO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class ItemForm extends javax.swing.JFrame {

   
    public ItemForm() {
        initComponents();
        loadAllItems();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtItemUnitPrice = new javax.swing.JTextField();
        txtItemCode = new javax.swing.JTextField();
        txtItemName = new javax.swing.JTextField();
        txtItemQty = new javax.swing.JTextField();
        btnClear = new javax.swing.JButton();
        btnRegister = new javax.swing.JButton();
        btnRenew = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblItem = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(254, 254, 254));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel1.setText("Item Manage");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, -1, -1));
        jPanel1.add(txtItemUnitPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 290, 290, 50));

        txtItemCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtItemCodeActionPerformed(evt);
            }
        });
        jPanel1.add(txtItemCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 80, 290, 50));
        jPanel1.add(txtItemName, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 160, 290, 50));

        txtItemQty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtItemQtyActionPerformed(evt);
            }
        });
        jPanel1.add(txtItemQty, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 230, 290, 50));

        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });
        jPanel1.add(btnClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 360, 90, 40));

        btnRegister.setText("Save");
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegister, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 370, 90, 40));

        btnRenew.setText("Update");
        btnRenew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRenewActionPerformed(evt);
            }
        });
        jPanel1.add(btnRenew, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 370, 90, 40));

        btnRemove.setText("Remove");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });
        jPanel1.add(btnRemove, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 370, 90, 40));

        tblItem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Code", "Name", "Qty", "Price"
            }
        ));
        jScrollPane1.setViewportView(tblItem);
        if (tblItem.getColumnModel().getColumnCount() > 0) {
            tblItem.getColumnModel().getColumn(3).setResizable(false);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 430, 410, 230));

        jLabel2.setText("Item Unit Price");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 320, -1, -1));

        jLabel3.setText("Item Code");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, -1, -1));

        jLabel4.setText("Item Name");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, -1, -1));

        jLabel5.setText("Item Qty");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 240, -1, -1));

        jPanel2.setBackground(new java.awt.Color(204, 255, 153));
        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 110, 670));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 590));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtItemQtyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtItemQtyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtItemQtyActionPerformed

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed
        //gather details
        String itemCode = txtItemCode.getText();
        String itemName = txtItemName.getText();
        int itemQty = Integer.parseInt(txtItemQty.getText());
        double unitPrice = Double.parseDouble(txtItemUnitPrice.getText());

        try {

            ItemDTO item = new ItemDTO(itemCode, itemName, itemQty, unitPrice);
            boolean addItem = new ItemFormController().addItem(item);

            if (addItem) {
                JOptionPane.showMessageDialog(this, "Item Saved..!");
                loadAllItems();
            } else {
                JOptionPane.showMessageDialog(this, "Item Not Saved..!");
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ItemForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ItemForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnRegisterActionPerformed

    private void btnRenewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRenewActionPerformed
        //gather details
        String itemCode = txtItemCode.getText();
        String itemName = txtItemName.getText();
        int itemQty = Integer.parseInt(txtItemQty.getText());
        double unitPrice = Double.parseDouble(txtItemUnitPrice.getText());

        try {
            ItemDTO item = new ItemDTO(itemCode, itemName, itemQty, unitPrice);
            boolean result = new ItemFormController().updateItem(item);
            if (result) {
                JOptionPane.showMessageDialog(this, "Item Updated..!");
                loadAllItems();
            } else {
                JOptionPane.showMessageDialog(this, "Item Not Updated..!");
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ItemForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ItemForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnRenewActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        //gather details
        String itemCode = txtItemCode.getText();

        try {
            boolean result = new ItemFormController().removeItem(itemCode);
            if (result) {
                JOptionPane.showMessageDialog(this, "Item Removed..!");
                loadAllItems();
            } else {
                JOptionPane.showMessageDialog(this, "Item Not Removed..!");
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ItemForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ItemForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void txtItemCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtItemCodeActionPerformed
        //gather details
        String itemCode = txtItemCode.getText();

        try {
            ItemDTO searchItem = new ItemFormController().searchItem(itemCode);
            if (searchItem != null) {
                txtItemCode.setText(searchItem.getItemCode());
                txtItemName.setText(searchItem.getItemName());
                txtItemQty.setText(searchItem.getQty()+ "");
                txtItemUnitPrice.setText(searchItem.getUnitPrice() + "");
            } else {
                clearAllText();
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ItemForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ItemForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtItemCodeActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        clearAllText();
    }//GEN-LAST:event_btnClearActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ItemForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ItemForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ItemForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ItemForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ItemForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnRegister;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnRenew;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblItem;
    private javax.swing.JTextField txtItemCode;
    private javax.swing.JTextField txtItemName;
    private javax.swing.JTextField txtItemQty;
    private javax.swing.JTextField txtItemUnitPrice;
    // End of variables declaration//GEN-END:variables

    private void clearAllText() {
        txtItemCode.setText("");
        txtItemName.setText("");
        txtItemQty.setText("");
        txtItemUnitPrice.setText("");
        txtItemCode.requestFocus();
        loadAllItems();
    }

    private void loadAllItems() {

        DefaultTableModel dtm = (DefaultTableModel) tblItem.getModel();
        dtm.setRowCount(0);

        try {
            ArrayList<ItemDTO> allItems = new ItemFormController().getAllItems();
            for (ItemDTO i : allItems) {
                Object[] row = {i.getItemCode(), i.getItemName(), i.getQty(), i.getUnitPrice()};
                dtm.addRow(row);
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ItemForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ItemForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
