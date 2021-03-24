/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author hugov
 */
public class EstiloTabelaRenderer extends DefaultTableCellRenderer{
    private Component componenete;

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        componenete = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); //To change body of generated methods, choose Tools | Templates.       
        this.setHorizontalAlignment(0);
        this.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 1, new java.awt.Color(255, 255, 255)));

        if(row%2 == 0){
            componenete.setForeground(Color.BLACK);
            componenete.setBackground(new Color(255, 255, 255));
        }else{
            componenete.setForeground(Color.BLACK);
            componenete.setBackground(Color.WHITE); //COR SIM E COR 
        }
        if(isSelected){
            componenete.setForeground(new Color(0, 204, 204));
            componenete.setBackground(new Color(255, 255, 255));
            componenete.setFont(new Font("Calibre", Font.BOLD, 16));
        }
        return componenete;
        
    }
    
    
}
