
package mainpackage;

import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;


public class JMenuBarTableModel extends AbstractTableModel {

    private int colnum = 5;
    private String[] colNames = {
        "item_id","menuitem_name", "formular_name","icon_name","menu_icon_name"
    };
    private ArrayList<String[]> ResultSets;

   
    public JMenuBarTableModel() {
    }

    
    
    public void setModel(ResultSet rs) {
        ResultSets = new ArrayList<String[]>();
        try {
            while (rs.next()) {
                String[] row = {rs.getString("item_id"),rs.getString("menuitem_name"), rs.getString("formular_name"), rs.getString("icon_name"), rs.getString("menu_icon_name"), ""};
                ResultSets.add(row);
            }
        } catch (Exception e) {
            System.out.println("Exception in jMenuBar Table Model!");
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

    @Override
    public void setValueAt(Object value, int row, int col) {
        String[] tablerow = ResultSets.get(row);
        tablerow[col] = value.toString();
        fireTableCellUpdated(row, col);
    }

    
    /**
     * Vrati prislusnu hodnotu pre formular podla nazvu formulara
     * @param id
     * @param column
     * @return 
     */
    public Object getMetaData(String id, String column) {
        int colIndex = -1;
        int rowIndex = -1;
        String columnName;
        String[] tablerow;

        //Search the names of columns
        for (int i = 0; i < colnum; i++) {
            if (colNames[i].equals(column)) {
                colIndex = i;
            }
        }

        //Search the rows
        for (int y = 0; y < ResultSets.size(); y++) {
            tablerow = ResultSets.get(y);
            columnName = tablerow[1].toString();
            if (columnName.equals(id)) {
                 rowIndex = y;
            }
        }

        if (rowIndex >= 0) {
            tablerow = ResultSets.get(rowIndex);
            return tablerow[colIndex];
        } else {
            return "";
        }
    }
    
    
    
    /**
     * Vrati prislusnu hodnotu pre formular podla ID formulara
     * @param id
     * @param column
     * @return 
     */
    public Object getMetaData(int id, String column) {
        int colIndex = -1;
        int rowIndex = -1;
        int formID = 0;
        String[] tablerow;

        //Search the names of columns
        for (int i = 0; i < colnum; i++) {
            if (colNames[i].equals(column)) {
                colIndex = i;
            }
        }

        //Search the rows
        for (int y = 0; y < ResultSets.size(); y++) {
            tablerow = ResultSets.get(y);
            formID = Integer.parseInt(tablerow[0].toString());
            if (formID == id) {
                 rowIndex = y;
            }
        }

        if (rowIndex >= 0) {
            tablerow = ResultSets.get(rowIndex);
            return tablerow[colIndex];
        } else {
            return "";
        }
    }
    
    
    
}
