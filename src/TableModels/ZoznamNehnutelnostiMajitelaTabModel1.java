/*
 * ExperiencesTableModel2.java
 *
 * Created on 31. prosinec 2006, 19:55
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package TableModels;

import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import AVL.AVLTree;
import mainpackage.Property;

/**
 *
 * @author martin
 */
public class ZoznamNehnutelnostiMajitelaTabModel1 extends AbstractTableModel {

    private int colnum = 4;
    private String[] colNames = {
        "Súpisné číslo", "Adresa", "Popis","Vlastnícky podiel"};
    private ArrayList<String[]> ResultSets;

    /**
     * Creates a new instance of FoodTableModel
     */
    public ZoznamNehnutelnostiMajitelaTabModel1(ArrayList<Comparable <Property>> tree, String ownerID) {
        ResultSets = new ArrayList<String[]>();

        
        for (int i = 0; i < tree.size(); i++) {
            
                Property p = (Property)tree.get(i);
               
                String[] row = {Integer.toString(p.getRegNumber()), p.getAdress(), p.getDescription(),p.getPropertyList().getOwnership().getPartOfOwner(ownerID)};
                ResultSets.add(row);
            
        }

    }

    @Override

    public Object getValueAt(int rowindex, int columnindex) {

        String[] row = ResultSets.get(rowindex);
        return row[columnindex];

    }

    @Override
    public int getRowCount() {
        return ResultSets.size();
    }

    @Override
    public int getColumnCount() {
        return colnum;
    }

    @Override
    public String getColumnName(int param) {

        return colNames[param];
    }

    public void removeRow2(int[] rows) {

        for (int i = rows.length - 1; i >= 0; i--) {
            ResultSets.remove(rows[i]);
        }

        fireTableDataChanged();

    }

    public void insertRow(Object data) {
        ArrayList list = new ArrayList(3);
        list = (ArrayList) data;

        String[] rows = {list.get(0).toString(), list.get(1).toString(), list.get(2).toString(), list.get(3).toString()};

        ResultSets.add(rows);

        list = null;
        fireTableDataChanged();
    }

    @Override
    public void setValueAt(Object value, int row, int col) {

        String[] tablerow = ResultSets.get(row);
        tablerow[col] = value.toString();

        fireTableCellUpdated(row, col);

    }

    //Nastavenie ci bude bunka editovatelna alebo nie
    @Override
    public boolean isCellEditable(int row, int col) {

        if (col < 12) {
            return false;
        } else {
            return true;
        }

    }
}
