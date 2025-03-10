/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package assignment;

// Dylan Denny TP074879
// TO WHOEVER ACCESS MY SOURCE CODE, BY READING THIS YOU AGREE TO NOT STEAL ANY OF MY SOURCE CODE.
// I HAVE GO THROUGH MY WAYS AND STAY UP 4AM JUST TO UNDERSTAND HOW JAVA PROGRAMMING WORKS, PLEASE DON'T QUESTION MY SANITY.
// HONESTLY WHOEVER READS MY CODE ENJOY HAVING BUNCH OF COMMENTS BECAUSE THIS IS HOW I CODE.
// BEST OF LUCK TO ALL MY FRIENDS THIS SEMESTER.
// CODE MAY BE REDUNDANT AND NOT FLEXIBLE FOR OTHER TEAMMATE CODE, HOWEVER MY CODE IS PROBABLY ONLY FLEXIBLE WITHIN MY RANGE.

// For Window Closing -=-=-=-=-=-=-=-=-=
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.io.IOException;
import javax.swing.JOptionPane;
// -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-

// Table -=-=-=-=-=-=-=
import javax.swing.table.DefaultTableModel;
// -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-

public class UserManagement extends javax.swing.JFrame {

    /**
     * Creates new form UserManagement
     */
    private DefaultTableModel UserTableModel;

