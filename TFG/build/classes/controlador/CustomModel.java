package controlador;

import javax.swing.table.DefaultTableModel;

/**
 * Created by a630703 on 01/08/2016.
 */
class CustomModel extends DefaultTableModel {

    boolean[][] customEdit;
    boolean cust = false;

    public CustomModel(Object[][] data, Object[] columnNames){
        super(data,columnNames);
    }
    Class[] types = new Class [] {
            String.class, String.class, String.class, Object.class, Integer.class
    };
    boolean[] canEdit = new boolean [] {
            false, false, true, true, false
    };

    public Class getColumnClass(int columnIndex) {
        return types [columnIndex];
    }

    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if (cust)
            return customEdit [columnIndex][rowIndex];
        else
            return canEdit [columnIndex];
    }

    public void setEditable(int column, boolean value){
        canEdit[column] = value;
    }

    public void setEditable(int column, int row, boolean value){
        customEdit[column] [row] = value;
    }

    public void setTypes(Class[] types){
        this.types = types;
    }

    void setCanEdit(boolean[] canEdit) {
        this.canEdit = canEdit;
    }

    void setCanEditMatrix(boolean[][] customEdit) {
        this.customEdit = customEdit;
    }

    void setCustom(boolean cust){
        this.cust = cust;
    }
}
