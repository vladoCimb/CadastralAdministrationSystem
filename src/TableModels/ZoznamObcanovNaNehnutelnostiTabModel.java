/*
 * ExperiencesTableModel2.java
 *
 * Created on 31. prosinec 2006, 19:55
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package TableModels;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import AVL.AVLTree;
import mainpackage.Person;

/**
 *
 * @author martin
 */
public class ZoznamObcanovNaNehnutelnostiTabModel extends AbstractTableModel {

    private int colnum = 3;
    private String[] colNames = {
        "Meno", "Priezvisko", "Rodné číslo",};
    private ArrayList<String[]> ResultSets;

    /**
     * Creates a new instance of FoodTableModel
     */
    
    public ZoznamObcanovNaNehnutelnostiTabModel() {
        }

    public ZoznamObcanovNaNehnutelnostiTabModel(AVLTree<Person> tree) {
        if(tree != null){
        ResultSets = new ArrayList<String[]>();

        Person p = new Person();
        for(int i = 0; i < tree.inOrderTraverseTreeArray(tree.getRoot(), null).size();i++){
        if (tree.inOrderTraverseTreeArray(tree.getRoot(), null).get(i) != null) {
            p = (Person) tree.inOrderTraverseTreeArray(tree.getRoot(), null).get(i);

            String[] row = {p.getFirstName(), p.getSurnName(), Long.toString(p.getIdentifNumb())};
            ResultSets.add(row);
        }
        }
        }
    }

        @Override

        public Object getValueAt
        (int rowindex, int columnindex
        
            ) {

        String[] row = ResultSets.get(rowindex);
            return row[columnindex];

        }

        @Override
        public int getRowCount
        
            () {
        return ResultSets.size();
        }

        @Override
        public int getColumnCount
        
            () {
        return colnum;
        }

        @Override
        public String getColumnName
        (int param
        
            ) {

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