    public UserManagement() {
        initComponents();
        this.setLocationRelativeTo(null);
        setResizable(false);

        UserTableModel = (DefaultTableModel) UserTxtTable.getModel();

        try {
            UserManagementMethods.LoadUsers(UserTableModel);
        } catch (IOException e) {
            e.printStackTrace();
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

        Admin_Staff_Filter = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        LabelDisplay_Title = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        UserTxtTable = new javax.swing.JTable();
        BackButton = new javax.swing.JButton();
        RefreshButton = new javax.swing.JButton();
        SearchFilter_UserID = new javax.swing.JTextField();
        SearchFilter_Name = new javax.swing.JTextField();
        SearchFilter_DoR = new javax.swing.JTextField();
        ResetFilterButton = new javax.swing.JButton();
        RegisterButton = new javax.swing.JButton();
        DeleteButton = new javax.swing.JButton();
        LabelDisplay_UserID = new javax.swing.JLabel();
        LabelDisplay_Name = new javax.swing.JLabel();
        LabelDisplay_DoR = new javax.swing.JLabel();
        UserAdminSearch = new javax.swing.JRadioButton();
        UserStaffSearch = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        SearchButton1 = new javax.swing.JButton();
        ModifyButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(51, 51, 51));

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        LabelDisplay_Title.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        LabelDisplay_Title.setForeground(new java.awt.Color(255, 255, 255));
        LabelDisplay_Title.setText("USER MANAGEMENT");

        UserTxtTable.setForeground(new java.awt.Color(40, 40, 40));
        UserTxtTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "User ID", "Name", "Password", "User Type", "Date Register"
            }
        ));
        UserTxtTable.setSelectionBackground(new java.awt.Color(40, 40, 40));
        jScrollPane1.setViewportView(UserTxtTable);

        BackButton.setBackground(new java.awt.Color(30, 30, 30));
        BackButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        BackButton.setForeground(new java.awt.Color(255, 255, 255));
        BackButton.setText("Back");
        BackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackButtonActionPerformed(evt);
            }
        });

        RefreshButton.setBackground(new java.awt.Color(30, 30, 30));
        RefreshButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        RefreshButton.setForeground(new java.awt.Color(255, 255, 255));
        RefreshButton.setText("Refresh");
        RefreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RefreshButtonActionPerformed(evt);
            }
        });

        SearchFilter_UserID.setBackground(new java.awt.Color(30, 30, 30));
        SearchFilter_UserID.setForeground(new java.awt.Color(255, 255, 255));

        SearchFilter_Name.setBackground(new java.awt.Color(30, 30, 30));
        SearchFilter_Name.setForeground(new java.awt.Color(255, 255, 255));

        SearchFilter_DoR.setBackground(new java.awt.Color(30, 30, 30));
        SearchFilter_DoR.setForeground(new java.awt.Color(255, 255, 255));

        ResetFilterButton.setBackground(new java.awt.Color(30, 30, 30));
        ResetFilterButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ResetFilterButton.setForeground(new java.awt.Color(255, 255, 255));
        ResetFilterButton.setText("Reset Filter");
        ResetFilterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetFilterButtonActionPerformed(evt);
            }
        });

        RegisterButton.setBackground(new java.awt.Color(30, 30, 30));
        RegisterButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        RegisterButton.setForeground(new java.awt.Color(255, 255, 255));
        RegisterButton.setText("Register");
        RegisterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegisterButtonActionPerformed(evt);
            }
        });

        DeleteButton.setBackground(new java.awt.Color(30, 30, 30));
        DeleteButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        DeleteButton.setForeground(new java.awt.Color(255, 255, 255));
        DeleteButton.setText("Delete");
        DeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteButtonActionPerformed(evt);
            }
        });

        LabelDisplay_UserID.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        LabelDisplay_UserID.setForeground(new java.awt.Color(255, 255, 255));
        LabelDisplay_UserID.setText("User ID :");

        LabelDisplay_Name.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        LabelDisplay_Name.setForeground(new java.awt.Color(255, 255, 255));
        LabelDisplay_Name.setText("Name :");

        LabelDisplay_DoR.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        LabelDisplay_DoR.setForeground(new java.awt.Color(255, 255, 255));
        LabelDisplay_DoR.setText("Date Of Register :");

        Admin_Staff_Filter.add(UserAdminSearch);
        UserAdminSearch.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        UserAdminSearch.setForeground(new java.awt.Color(255, 255, 255));
        UserAdminSearch.setText("Admin");

        Admin_Staff_Filter.add(UserStaffSearch);
        UserStaffSearch.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        UserStaffSearch.setForeground(new java.awt.Color(255, 255, 255));
        UserStaffSearch.setText("Staff");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("User Type :");

        SearchButton1.setBackground(new java.awt.Color(30, 30, 30));
        SearchButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        SearchButton1.setForeground(new java.awt.Color(255, 255, 255));
        SearchButton1.setText("Search");
        SearchButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchButton1ActionPerformed(evt);
            }
        });

        ModifyButton.setBackground(new java.awt.Color(30, 30, 30));
        ModifyButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ModifyButton.setForeground(new java.awt.Color(255, 255, 255));
        ModifyButton.setText("Modify");
        ModifyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModifyButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(382, 382, 382)
                .addComponent(LabelDisplay_Title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(367, 367, 367))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(RefreshButton)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 609, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(LabelDisplay_DoR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(LabelDisplay_Name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(LabelDisplay_UserID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(SearchFilter_DoR)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(UserAdminSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(UserStaffSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(SearchFilter_Name)
                                    .addComponent(SearchFilter_UserID))
                                .addGap(27, 27, 27))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ResetFilterButton, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(SearchButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(BackButton)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(RegisterButton, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(DeleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(ModifyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(LabelDisplay_Title)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(RefreshButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(SearchFilter_UserID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LabelDisplay_UserID))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(SearchFilter_Name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LabelDisplay_Name))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(SearchFilter_DoR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LabelDisplay_DoR))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(UserAdminSearch)
                            .addComponent(jLabel2)
                            .addComponent(UserStaffSearch))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ResetFilterButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SearchButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ModifyButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DeleteButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(RegisterButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BackButton))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
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

    private void BackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackButtonActionPerformed
        WindowClose();
        HomePage WindowFrame = new HomePage();
        WindowFrame.setVisible(true);
    }//GEN-LAST:event_BackButtonActionPerformed

    private void ResetFilterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetFilterButtonActionPerformed
        SearchFilter_UserID.setText("");
        SearchFilter_Name.setText("");
        SearchFilter_DoR.setText("");
        Admin_Staff_Filter.clearSelection();
    }//GEN-LAST:event_ResetFilterButtonActionPerformed

    private void DeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteButtonActionPerformed
        // I love doing research, I found this JOptionPane from https://www.geeksforgeeks.org/java-joptionpane/
        // I learnt how to use thanks to this vid https://www.youtube.com/watch?v=ffVY6HGtxH8
        // this too, https://www.youtube.com/watch?v=ffVY6HGtxH8

        int SelectedRow = UserTxtTable.getSelectedRow();

        if (SelectedRow >= 0) {
            String UserID = UserTableModel.getValueAt(SelectedRow, 0).toString();

            int Confirmation = JOptionPane.showConfirmDialog(this,
                    "Are you sure you want to delete the user with ID " + UserID + "? This action cannot be reverted",
                    "Confirm Deletion",
                    JOptionPane.YES_NO_OPTION);
            if (Confirmation == JOptionPane.YES_OPTION) {
                try {
                    UserManagementMethods.DeleteUser(UserID);
                    UserManagementMethods.LoadUsers(UserTableModel);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else {
            JOptionPane.showMessageDialog(this,
                    "No user selected. Please select a user to delete.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_DeleteButtonActionPerformed

    private void SearchButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchButton1ActionPerformed
        String UserID = SearchFilter_UserID.getText().trim();
        String Name = SearchFilter_Name.getText().trim();
        String DateOfRegister = SearchFilter_DoR.getText().trim();
        String UserType = "";

        if (UserAdminSearch.isSelected()) {
            UserType = "Admin";
        } else if (UserStaffSearch.isSelected()) {
            UserType = "Staff";
        } else {
            UserType = "";
        }

        try {
            // Call the SearchUsers method
            UserManagementMethods.SearchUsers(UserTableModel, UserID, Name, UserType, DateOfRegister);

            // Check if no rows are present in the table after search
            if (UserTableModel.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "No users found with the given criteria.", "Search Result", JOptionPane.INFORMATION_MESSAGE);
                // Optionally, reload the default view
                UserManagementMethods.LoadUsers(UserTableModel);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_SearchButton1ActionPerformed

    private void RefreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RefreshButtonActionPerformed
        try {
            UserManagementMethods.LoadUsers(UserTableModel);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_RefreshButtonActionPerformed

    private void ModifyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModifyButtonActionPerformed
        int selectedRow = UserTxtTable.getSelectedRow();

        if (selectedRow >= 0) {
            String userID = UserTableModel.getValueAt(selectedRow, 0).toString();
            String currentName = UserTableModel.getValueAt(selectedRow, 1).toString();
            String currentPassword = UserTableModel.getValueAt(selectedRow, 2).toString();
            String currentUserType = UserTableModel.getValueAt(selectedRow, 3).toString();

            int Confirmation = JOptionPane.showConfirmDialog(this,
                    "Are you sure you want to modify the user with " + userID + "?",
                    "Confirm Modification?",
                    JOptionPane.YES_NO_OPTION);

            if (Confirmation == JOptionPane.YES_OPTION) {
                Modify windowFrame = new Modify(userID, currentName, currentPassword, currentUserType);
                windowFrame.setVisible(true);
            }
        } else {
            JOptionPane.showMessageDialog(this,
                    "No user selected. Please select a user to modify.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_ModifyButtonActionPerformed

    private void RegisterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegisterButtonActionPerformed
        Register WindowFrame = new Register();
        WindowFrame.setVisible(true);
    }//GEN-LAST:event_RegisterButtonActionPerformed

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
            java.util.logging.Logger.getLogger(UserManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserManagement().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup Admin_Staff_Filter;
    private javax.swing.JButton BackButton;
    private javax.swing.JButton DeleteButton;
    private javax.swing.JLabel LabelDisplay_DoR;
    private javax.swing.JLabel LabelDisplay_Name;
    private javax.swing.JLabel LabelDisplay_Title;
    private javax.swing.JLabel LabelDisplay_UserID;
    private javax.swing.JButton ModifyButton;
    private javax.swing.JButton RefreshButton;
    private javax.swing.JButton RegisterButton;
    private javax.swing.JButton ResetFilterButton;
    private javax.swing.JButton SearchButton1;
    private javax.swing.JTextField SearchFilter_DoR;
    private javax.swing.JTextField SearchFilter_Name;
    private javax.swing.JTextField SearchFilter_UserID;
    private javax.swing.JRadioButton UserAdminSearch;
    private javax.swing.JRadioButton UserStaffSearch;
    private javax.swing.JTable UserTxtTable;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
