/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import FiltersAndOthers.ChangePermResidence;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import mainpackage.Logika;
import javax.swing.SwingConstants;
import mainpackage.Globals;
import mainpackage.MainSystem;
import mainpackage.Person;
import mainpackage.Property;
import mainpackage.PropertyList;

/**
 *
 * @author Vladko
 */
public class Obcan extends javax.swing.JPanel {

    Logika logika = new Logika();
    JFrame mainWindow = new JFrame();
    MainSystem system = new MainSystem();
    Person personBeforeChanges = new Person();

    public Obcan(JFrame frame, MainSystem system) {
        initComponents();
        mainWindow = frame;
        this.system = system;

        InicializationNew();

    }

    public Obcan(JFrame frame, MainSystem system, int index) {
        initComponents();
        this.system = system;
        this.mainWindow = frame;
        if (index == 0) {
            InicializationNew();
        } else {
            Inicialization();
        }
    }

    public Obcan(JFrame frame, MainSystem system, Person person) {
        initComponents();
        this.mainWindow = frame;
        this.system = system;
        Inicialization(person);
        personBeforeChanges = person;
    }

    private void Inicialization(Person person) {
        jPanel1.add(jLabel2, SwingConstants.CENTER);
        jLabel5.setText("<html>Trvalý pobyt<br>(Súpisné číslo)</html>");
        nameTF.setEditable(false);
        surenameTF.setEditable(false);
        identifNumTF.setEditable(false);
        regNumTF.setEditable(false);
        addBT.setEnabled(false);
        saveBT.setEnabled(false);

        nameTF.setText(person.getFirstName());
        surenameTF.setText(person.getSurnName());
        identifNumTF.setText(Long.toString(person.getIdentifNumb()));
        if (person.getPermResidence() != null) {
            regNumTF.setText(Integer.toString(person.getPermResidence().getRegNumber()));
        } else {
            regNumTF.setText("");
        }
        showList();

    }

    private void Inicialization() {
        jPanel1.add(jLabel2, SwingConstants.CENTER);
        jLabel5.setText("<html>Trvalý pobyt<br>(Súpisné číslo)</html>");
        nameTF.setEditable(false);
        surenameTF.setEditable(false);
        identifNumTF.setEditable(false);
        regNumTF.setEditable(false);
        addBT.setEnabled(false);
        saveBT.setEnabled(false);
    }

    private void InicializationNew() {
        jPanel1.add(jLabel2, SwingConstants.CENTER);
        jLabel5.setText("<html>Trvalý pobyt<br>(Súpisné číslo)</html>");
        nameTF.setEditable(true);
        surenameTF.setEditable(true);
        identifNumTF.setEditable(true);
        regNumTF.setEditable(true);
        addBT.setEnabled(true);
        saveBT.setEnabled(false);
        editBT.setEnabled(false);
    }

