package controlador;

import javax.swing.*;
import java.awt.*;

/**
 * Created by a630703 on 01/08/2016.
 */
class CustomRenderer extends javax.swing.table.DefaultTableCellRenderer {
    Color color = Color.WHITE;
    boolean cust = false;
    boolean[][] customColors;

    public CustomRenderer (Color color, boolean center){
        this.color = color;
        if (center){
            this.setHorizontalAlignment( JLabel.CENTER );
        }
    }

    public CustomRenderer (Color color, boolean[][] customColors,boolean center){
        setOpaque(true);
        this.customColors = customColors;
        this.cust = true;
        this.color = color;
        if (center){
            this.setHorizontalAlignment( JLabel.CENTER );
        }
    }

    public CustomRenderer (boolean center){
        if (center){
            this.setHorizontalAlignment( JLabel.CENTER );
        }
    }

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component cellComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        if(cust){
            if (row == 0 && column == 1 || row == 3 && column == 4){//customColors[row][column]){
                cellComponent.setBackground(Color.ORANGE);
            }
            else {
                cellComponent.setBackground(Color.WHITE);
            }
        }else {
            cellComponent.setBackground(color);
        }
        return cellComponent;
    }
}
