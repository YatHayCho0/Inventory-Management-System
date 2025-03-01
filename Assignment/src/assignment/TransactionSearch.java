/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package assignment;

import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import javax.swing.table.DefaultTableModel;
import java.io.*;
import javax.swing.JOptionPane;

public class TransactionSearch extends javax.swing.JFrame {

    /**
     * Creates new form TransactionSearch
     */
    public TransactionSearch() {
        initComponents();
        this.setLocationRelativeTo(null);
        DisplayAllTransactions((DefaultTableModel) TransactionTxtTable.getModel());
    }

    public void SearchRECEIVEDItems(String itemCodeFilter, DefaultTableModel tableModel) {

        // Clear previous data
        tableModel.setRowCount(0);
        int TotalQuantity = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader("transactions.txt"))) {
            String line;
            String itemCode = "";
            String quantity = "";
            String date = "";
            String supplierCode = "";

            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Received Item:")) {
                    itemCode = line.split(":")[1].trim(); // Extract item code
                } else if (line.startsWith("Supplier Code:")) {
                    supplierCode = line.split(":")[1].trim(); // Extract Supplier Code
                } else if (line.startsWith("Boxes Acquired:")) {
                    quantity = line.split(":")[1].trim(); // Extract quantity
                } else if (line.startsWith("Date Received:")) {
                    date = line.split(":")[1].trim(); // Extract date

                    // Filter by item code
                    if (itemCodeFilter.isEmpty() || itemCode.equalsIgnoreCase(itemCodeFilter)) {
                        // Add row to JTable in the specified order
                        Object[] rowData = {itemCode, supplierCode, quantity, date,};
                        tableModel.addRow(rowData);

                        TotalQuantity += Integer.parseInt(quantity);
                    }
                }
            }
            TotalValue.setText(String.valueOf(TotalQuantity));
        } catch (IOException ex) {
            System.out.println("Error reading from file: " + ex.getMessage());
        }
    }

    public void SearchDISTRIBUTEDItems(String itemCodeFilter, DefaultTableModel tableModel) {

        // Clear previous data
        tableModel.setRowCount(0);
        int TotalQuantity = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader("transactions.txt"))) {
            String line;
            String itemCode = "";
            String quantity = "";
            String date = "";
            String hospitalCode = "";

            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Item Sent:")) {
                    itemCode = line.split(":")[1].trim(); // Extract item code
                } else if (line.startsWith("Hospital Received:")) {
                    hospitalCode = line.split(":")[1].trim(); // Extract Hospital Code
                } else if (line.startsWith("Boxes Distributed:")) {
                    quantity = line.split(":")[1].trim(); // Extract quantity
                } else if (line.startsWith("Date Done:")) {
                    date = line.split(":")[1].trim(); // Extract date

                    // Filter by item code
                    if (itemCodeFilter.isEmpty() || itemCode.equalsIgnoreCase(itemCodeFilter)) {
                        // Add row to JTable in the specified order
                        Object[] rowData = {itemCode, hospitalCode, quantity, date};
                        tableModel.addRow(rowData);

                        TotalQuantity += Integer.parseInt(quantity);
                    }
                }
            }
            TotalValue.setText(String.valueOf(TotalQuantity));
        } catch (IOException ex) {
            System.out.println("Error reading from file: " + ex.getMessage());
        }
    }

    public void DisplayAllTransactions(DefaultTableModel tableModel) {

        // Clear previous data
        tableModel.setRowCount(0);

        try (BufferedReader reader = new BufferedReader(new FileReader("transactions.txt"))) {
            String line;
            String itemCode = "";
            String quantity = "";
            String date = "";
            String supplierCode = "";
            String hospitalCode = "";

            while ((line = reader.readLine()) != null) {
                // Check for received items
                if (line.startsWith("Received Item:")) {
                    itemCode = line.split(":")[1].trim(); // Extract item code
                } else if (line.startsWith("Supplier Code:")) {
                    supplierCode = line.split(":")[1].trim(); // Extract Supplier Code
                } else if (line.startsWith("Boxes Acquired:")) {
                    quantity = line.split(":")[1].trim(); // Extract quantity
                } else if (line.startsWith("Date Received:")) {
                    date = line.split(":")[1].trim(); // Extract date
                        // Add row for received item to JTable
                        Object[] rowData = {itemCode, supplierCode, quantity, date};
                        tableModel.addRow(rowData);
                }

                // Check for distributed items
                if (line.startsWith("Item Sent:")) {
                    itemCode = line.split(":")[1].trim(); // Extract item code
                } else if (line.startsWith("Hospital Received:")) {
                    hospitalCode = line.split(":")[1].trim(); // Extract Hospital Code
                } else if (line.startsWith("Boxes Distributed:")) {
                    quantity = line.split(":")[1].trim(); // Extract quantity
                } else if (line.startsWith("Date Done:")) {
                    date = line.split(":")[1].trim(); // Extract date
                    // Add row for distributed item to JTable
                    Object[] rowData = {itemCode, hospitalCode, quantity, date};
                    tableModel.addRow(rowData);
                }
            }
            TotalValue.setText("NULL");
        } catch (IOException ex) {
            System.out.println("Error reading from file: " + ex.getMessage());
        }
    }

    // JFrame Swing Close Methods - Reference : https://youtu.be/hFv2Uay0qj0?si=x8NB78V7pPxs39it&t=133
    public void WindowClose() {
        WindowEvent closeWindow = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ItemTypeGroup = new javax.swing.ButtonGroup();
        ActionGroup = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        LabelDisplay_Title = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TransactionTxtTable = new javax.swing.JTable();
        RefreshButton = new javax.swing.JButton();
        LabelDisplay_ItemType = new javax.swing.JLabel();
        LabelDisplay_Action = new javax.swing.JLabel();
        ReceivedOption = new javax.swing.JRadioButton();
        DistributedOption = new javax.swing.JRadioButton();
        SearchButton = new javax.swing.JButton();
        ResetFilterButton1 = new javax.swing.JButton();
        BackButton = new javax.swing.JButton();
        HeadCover_Option = new javax.swing.JRadioButton();
        FaceShield_Option = new javax.swing.JRadioButton();
        Mask_Option = new javax.swing.JRadioButton();
        Gloves_Option = new javax.swing.JRadioButton();
        Gown_Option = new javax.swing.JRadioButton();
        jRadioButton6 = new javax.swing.JRadioButton();
        LabelDisplay_TotalRnD = new javax.swing.JLabel();
        TotalValue = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        LabelDisplay_Title.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        LabelDisplay_Title.setForeground(new java.awt.Color(255, 255, 255));
        LabelDisplay_Title.setText("TRANSACTION LOG");

        TransactionTxtTable.setForeground(new java.awt.Color(40, 40, 40));
        TransactionTxtTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item Code", "Supplier / Hospital Code", "Quantity Received / Distributed", "Date Action"
            }
        ));
        TransactionTxtTable.setSelectionBackground(new java.awt.Color(40, 40, 40));
        jScrollPane1.setViewportView(TransactionTxtTable);

        RefreshButton.setBackground(new java.awt.Color(30, 30, 30));
        RefreshButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        RefreshButton.setForeground(new java.awt.Color(255, 255, 255));
        RefreshButton.setText("Refresh");
        RefreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RefreshButtonActionPerformed(evt);
            }
        });

        LabelDisplay_ItemType.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        LabelDisplay_ItemType.setForeground(new java.awt.Color(255, 255, 255));
        LabelDisplay_ItemType.setText("Item Type :");

        LabelDisplay_Action.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        LabelDisplay_Action.setForeground(new java.awt.Color(255, 255, 255));
        LabelDisplay_Action.setText("Action :");

        ActionGroup.add(ReceivedOption);
        ReceivedOption.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ReceivedOption.setForeground(new java.awt.Color(255, 255, 255));
        ReceivedOption.setText("Received");
        ReceivedOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReceivedOptionActionPerformed(evt);
            }
        });

        ActionGroup.add(DistributedOption);
        DistributedOption.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        DistributedOption.setForeground(new java.awt.Color(255, 255, 255));
        DistributedOption.setText("Distributed");

        SearchButton.setBackground(new java.awt.Color(30, 30, 30));
        SearchButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        SearchButton.setForeground(new java.awt.Color(255, 255, 255));
        SearchButton.setText("Search");
        SearchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchButtonActionPerformed(evt);
            }
        });

        ResetFilterButton1.setBackground(new java.awt.Color(30, 30, 30));
        ResetFilterButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ResetFilterButton1.setForeground(new java.awt.Color(255, 255, 255));
        ResetFilterButton1.setText("Reset Filter");
        ResetFilterButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetFilterButton1ActionPerformed(evt);
            }
        });

        BackButton.setBackground(new java.awt.Color(30, 30, 30));
        BackButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        BackButton.setForeground(new java.awt.Color(255, 255, 255));
        BackButton.setText("Back");
        BackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackButtonActionPerformed(evt);
            }
        });

        ItemTypeGroup.add(HeadCover_Option);
        HeadCover_Option.setForeground(new java.awt.Color(255, 255, 255));
        HeadCover_Option.setText("Head Cover");
        HeadCover_Option.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HeadCover_OptionActionPerformed(evt);
            }
        });

        ItemTypeGroup.add(FaceShield_Option);
        FaceShield_Option.setForeground(new java.awt.Color(255, 255, 255));
        FaceShield_Option.setText("Face Shield");
        FaceShield_Option.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FaceShield_OptionActionPerformed(evt);
            }
        });

        ItemTypeGroup.add(Mask_Option);
        Mask_Option.setForeground(new java.awt.Color(255, 255, 255));
        Mask_Option.setText("Mask");
        Mask_Option.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Mask_OptionActionPerformed(evt);
            }
        });

        ItemTypeGroup.add(Gloves_Option);
        Gloves_Option.setForeground(new java.awt.Color(255, 255, 255));
        Gloves_Option.setText("Gloves");
        Gloves_Option.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Gloves_OptionActionPerformed(evt);
            }
        });

        ItemTypeGroup.add(Gown_Option);
        Gown_Option.setForeground(new java.awt.Color(255, 255, 255));
        Gown_Option.setText("Gown");

        ItemTypeGroup.add(jRadioButton6);
        jRadioButton6.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton6.setText("Shoe Covers");
        jRadioButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton6ActionPerformed(evt);
            }
        });

        LabelDisplay_TotalRnD.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        LabelDisplay_TotalRnD.setForeground(new java.awt.Color(255, 255, 255));
        LabelDisplay_TotalRnD.setText("TOTAL Recived/Distributed:");

        TotalValue.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        TotalValue.setForeground(new java.awt.Color(255, 255, 255));
        TotalValue.setText("NULL");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(382, 382, 382)
                .addComponent(LabelDisplay_Title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(367, 367, 367))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 716, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(LabelDisplay_ItemType, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(ResetFilterButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(SearchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(LabelDisplay_Action, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(LabelDisplay_TotalRnD)
                                                .addGap(18, 18, 18)
                                                .addComponent(TotalValue, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addContainerGap())
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(HeadCover_Option, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(ReceivedOption, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(Mask_Option, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(Gloves_Option, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(DistributedOption, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(FaceShield_Option, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(Gown_Option, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jRadioButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(22, 22, 22))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(BackButton)
                                .addGap(14, 14, 14))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(RefreshButton)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(LabelDisplay_Title)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addComponent(RefreshButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addComponent(LabelDisplay_ItemType)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(HeadCover_Option)
                            .addComponent(FaceShield_Option))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Gown_Option)
                            .addComponent(Mask_Option))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Gloves_Option)
                            .addComponent(jRadioButton6))
                        .addGap(33, 33, 33)
                        .addComponent(LabelDisplay_Action)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ReceivedOption)
                            .addComponent(DistributedOption))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LabelDisplay_TotalRnD)
                            .addComponent(TotalValue))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ResetFilterButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SearchButton)
                        .addGap(18, 18, 18)
                        .addComponent(BackButton)))
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void RefreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RefreshButtonActionPerformed
        DefaultTableModel tableModel = (DefaultTableModel) TransactionTxtTable.getModel();
        DisplayAllTransactions(tableModel);
    }//GEN-LAST:event_RefreshButtonActionPerformed

    private void ReceivedOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReceivedOptionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ReceivedOptionActionPerformed

    private void SearchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchButtonActionPerformed
        String ItemCode = "";
        String ActionPeformed = "";

        if (ReceivedOption.isSelected()) {
            ActionPeformed = "Received";
        } else if (DistributedOption.isSelected()) {
            ActionPeformed = "Distributed";
        } else {
            ActionPeformed = "";
        }

        if (HeadCover_Option.isSelected()) {
            ItemCode = "HC";
        } else if (FaceShield_Option.isSelected()) {
            ItemCode = "FS";
        } else if (Mask_Option.isSelected()) {
            ItemCode = "MS";
        } else if (Gloves_Option.isSelected()) {
            ItemCode = "GL";
        } else if (Gown_Option.isSelected()) {
            ItemCode = "GW";
        } else if (jRadioButton6.isSelected()) {
            ItemCode = "SC";
        } else {
            JOptionPane.showMessageDialog(this, "Please select an item.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        DefaultTableModel TransactionTableModel = (DefaultTableModel) TransactionTxtTable.getModel();
        TransactionTableModel.setRowCount(0); // Clear previous results
        if (ActionPeformed.equals("Received")) {
            SearchRECEIVEDItems(ItemCode, TransactionTableModel);
        } else if (ActionPeformed.equals("Distributed")) {
            SearchDISTRIBUTEDItems(ItemCode, TransactionTableModel);
        } else {
            JOptionPane.showMessageDialog(this, "Please select an Action.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
    }//GEN-LAST:event_SearchButtonActionPerformed

    private void ResetFilterButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetFilterButton1ActionPerformed
        ActionGroup.clearSelection();
        ItemTypeGroup.clearSelection();
    }//GEN-LAST:event_ResetFilterButton1ActionPerformed

    private void BackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackButtonActionPerformed
        dispose();
    }//GEN-LAST:event_BackButtonActionPerformed

    private void HeadCover_OptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HeadCover_OptionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_HeadCover_OptionActionPerformed

    private void Mask_OptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Mask_OptionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Mask_OptionActionPerformed

    private void Gloves_OptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Gloves_OptionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Gloves_OptionActionPerformed

    private void jRadioButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton6ActionPerformed

    private void FaceShield_OptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FaceShield_OptionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FaceShield_OptionActionPerformed

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
            java.util.logging.Logger.getLogger(TransactionSearch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TransactionSearch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TransactionSearch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TransactionSearch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TransactionSearch().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup ActionGroup;
    private javax.swing.JButton BackButton;
    private javax.swing.JRadioButton DistributedOption;
    private javax.swing.JRadioButton FaceShield_Option;
    private javax.swing.JRadioButton Gloves_Option;
    private javax.swing.JRadioButton Gown_Option;
    private javax.swing.JRadioButton HeadCover_Option;
    private javax.swing.ButtonGroup ItemTypeGroup;
    private javax.swing.JLabel LabelDisplay_Action;
    private javax.swing.JLabel LabelDisplay_ItemType;
    private javax.swing.JLabel LabelDisplay_Title;
    private javax.swing.JLabel LabelDisplay_TotalRnD;
    private javax.swing.JRadioButton Mask_Option;
    private javax.swing.JRadioButton ReceivedOption;
    private javax.swing.JButton RefreshButton;
    private javax.swing.JButton ResetFilterButton1;
    private javax.swing.JButton SearchButton;
    private javax.swing.JLabel TotalValue;
    private javax.swing.JTable TransactionTxtTable;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton6;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