    public void showList() {
        jTable2.setModel(new TableModels.ZoznamListovVlastnictvaTabModel1<>(system.findPersonByID(Long.parseLong(identifNumTF.getText())).getPropertyLists()));
        if (system.findPersonByID(Long.parseLong(identifNumTF.getText())).getPermResidence() != null) {
            regNumTF.setText(Integer.toString(system.findPersonByID(Long.parseLong(identifNumTF.getText())).getPermResidence().getRegNumber()));
        } else {
            regNumTF.setText("");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        nameTF = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        surenameTF = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        identifNumTF = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        regNumTF = new javax.swing.JTextField();
        saveBT = new javax.swing.JButton();
        addBT = new javax.swing.JButton();
        editBT = new javax.swing.JButton();
        showBT = new javax.swing.JButton();
        changePermBT = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        findPropertiesTF = new javax.swing.JTextField();
        findPropertiesBT = new javax.swing.JButton();
        searchAllBT = new javax.swing.JButton();

        jLabel1.setText("Meno:");

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setToolTipText("");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setLabelFor(jLabel1);
        jLabel2.setText("Občan");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel3.setText("Priezvisko:");

        jLabel4.setText("Rodné číslo:");

        jLabel5.setText("Trvalý pobyt (súpisné číslo)");

        saveBT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/save.png"))); // NOI18N
        saveBT.setText("Ulož občana");
        saveBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBTActionPerformed(evt);
            }
        });

        addBT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/new.png"))); // NOI18N
        addBT.setText("Pridaj občana");
        addBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBTActionPerformed(evt);
            }
        });

        editBT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit.png"))); // NOI18N
        editBT.setText("Uprav občana");
        editBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editBTActionPerformed(evt);
            }
        });

        showBT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/show.png"))); // NOI18N
        showBT.setText("Zobraz");
        showBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showBTActionPerformed(evt);
            }
        });

        changePermBT.setText("Zmena trvalého bydliska");
        changePermBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changePermBTActionPerformed(evt);
            }
        });

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

        jLabel6.setText("Nehnuteľnosti občana v katastrálnom území:");

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jLabel7.setText("Listy vlastníctva");

        findPropertiesBT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/kripto-search-b.png"))); // NOI18N
        findPropertiesBT.setText("Hľadaj");
        findPropertiesBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findPropertiesBTActionPerformed(evt);
            }
        });

        searchAllBT.setText("Nájdi všetky nehnuteľnosti");
        searchAllBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchAllBTActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nameTF)
                            .addComponent(identifNumTF, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(surenameTF, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(regNumTF)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(showBT))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(changePermBT)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 722, Short.MAX_VALUE)
                        .addComponent(addBT)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(editBT)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(saveBT))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(findPropertiesTF)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(findPropertiesBT)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(searchAllBT))
                            .addComponent(jScrollPane1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(surenameTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(identifNumTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(regNumTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(showBT))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveBT)
                    .addComponent(addBT)
                    .addComponent(editBT)
                    .addComponent(changePermBT))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(findPropertiesTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(findPropertiesBT)
                    .addComponent(searchAllBT))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBTActionPerformed
        if (nameTF.getText().isEmpty() || surenameTF.getText().isEmpty() || identifNumTF.getText().isEmpty() || identifNumTF.getText().length() != 16) {
            JOptionPane.showMessageDialog(mainWindow, "Vyplňte meno, priezvisko, rodné číslo.");
            return;
        } else {
            if (system.findPropertyByRegNumb(Integer.parseInt(regNumTF.getText())) != null) {
                system.addCitizien(nameTF.getText(), surenameTF.getText(), Long.parseLong(identifNumTF.getText()), system.findPropertyByRegNumb(Integer.parseInt(regNumTF.getText())));
                system.findPropertyByRegNumb(Integer.parseInt(regNumTF.getText())).addResident(system.findPersonByID((Long.parseLong(identifNumTF.getText()))));
                JOptionPane.showMessageDialog(mainWindow, "Občan bol úspešne vytvorený");
                nameTF.setText("");
                surenameTF.setText("");
                identifNumTF.setText("");
                regNumTF.setText("");
            } else {
                system.addCitizienWithoutPermProperty(nameTF.getText(), surenameTF.getText(), Integer.parseInt(identifNumTF.getText()));
                JOptionPane.showMessageDialog(mainWindow, "Občan bol úspešne vytvorený");
                nameTF.setText("");
                surenameTF.setText("");
                identifNumTF.setText("");
                regNumTF.setText("");
            }

        }
    }//GEN-LAST:event_addBTActionPerformed

    private void editBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBTActionPerformed
        nameTF.setEditable(true);
        surenameTF.setEditable(true);
        identifNumTF.setEditable(true);

        saveBT.setEnabled(true);
    }//GEN-LAST:event_editBTActionPerformed

    private void saveBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBTActionPerformed
        if (nameTF.getText().isEmpty() || surenameTF.getText().isEmpty() || identifNumTF.getText().isEmpty() || (system.findPropertyByRegNumb(Integer.parseInt(regNumTF.getText())) == null)) {
            JOptionPane.showMessageDialog(mainWindow, "Meno,priezvisko a rodné číslo musia byť vyplnené a súčasne musí existovať nehnuteľnosť so zadaným súpisným číslom");
            return;
        } else {
            ((Person) system.getCitiziens().findNode(personBeforeChanges).getData()).setFirstName(nameTF.getText());
            ((Person) system.getCitiziens().findNode(personBeforeChanges).getData()).setSurnName(surenameTF.getText());
            ((Person) system.getCitiziens().findNode(personBeforeChanges).getData()).setIdentifNumb(Integer.parseInt(identifNumTF.getText()));
            ((Person) system.getCitiziens().findNode(personBeforeChanges).getData()).setPermResidence(system.findPropertyByRegNumb(Integer.parseInt(regNumTF.getText())));

        }
    }//GEN-LAST:event_saveBTActionPerformed

    private void showBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showBTActionPerformed
        if (system.findPropertyByRegNumb(Integer.parseInt(regNumTF.getText())) != null) {
            Property property = system.findPropertyByRegNumb(Integer.parseInt(regNumTF.getText()));
            Nehnutelnost panel = new Nehnutelnost(mainWindow, system, property);
            Globals.panel.addTab("Nehnuteľnosť " + regNumTF.getText(), panel);
            logika.setLastTab();
        }
    }//GEN-LAST:event_showBTActionPerformed

    private void changePermBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changePermBTActionPerformed
        ChangePermResidence rs = new ChangePermResidence(system, identifNumTF.getText(),this);
    }//GEN-LAST:event_changePermBTActionPerformed

    private void findPropertiesBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findPropertiesBTActionPerformed
        ArrayList<Comparable<Property>> properties = new ArrayList();
        ArrayList<Comparable<Property>> pomProperties = new ArrayList();
        ArrayList<Comparable<PropertyList>> propertyLists = new ArrayList();
        
        system.findPersonByID(Long.parseLong(identifNumTF.getText())).getPropertyLists().inOrderTraverseTreeArray(system.findPersonByID(Long.parseLong(identifNumTF.getText())).getPropertyLists().getRoot(), propertyLists);
        for (int i = 0; i < propertyLists.size(); i++) {
            if (((PropertyList) propertyLists.get(i)).getCadastralArea().getNumbCadArea() == Integer.parseInt(findPropertiesTF.getText())) {
                ((PropertyList) propertyLists.get(i)).getPropertiesOnList().inOrderTraverseTreeArray(((PropertyList) propertyLists.get(i)).getPropertiesOnList().getRoot(), pomProperties);
                for (int j = 0; j < pomProperties.size(); j++) {
                    properties.add(pomProperties.get(j));
                }
                pomProperties.clear();
            }
        }
        jTable1.setModel(new TableModels.ZoznamNehnutelnostiMajitelaTabModel1(properties, identifNumTF.getText()));
    }//GEN-LAST:event_findPropertiesBTActionPerformed

    private void searchAllBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchAllBTActionPerformed
        ArrayList<Comparable<Property>> properties = new ArrayList();
        ArrayList<Comparable<Property>> pomProperties = new ArrayList();
        ArrayList<Comparable<PropertyList>> propertyLists = new ArrayList();
        system.findPersonByID(Long.parseLong(identifNumTF.getText())).getPropertyLists().inOrderTraverseTreeArray(system.findPersonByID(Long.parseLong(identifNumTF.getText())).getPropertyLists().getRoot(), propertyLists);
        for (int i = 0; i < propertyLists.size(); i++) {

            ((PropertyList) propertyLists.get(i)).getPropertiesOnList().inOrderTraverseTreeArray(((PropertyList) propertyLists.get(i)).getPropertiesOnList().getRoot(), pomProperties);
            for (int j = 0; j < pomProperties.size(); j++) {
                properties.add(pomProperties.get(j));
            }
            pomProperties.clear();

        }
        jTable1.setModel(new TableModels.ZoznamNehnutelnostiMajitelaTabModel1(properties, identifNumTF.getText()));
    }//GEN-LAST:event_searchAllBTActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        if (evt.getClickCount() == 2) {

            int selectedRowIndex = jTable2.getSelectedRow();
            String cadastralArea = jTable2.getValueAt(selectedRowIndex, 1).toString();
            String numberPropertyList = jTable2.getValueAt(selectedRowIndex, 0).toString();

            ListVlastnictva panel = new ListVlastnictva(mainWindow, system, system.findPropertyListByNumber(Integer.parseInt(numberPropertyList)));
            Globals.panel.addTab("List vlastníctva " + numberPropertyList, panel);
            logika.setLastTab();
        }
    }//GEN-LAST:event_jTable2MouseClicked

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        if (evt.getClickCount() == 2) {

            int selectedRowIndex = jTable1.getSelectedRow();

            String regNumb = jTable1.getValueAt(selectedRowIndex, 0).toString();
            String adress = jTable1.getValueAt(selectedRowIndex, 1).toString();
            String desc = jTable1.getValueAt(selectedRowIndex, 2).toString();

            
            Nehnutelnost panel = new Nehnutelnost(mainWindow, system, system.findPropertyByRegNumb(Integer.parseInt(regNumb)));
            Globals.panel.addTab("Nehnuteľnosť " + regNumb, panel);
            logika.setLastTab();
        }
    }//GEN-LAST:event_jTable1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBT;
    private javax.swing.JButton changePermBT;
    private javax.swing.JButton editBT;
    private javax.swing.JButton findPropertiesBT;
    private javax.swing.JTextField findPropertiesTF;
    private javax.swing.JTextField identifNumTF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField nameTF;
    private javax.swing.JTextField regNumTF;
    private javax.swing.JButton saveBT;
    private javax.swing.JButton searchAllBT;
    private javax.swing.JButton showBT;
    private javax.swing.JTextField surenameTF;
    // End of variables declaration//GEN-END:variables
}
