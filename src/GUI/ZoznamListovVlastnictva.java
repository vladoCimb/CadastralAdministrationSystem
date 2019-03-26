/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import FiltersAndOthers.DeletePropertyList;
import FiltersAndOthers.FilterZoznamListovVlastnictva;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import mainpackage.Globals;
import mainpackage.Logika;
import mainpackage.MainSystem;
import mainpackage.PropertyList;

/**
 *
 * @author Vladko
 */
public class ZoznamListovVlastnictva extends javax.swing.JPanel {

    private MainSystem system;
    private JFrame mainWindow = new JFrame();
    private Logika logika = new Logika();

    public ZoznamListovVlastnictva(JFrame frame, MainSystem system) {
        this.system = system;
        mainWindow = frame;
        initComponents();
        inicializacia();
    }

    public void inicializacia() {

        showList();

    }

    public void showList() {
        jTable1.setModel(new TableModels.ZoznamListovVlastnictvaTabModel1(system.getPropertyLists()));
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
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        newBT = new javax.swing.JButton();
        changeBT = new javax.swing.JButton();
        deleteBT = new javax.swing.JButton();
        refreshBT = new javax.swing.JButton();
        searchTF = new javax.swing.JTextField();
        searchBT = new javax.swing.JButton();
        extraSearchBT = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setToolTipText("");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Zoznam listov vlastíctva");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        newBT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/new.png"))); // NOI18N
        newBT.setText("Nový list");
        newBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newBTActionPerformed(evt);
            }
        });

        changeBT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/save.png"))); // NOI18N
        changeBT.setText("Uprav list");
        changeBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeBTActionPerformed(evt);
            }
        });

        deleteBT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delete.png"))); // NOI18N
        deleteBT.setText("Zmaž list");
        deleteBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBTActionPerformed(evt);
            }
        });

        refreshBT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/refresh.png"))); // NOI18N
        refreshBT.setText("Obnova");
        refreshBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshBTActionPerformed(evt);
            }
        });

        searchBT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/kripto-search-b.png"))); // NOI18N
        searchBT.setText("Hľadaj");

        extraSearchBT.setText("Rozšírené vyhľadávanie");
        extraSearchBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                extraSearchBTActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(refreshBT)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(extraSearchBT)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchTF, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchBT)
                        .addGap(47, 47, 47)
                        .addComponent(newBT)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(changeBT)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                        .addComponent(deleteBT)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 332, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(refreshBT)
                    .addComponent(searchTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchBT)
                    .addComponent(extraSearchBT)
                    .addComponent(newBT)
                    .addComponent(changeBT)
                    .addComponent(deleteBT))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void newBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newBTActionPerformed
        Globals.panel.addTab("List vlastníctva", new ListVlastnictva(mainWindow, system, 0));
        logika.setLastTab();
    }//GEN-LAST:event_newBTActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        if (evt.getClickCount() == 2) {

            int selectedRowIndex = jTable1.getSelectedRow();
            String cadastralArea = jTable1.getValueAt(selectedRowIndex, 1).toString();
            String numberPropertyList = jTable1.getValueAt(selectedRowIndex, 0).toString();

            ListVlastnictva panel = new ListVlastnictva(mainWindow, system, system.findPropertyListByNumber(Integer.parseInt(numberPropertyList)));
            Globals.panel.addTab("List vlastníctva " + numberPropertyList, panel);
            logika.setLastTab();
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void changeBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeBTActionPerformed

        int selectedRowIndex = jTable1.getSelectedRow();
        if (selectedRowIndex >= 0) {
            String cadastralArea = jTable1.getValueAt(selectedRowIndex, 0).toString();
            String numberPropertyList = jTable1.getValueAt(selectedRowIndex, 1).toString();

            PropertyList list = new PropertyList(system.findCadArea(Integer.parseInt(cadastralArea)), Integer.parseInt(numberPropertyList));
            ListVlastnictva panel = new ListVlastnictva(mainWindow, system, list);
            Globals.panel.addTab("List vlastníctva " + numberPropertyList, panel);
            logika.setLastTab();
        } else {
            JOptionPane.showMessageDialog(mainWindow, "Zvoľte list, ktorý chcete upraviť");
        }
    }//GEN-LAST:event_changeBTActionPerformed

    private void refreshBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshBTActionPerformed
        showList();
    }//GEN-LAST:event_refreshBTActionPerformed

    private void extraSearchBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_extraSearchBTActionPerformed
        FilterZoznamListovVlastnictva fz = new FilterZoznamListovVlastnictva(system);
    }//GEN-LAST:event_extraSearchBTActionPerformed

    private void deleteBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBTActionPerformed
        int row = jTable1.getSelectedRow();
        if(row >= 0){
            String listNumber = jTable1.getModel().getValueAt(row, 0).toString();
            DeletePropertyList dl = new DeletePropertyList(system,listNumber);
        }else{
            JOptionPane.showMessageDialog(mainWindow, "Zvolte list vlastníctva.");  
        }
    }//GEN-LAST:event_deleteBTActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton changeBT;
    private javax.swing.JButton deleteBT;
    private javax.swing.JButton extraSearchBT;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton newBT;
    private javax.swing.JButton refreshBT;
    private javax.swing.JButton searchBT;
    private javax.swing.JTextField searchTF;
    // End of variables declaration//GEN-END:variables
}
